package lucaezc.promesas;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;

import java.util.Locale;
import java.util.Random;

public class MenuPrincipal extends AppCompatActivity {

    Integer versionBiblia = 1;
    Integer tema = 0;
    Locale spanish = new Locale("es", "ES");
    Locale idioma = spanish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);

        creaSpVersiones();
        creaSpTemas();
        fondoAleatorio();

        CheckBox cbTema = (CheckBox) this.findViewById(R.id.cbTema);
        Spinner spTemas = (Spinner) findViewById(R.id.spTemas);
        cbTema.setChecked(false);
        spTemas.setVisibility(View.INVISIBLE);

        cbTema.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Spinner spTemas = (Spinner) findViewById(R.id.spTemas);
                if (isChecked){
                    spTemas.setEnabled(true);
                    spTemas.setVisibility(View.VISIBLE);
                }else{
                    spTemas.setEnabled(false);
                    spTemas.setVisibility(View.INVISIBLE);
                    tema = 0;
                }
            }
        });
    }

    public void creaSpVersiones(){ // Crea dropdown (spinner) con las versiones
        Spinner spinner = (Spinner) findViewById(R.id.spVersiones);
        DbHelper dbHelper = new DbHelper(this);

        SimpleCursorAdapter spinnerAdapter = new SimpleCursorAdapter(this,
                R.layout.spinner_custom,
                dbHelper.obtenerVersiones(),
                new String[]{DataSource.VersionCampos.VERSION_NOMBRE},
                new int[]{android.R.id.text1},
                SimpleCursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);

        spinnerAdapter.setDropDownViewResource(R.layout.spinner_custom_item);
        spinner.setAdapter(spinnerAdapter);
        spinner.setOnItemSelectedListener(new spVersionesListener());
    }

    public class spVersionesListener implements AdapterView.OnItemSelectedListener {
        public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
            versionBiblia = pos + 1;
//            String valorSeleccionado = parent.getSelectedItem().toString();
//            cambiaIdioma(valorSeleccionado);
        }
        public void onNothingSelected(AdapterView parent) {
        }
    }

    public void creaSpTemas(){ // Crea dropdown (spinner) con los temas
        Spinner spinner = (Spinner) findViewById(R.id.spTemas);
        DbHelper dbHelper = new DbHelper(this);

        SimpleCursorAdapter spinnerAdapter = new SimpleCursorAdapter(this,
                R.layout.spinner_custom,
                dbHelper.obtenerTemas(),
                new String[]{DataSource.TemaCampos.TEMA_NOMBRE},
                new int[]{android.R.id.text1},
                SimpleCursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);

        spinnerAdapter.setDropDownViewResource(R.layout.spinner_custom_item);
        spinner.setAdapter(spinnerAdapter);
        spinner.setOnItemSelectedListener(new spTemasListener());
    }

    public class spTemasListener implements AdapterView.OnItemSelectedListener {
        public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
            tema = pos + 1;
        }
        public void onNothingSelected(AdapterView parent) {
        }
    }

    public void recibirPromesa(View v){
        Integer cantPromesas;
        CheckBox cbTema = (CheckBox) this.findViewById(R.id.cbTema);
        if (!cbTema.isChecked()){
            cantPromesas = getResources().getInteger(R.integer.cantPromesas);
            tema = 0;
        }else{
            cantPromesas = getResources().getInteger(R.integer.cantPromesasTema);
        }

        Random r = new Random();
        Integer nroPromesa = r.nextInt(cantPromesas) + 1; // random.nextInt(max - min + 1) + min
        DbHelper helper = new DbHelper(this);
        Context context = getApplicationContext();
        Cursor fila = helper.recibirPromesa(context, nroPromesa, versionBiblia, tema);

        String versiculoPromesa = "", palabraPromesa = "";

        if (fila.moveToFirst()) {
            versiculoPromesa = fila.getString(1) + " " + fila.getString(2) + ":" + fila.getString(3);
            palabraPromesa = fila.getString(0);

            Cursor filaVer = helper.obtenerCodigoVersion(versionBiblia);
            if (filaVer.moveToFirst()) {
                versiculoPromesa = versiculoPromesa + " " + filaVer.getString(0);
            }
            filaVer.close();
        }
        fila.close();

        Intent intent = new Intent(this, RecepcionPromesa.class);
        intent.putExtra("PALABRA_RECIBIDA", palabraPromesa);
        intent.putExtra("VERSICULO_PALABRA_RECIBIDA", versiculoPromesa);
        startActivity(intent);
    }

    public void fondoAleatorio(){
        // Obtiene un fondo aleatorio de un array de los resources para fondos
        ConstraintLayout layout = (ConstraintLayout) findViewById(R.id.activity_menu_principal);
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

    @Override
    public void onBackPressed() {
        finish();
    }

/*    public void cambiaIdioma(String valorSpinnerVersion){
        String[] aVersionesEN = getResources().getStringArray(R.array.versionesEN);
        String[] aVersionesES = getResources().getStringArray(R.array.versionesES);

        for (int i = 0; i < aVersionesEN.length; i++) {
            if (valorSpinnerVersion.equals(aVersionesEN[i])){
                idioma = Locale.ENGLISH;
            }
        }
        for (int i = 0; i < aVersionesES.length; i++) {
            if (valorSpinnerVersion.equals(aVersionesES[i])){
                idioma = spanish;
            }
        }
        Configuration configuration = getResources().getConfiguration();
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        configuration.setLocale(idioma);
        getResources().updateConfiguration(configuration,displayMetrics);
    }*/
}

