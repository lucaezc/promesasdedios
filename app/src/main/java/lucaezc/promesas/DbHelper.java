package lucaezc.promesas;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.Random;

public class DbHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Promesas.db";
    public static final int DATABASE_VERSION = 2;

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        scriptsVersion1(db); // Version 1
        scriptsVersion2(db); // Version 2
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        switch (oldVersion) {
            case 1:
                scriptsDropVersion1(db);
                scriptsVersion1(db);
                scriptsVersion2(db);
        }
    }

    public void scriptsVersion1(SQLiteDatabase db){
        db.execSQL(DataSource.CREATE_VERSION_SCRIPT);
        db.execSQL(DataSource.CREATE_LIBRO_SCRIPT);
        db.execSQL(DataSource.CREATE_VERSICULO_SCRIPT);
        db.execSQL(DataSource.CREATE_PROMESA_SCRIPT);
        db.execSQL(DataSource.INSERT_VERSION_SCRIPT);
        db.execSQL(DataSource.INSERT_LIBRO_SCRIPT);
        db.execSQL(DataSource.INSERT_VERSICULO_RVR60_SCRIPT);
        db.execSQL(DataSource.INSERT_VERSICULO_NVI_SCRIPT);
        db.execSQL(DataSource.INSERT_VERSICULO_TLA_SCRIPT);
        db.execSQL(DataSource.INSERT_VERSICULO_NTV_SCRIPT);
        db.execSQL(DataSource.INSERT_VERSICULO_KJV_SCRIPT);
        db.execSQL(DataSource.INSERT_PROMESA_RVR60_SCRIPT);
        db.execSQL(DataSource.INSERT_PROMESA_NVI_SCRIPT);
        db.execSQL(DataSource.INSERT_PROMESA_TLA_SCRIPT);
        db.execSQL(DataSource.INSERT_PROMESA_NTV_SCRIPT);
        db.execSQL(DataSource.INSERT_PROMESA_KJV_SCRIPT);
    }

    public void scriptsVersion2(SQLiteDatabase db){
        db.execSQL(DataSource.CREATE_TEMA_SCRIPT);
        db.execSQL(DataSource.CREATE_PROMESA_TEMA_SCRIPT);
        db.execSQL(DataSource.INSERT_TEMA_SCRIPT);

        db.execSQL(DataSource.INSERT_VERSICULO_TEMA_AMOR_RVR60_SCRIPT);
        db.execSQL(DataSource.INSERT_VERSICULO_TEMA_AMOR_NVI_SCRIPT);
        db.execSQL(DataSource.INSERT_VERSICULO_TEMA_AMOR_TLA_SCRIPT);
        db.execSQL(DataSource.INSERT_VERSICULO_TEMA_AMOR_NTV_SCRIPT);
        db.execSQL(DataSource.INSERT_VERSICULO_TEMA_AMOR_KJV_SCRIPT);
        db.execSQL(DataSource.INSERT_PROMESA_TEMA_AMOR_RVR60_SCRIPT);
        db.execSQL(DataSource.INSERT_PROMESA_TEMA_AMOR_NVI_SCRIPT);
        db.execSQL(DataSource.INSERT_PROMESA_TEMA_AMOR_TLA_SCRIPT);
        db.execSQL(DataSource.INSERT_PROMESA_TEMA_AMOR_NTV_SCRIPT);
        db.execSQL(DataSource.INSERT_PROMESA_TEMA_AMOR_KJV_SCRIPT);

        db.execSQL(DataSource.INSERT_VERSICULO_TEMA_ARREPENTIMIENTO_RVR60_SCRIPT);
        db.execSQL(DataSource.INSERT_VERSICULO_TEMA_ARREPENTIMIENTO_NVI_SCRIPT);
        db.execSQL(DataSource.INSERT_VERSICULO_TEMA_ARREPENTIMIENTO_TLA_SCRIPT);
        db.execSQL(DataSource.INSERT_VERSICULO_TEMA_ARREPENTIMIENTO_NTV_SCRIPT);
        db.execSQL(DataSource.INSERT_VERSICULO_TEMA_ARREPENTIMIENTO_KJV_SCRIPT);
        db.execSQL(DataSource.INSERT_PROMESA_TEMA_ARREPENTIMIENTO_RVR60_SCRIPT);
        db.execSQL(DataSource.INSERT_PROMESA_TEMA_ARREPENTIMIENTO_NVI_SCRIPT);
        db.execSQL(DataSource.INSERT_PROMESA_TEMA_ARREPENTIMIENTO_TLA_SCRIPT);
        db.execSQL(DataSource.INSERT_PROMESA_TEMA_ARREPENTIMIENTO_NTV_SCRIPT);
        db.execSQL(DataSource.INSERT_PROMESA_TEMA_ARREPENTIMIENTO_KJV_SCRIPT);

        db.execSQL(DataSource.INSERT_VERSICULO_TEMA_PACIENCIA_RVR60_SCRIPT);
        db.execSQL(DataSource.INSERT_VERSICULO_TEMA_PACIENCIA_NVI_SCRIPT);
        db.execSQL(DataSource.INSERT_VERSICULO_TEMA_PACIENCIA_TLA_SCRIPT);
        db.execSQL(DataSource.INSERT_VERSICULO_TEMA_PACIENCIA_NTV_SCRIPT);
        db.execSQL(DataSource.INSERT_VERSICULO_TEMA_PACIENCIA_KJV_SCRIPT);
        db.execSQL(DataSource.INSERT_PROMESA_TEMA_PACIENCIA_RVR60_SCRIPT);
        db.execSQL(DataSource.INSERT_PROMESA_TEMA_PACIENCIA_NVI_SCRIPT);
        db.execSQL(DataSource.INSERT_PROMESA_TEMA_PACIENCIA_TLA_SCRIPT);
        db.execSQL(DataSource.INSERT_PROMESA_TEMA_PACIENCIA_NTV_SCRIPT);
        db.execSQL(DataSource.INSERT_PROMESA_TEMA_PACIENCIA_KJV_SCRIPT);

        db.execSQL(DataSource.INSERT_VERSICULO_TEMA_PERDON_RVR60_SCRIPT);
        db.execSQL(DataSource.INSERT_VERSICULO_TEMA_PERDON_NVI_SCRIPT);
        db.execSQL(DataSource.INSERT_VERSICULO_TEMA_PERDON_TLA_SCRIPT);
        db.execSQL(DataSource.INSERT_VERSICULO_TEMA_PERDON_NTV_SCRIPT);
        db.execSQL(DataSource.INSERT_VERSICULO_TEMA_PERDON_KJV_SCRIPT);
        db.execSQL(DataSource.INSERT_PROMESA_TEMA_PERDON_RVR60_SCRIPT);
        db.execSQL(DataSource.INSERT_PROMESA_TEMA_PERDON_NVI_SCRIPT);
        db.execSQL(DataSource.INSERT_PROMESA_TEMA_PERDON_TLA_SCRIPT);
        db.execSQL(DataSource.INSERT_PROMESA_TEMA_PERDON_NTV_SCRIPT);
        db.execSQL(DataSource.INSERT_PROMESA_TEMA_PERDON_KJV_SCRIPT);

        db.execSQL(DataSource.INSERT_VERSICULO_TEMA_HUMILDAD_RVR60_SCRIPT);
        db.execSQL(DataSource.INSERT_VERSICULO_TEMA_HUMILDAD_NVI_SCRIPT);
        db.execSQL(DataSource.INSERT_VERSICULO_TEMA_HUMILDAD_TLA_SCRIPT);
        db.execSQL(DataSource.INSERT_VERSICULO_TEMA_HUMILDAD_NTV_SCRIPT);
        db.execSQL(DataSource.INSERT_VERSICULO_TEMA_HUMILDAD_KJV_SCRIPT);
        db.execSQL(DataSource.INSERT_PROMESA_TEMA_HUMILDAD_RVR60_SCRIPT);
        db.execSQL(DataSource.INSERT_PROMESA_TEMA_HUMILDAD_NVI_SCRIPT);
        db.execSQL(DataSource.INSERT_PROMESA_TEMA_HUMILDAD_TLA_SCRIPT);
        db.execSQL(DataSource.INSERT_PROMESA_TEMA_HUMILDAD_NTV_SCRIPT);
        db.execSQL(DataSource.INSERT_PROMESA_TEMA_HUMILDAD_KJV_SCRIPT);

        db.execSQL(DataSource.INSERT_VERSICULO_TEMA_SABIDURIA_RVR60_SCRIPT);
        db.execSQL(DataSource.INSERT_VERSICULO_TEMA_SABIDURIA_NVI_SCRIPT);
        db.execSQL(DataSource.INSERT_VERSICULO_TEMA_SABIDURIA_TLA_SCRIPT);
        db.execSQL(DataSource.INSERT_VERSICULO_TEMA_SABIDURIA_NTV_SCRIPT);
        db.execSQL(DataSource.INSERT_VERSICULO_TEMA_SABIDURIA_KJV_SCRIPT);
        db.execSQL(DataSource.INSERT_PROMESA_TEMA_SABIDURIA_RVR60_SCRIPT);
        db.execSQL(DataSource.INSERT_PROMESA_TEMA_SABIDURIA_NVI_SCRIPT);
        db.execSQL(DataSource.INSERT_PROMESA_TEMA_SABIDURIA_TLA_SCRIPT);
        db.execSQL(DataSource.INSERT_PROMESA_TEMA_SABIDURIA_NTV_SCRIPT);
        db.execSQL(DataSource.INSERT_PROMESA_TEMA_SABIDURIA_KJV_SCRIPT);
    }

    public void scriptsDropVersion1(SQLiteDatabase db){
        db.execSQL(DataSource.DROP_TABLE_PROMESA_SCRIPT);
        db.execSQL(DataSource.DROP_TABLE_VERSICULO_SCRIPT);
        db.execSQL(DataSource.DROP_TABLE_LIBRO_SCRIPT);
        db.execSQL(DataSource.DROP_TABLE_VERSION_SCRIPT);
    }

    public void scriptsDropVersion2(SQLiteDatabase db){
        db.execSQL(DataSource.DROP_TABLE_TEMA_SCRIPT);
        db.execSQL(DataSource.DROP_TABLE_PROMESA_TEMA_SCRIPT);
    }

    public Cursor recibirPromesa(Context context, Integer nroPromesa, Integer versionBiblia, Integer tema){
        Cursor fila = null;
        Integer cantPromesas = null;
        if (tema.equals(0)){
            fila = queryPromesa(nroPromesa, versionBiblia);
            cantPromesas = context.getResources().getInteger(R.integer.cantPromesas);
        }else{
            fila = queryPromesaTema(nroPromesa, versionBiblia, tema);
            cantPromesas = context.getResources().getInteger(R.integer.cantPromesasTema);
        }

        Integer c = fila.getCount();
        while (c.equals(0)){
            Random r = new Random();
            Integer otroNroPromesa = r.nextInt(cantPromesas) + 1; // random.nextInt(max - min + 1) + min

            if (tema.equals(0)){
                fila = queryPromesa(otroNroPromesa, versionBiblia);
            }else{
                fila = queryPromesaTema(otroNroPromesa, versionBiblia, tema);
            }
            c = fila.getCount();
        }
        return fila;
    }

    public Cursor queryPromesa(Integer nroPromesa, Integer versionBiblia){
        SQLiteDatabase bd = this.getReadableDatabase();

        return bd.rawQuery("SELECT v." + DataSource.VersiculoCampos.VERSICULO_TEXTO + ", l." + DataSource.LibroCampos.LIBRO_NOMBRE + ", v." + DataSource.VersiculoCampos.VERSICULO_CAPITULO + ", v." + DataSource.VersiculoCampos.VERSICULO_NRO +
                " FROM " + DataSource.VERSICULO_TABLE_NAME +
                " v JOIN " + DataSource.PROMESA_TABLE_NAME + " p ON p." + DataSource.PromesaCampos.PROMESA_VERSICULO + " = v." + DataSource.VersiculoCampos.VERSICULO_ID +
                " JOIN " + DataSource.LIBRO_TABLE_NAME + " l ON l." + DataSource.LibroCampos.LIBRO_ID + " = v." + DataSource.VersiculoCampos.VERSICULO_LIBRO +
                " WHERE v." + DataSource.VersiculoCampos.VERSICULO_VERSION + " = " + String.valueOf(versionBiblia) +
                " AND p." + DataSource.PromesaCampos.PROMESA_ID + " = " + String.valueOf(nroPromesa), null);
    }

    public Cursor queryPromesaTema(Integer nroPromesa, Integer versionBiblia, Integer tema){
        SQLiteDatabase bd = this.getReadableDatabase();
        Cursor a = bd.rawQuery("SELECT p." + DataSource.PromesaTemaCampos.PROMESA_TEMA_VERSICULO +
                " FROM " + DataSource.PROMESA_TEMA_TABLE_NAME +
                " p WHERE p." + DataSource.PromesaTemaCampos.PROMESA_TEMA_ID + " = " + String.valueOf(nroPromesa) +
                " AND p." + DataSource.PromesaTemaCampos.PROMESA_TEMA_ID_TEMA + " = " + String.valueOf(tema), null);

        String versiculoPromesa = null;

        if (a.moveToFirst()) {
            versiculoPromesa = a.getString(0);
        }
        a.close();

        return bd.rawQuery("SELECT v." + DataSource.VersiculoCampos.VERSICULO_TEXTO + ", l." + DataSource.LibroCampos.LIBRO_NOMBRE + ", v." + DataSource.VersiculoCampos.VERSICULO_CAPITULO + ", v." + DataSource.VersiculoCampos.VERSICULO_NRO +
                        " FROM " + DataSource.VERSICULO_TABLE_NAME +
                        " v JOIN " + DataSource.LIBRO_TABLE_NAME + " l ON l." + DataSource.LibroCampos.LIBRO_ID + " = v." + DataSource.VersiculoCampos.VERSICULO_LIBRO +
                        " WHERE v." + DataSource.VersiculoCampos.VERSICULO_VERSION + " = " + String.valueOf(versionBiblia) +
                        " AND v." + DataSource.VersiculoCampos.VERSICULO_ID + " = " + versiculoPromesa, null);
    }

    public Cursor obtenerVersiones(){
        SQLiteDatabase bd = this.getReadableDatabase();
        return bd.rawQuery("SELECT " + DataSource.VersionCampos.VERSION_ID + ", " + DataSource.VersionCampos.VERSION_NOMBRE + " FROM " + DataSource.VERSION_TABLE_NAME, null);
    }

    public Cursor obtenerCodigoVersion(Integer version){
        SQLiteDatabase bd = this.getReadableDatabase();
        return bd.rawQuery("SELECT " + DataSource.VersionCampos.VERSION_CODIGO + " FROM " + DataSource.VERSION_TABLE_NAME + " WHERE " + DataSource.VersionCampos.VERSION_ID + " = " + String.valueOf(version), null);
    }

    public Cursor obtenerTemas(){
        SQLiteDatabase bd = this.getReadableDatabase();
        return bd.rawQuery("SELECT " + DataSource.TemaCampos.TEMA_ID + ", " + DataSource.TemaCampos.TEMA_NOMBRE + " FROM " + DataSource.TEMA_TABLE_NAME, null);
    }
}