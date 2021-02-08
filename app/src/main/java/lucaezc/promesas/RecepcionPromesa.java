package lucaezc.promesas;

import android.Manifest;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

public class RecepcionPromesa extends AppCompatActivity {

    String palabraValidacion, versiculoValidacion, tituloPromesas, linkPromesas, nombreAplicacion, promesaImagenPath, extensionImagenPath = null;

    public static final int MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE = 1;
    public static final int MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promesa);

        fondoAleatorio();

        String palabraRecibida = getIntent().getStringExtra("PALABRA_RECIBIDA");
        String versiculoRecibido = getIntent().getStringExtra("VERSICULO_PALABRA_RECIBIDA");

        palabraValidacion = getResources().getString(R.string.palabra);
        versiculoValidacion = getResources().getString(R.string.versiculo);
        tituloPromesas = getResources().getString(R.string.tituloPromesas);
        linkPromesas = getResources().getString(R.string.linkPromesas);
        nombreAplicacion = getResources().getString(R.string.app_name);
        promesaImagenPath = getResources().getString(R.string.promesaImagenPath);
        extensionImagenPath = getResources().getString(R.string.extensionImagenPath);

        TextView tvPalabra = (TextView) findViewById(R.id.tvPalabra);
        TextView tvVersiculo = (TextView) findViewById(R.id.tvVersiculo);
        tvPalabra.setText(palabraRecibida);
        tvVersiculo.setText(versiculoRecibido);
    }

    public void volver(View v){
        finish();
    }

    public void compartirPromesa(View v){ // Compartir promesa (texto)

        Animation animationOut = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_out_animation);
        v.startAnimation(animationOut);

        TextView palabra = (TextView) findViewById(R.id.tvPalabra);
        TextView versiculo = (TextView) findViewById(R.id.tvVersiculo);

        if (!(palabra.getText().toString().equals(palabraValidacion)) && !(versiculo.getText().toString().equals(versiculoValidacion))) { // Valida que se haya recibido previamente una palabra
            String mensaje = palabra.getText().toString() + "\n" + "\n" + versiculo.getText().toString() + "\n" + "\n" + tituloPromesas + "\n" + linkPromesas;
            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT, mensaje);
            sendIntent.setType("text/plain");
            startActivity(sendIntent);
        }else{
            Toast.makeText(getApplicationContext(), R.string.advertenciaCompartir, Toast.LENGTH_SHORT).show();
        }
    }

    public void copiarPortapapeles(View v){ // Copia la promesa al portapapeles

        Animation animationOut = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_out_animation);
        v.startAnimation(animationOut);

        TextView palabra = (TextView) findViewById(R.id.tvPalabra);
        TextView versiculo = (TextView) findViewById(R.id.tvVersiculo);

        if (!(palabra.getText().toString().equals(palabraValidacion)) && !(versiculo.getText().toString().equals(versiculoValidacion))) { // Valida que se haya recibido previamente una palabra
            String textoCopiado = palabra.getText().toString() + "\n" + "\n" + versiculo.getText().toString() + "\n" + "\n" + tituloPromesas + "\n" + linkPromesas;

            ClipboardManager clipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
            ClipData clip = ClipData.newPlainText("", textoCopiado);
            clipboard.setPrimaryClip(clip);

            Toast.makeText(getApplicationContext(), getResources().getString(R.string.mensajeCopiarPortapapeles), Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(getApplicationContext(), R.string.advertenciaCopiar, Toast.LENGTH_SHORT).show();
        }
    }

    public void descargarImagen(View v){ // Guarda la promesa como imagen, luego pregunta si se desea boton_compartir

        Animation animationOut = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_out_animation);
        v.startAnimation(animationOut);

        TextView palabra = (TextView) findViewById(R.id.tvPalabra);
        TextView versiculo = (TextView) findViewById(R.id.tvVersiculo);
        String textoCompartirImagen = palabra.getText().toString() + "\n" + "\n" + versiculo.getText().toString();

        if (!(palabra.getText().toString().equals(palabraValidacion)) && !(versiculo.getText().toString().equals(versiculoValidacion))) { // Valida que se haya recibido previamente una palabra
            TypedArray imgs = getResources().obtainTypedArray(R.array.imagenesCompartir);
            Random r = new Random();
            int rndInt = r.nextInt(imgs.length());
            int resource = imgs.getResourceId(rndInt, -1);
            imgs.recycle();
            Bitmap bitmapCreado = this.drawMultilineTextToBitmap(getApplicationContext(), resource, textoCompartirImagen);

            this.checkGrantPermissions(); // Checkea permisos de escritura y lectura, si no los tiene los pide

            // Crea el directorio donde se van a guardar las imagenes
            String directorioImagenesPath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES) + File.separator + nombreAplicacion;
            File directorioImagenes = new File(directorioImagenesPath);
            if (!directorioImagenes.exists()) {
                Boolean creado = directorioImagenes.mkdir();
            }

            // Nombre del archivo imagen
            Date currentDate = Calendar.getInstance().getTime();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("ddMMyyyyhhmmss", Locale.ENGLISH);
            String nombreArchivo = promesaImagenPath + simpleDateFormat.format(currentDate) + extensionImagenPath;

            try {
                final String mPath = directorioImagenesPath + File.separator + nombreArchivo; // Path completo (directorio + archivo)

                // Crea el archivo a grabar
                File imageFile = new File(directorioImagenes.getAbsolutePath(), nombreArchivo);
                FileOutputStream outputStream = null;
                outputStream = new FileOutputStream(imageFile);
                int quality = 100;
                bitmapCreado.compress(Bitmap.CompressFormat.JPEG, quality, outputStream); // Guarda el bitmap recortado en el archivo
                // Graba archivo y lo cierra
                outputStream.flush();
                outputStream.close();

                // Graba la metadata de la imagen guardada (para que aparezca en la galería)
                ContentValues values = new ContentValues();
                values.put(MediaStore.Images.Media.TITLE, nombreArchivo);
                values.put(MediaStore.Images.Media.DESCRIPTION, nombreArchivo);
                values.put(MediaStore.Images.Media.DATE_TAKEN, System.currentTimeMillis ());
                values.put(MediaStore.Images.ImageColumns.BUCKET_ID, imageFile.toString().toLowerCase(Locale.US).hashCode());
                values.put(MediaStore.Images.ImageColumns.BUCKET_DISPLAY_NAME, imageFile.getName().toLowerCase(Locale.US));
                values.put("_data", imageFile.getAbsolutePath());
                ContentResolver cr = getContentResolver();
                cr.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);

                Toast.makeText(getApplicationContext(), R.string.guardadoImagen, Toast.LENGTH_LONG).show();

                final Uri contentUri = FileProvider.getUriForFile(getApplicationContext(), "${applicationId}.provider", imageFile);

                // Abre el diálogo de alerta para preguntar si se desea boton_compartir la promesa
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
                alertDialogBuilder.setTitle("");
                alertDialogBuilder
                        .setMessage(R.string.preguntaCompartir)
                        .setCancelable(false)
                        .setPositiveButton("Yes",new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) { // Si es "SI" comparte la imagen
                                Intent compartirIntent = new Intent(android.content.Intent.ACTION_SEND);
                                compartirIntent.setType("image*//*");
                                compartirIntent.putExtra(Intent.EXTRA_STREAM, contentUri);
                                startActivity(Intent.createChooser(compartirIntent, getResources().getString(R.string.tituloCompartir)));
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) { // Si es "NO" cierra el cuadro de diálogo
                                dialog.cancel();
                            }
                        });
                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();

            } catch (Throwable e) {
                e.printStackTrace();
            }
        }else{
            Toast.makeText(getApplicationContext(), R.string.advertenciaCompartir, Toast.LENGTH_SHORT).show();
        }

    }

    public Bitmap drawMultilineTextToBitmap(Context gContext, int gResId, String gText) {
        // Prepare canvas
        Resources resources = gContext.getResources();
        float scale = resources.getDisplayMetrics().density;
        Bitmap bitmap = BitmapFactory.decodeResource(resources, gResId);

        android.graphics.Bitmap.Config bitmapConfig = bitmap.getConfig();
        if(bitmapConfig == null) {  // Set default bitmap config if none
            bitmapConfig = android.graphics.Bitmap.Config.ARGB_8888;
        }
        bitmap = bitmap.copy(bitmapConfig, true); // resource bitmaps are imutable, so we need to convert it to mutable one

        Canvas canvas = new Canvas(bitmap);
        TextPaint paint = new TextPaint(Paint.ANTI_ALIAS_FLAG);         // New antialiased Paint
        paint.setColor(Color.rgb(61, 61, 61));         // Text color
        paint.setTextSize((int) (50 * scale));         // Text size in pixels
        paint.setShadowLayer(1f, 0f, 1f, Color.WHITE); // Text shadow

        int textWidth = canvas.getWidth() - (int) (16 * scale); // set text width to canvas width minus 16dp padding

        // Init StaticLayout for text
        StaticLayout textLayout = new StaticLayout(gText, paint, textWidth, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, false);

        int textHeight = textLayout.getHeight();         // Get height of multiline text

        // Get position of text's top left corner
        float x = (float)(bitmap.getWidth() - textWidth)/2;
        float y = (float)(bitmap.getHeight() - textHeight)/2;

        // Draw text to the Canvas center
        canvas.save();
        canvas.translate(x, y);
        textLayout.draw(canvas);
        canvas.restore();

        return bitmap;
    }

    public void fondoAleatorio(){
        // Obtiene un fondo aleatorio de un array de los resources para fondos
        ConstraintLayout layout = (ConstraintLayout) findViewById(R.id.activity_promesa);
        TypedArray imgs = getResources().obtainTypedArray(R.array.fondos);
        Random r = new Random();
        Bitmap bmImg = null;
        while (bmImg == null){
            int rndInt = r.nextInt(imgs.length());
            Integer resource = imgs.getResourceId(rndInt, -1);
            while (resource.equals(0)){
                rndInt = r.nextInt(imgs.length());
                resource = imgs.getResourceId(rndInt, -1);
            }

            // Decodifica el resource y lo adecúa para que no pese tanto
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeResource(getResources(), resource, options);
            options.inSampleSize = 8;
            options.inJustDecodeBounds = false;
            bmImg = BitmapFactory.decodeResource(getResources(), resource, options);
        }
        imgs.recycle();
        Drawable d = new BitmapDrawable(getResources(), bmImg); // Convierte el bitmap en drawable
        layout.setBackground(d); // Setea el drawable como fondo del layout principal
    }

    private void checkGrantPermissions(){ // Checkea permisos, si no los tiene los pide
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE);
        }
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE);
        }
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
