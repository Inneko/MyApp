package com.example.biggy.myapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.ContactsContract;
import android.util.Log;
import android.widget.Toast;

import org.w3c.dom.Comment;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Servis on 9.2.2016.
 */
public class DatabaseHandler extends SQLiteOpenHelper {

    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "servis";

    // Naziv tabele servisnih listova
    private static final String TABLE_SERVISNI_LIST = "servisnilist";

    // Naziv tabele prijavljenih intervencija
    private static final String TABLE_PRIJAVI_INTERVENCIJU = "prijaviintervenciju";

    // Nazivi kolona tabele servisnih listova
    private static final String KEY_ID = "id";
    private static final String KEY_DATUM_SERVISA = "datum_servisa";
    private static final String KEY_SERVISER = "serviser";
    private static final String KEY_SERIJSKI_BROJ = "serijski_broj";
    private static final String KEY_VRSTA_PROIZVODA = "vrsta_proizvoda";
    private static final String KEY_DATUM_KUPOVINE = "datum_kupovine";
    private static final String KEY_DATUM_ISTEKA_GARANCIJE = "datum_isteka_garancije";
    private static final String KEY_KLIJENT = "klijent";
    private static final String KEY_ADRESA = "adresa";
    private static final String KEY_MJESTO = "mjesto";
    private static final String KEY_KONTAKT1 = "kontakt1";
    private static final String KEY_KONTAKT2 = "kontakt2";
    private static final String KEY_PRIMJEDBA_KUPCA = "primjedba_kupca";
    private static final String KEY_OPIS_INTERVENCIJE = "opis_intervencije";
    private static final String KEY_NAPOMENA = "napomena";
    private static final String KEY_KVAR_PODLIJEZE_GARANCIJI = "kvar_podlijeze_garanciji";
    private static final String KEY_TROSKOVI_DIJELOVA = "troskovi_dijelova";
    private static final String KEY_TROSKOVI_RADA = "troskovi_rada";
    private static final String KEY_PUTNI_TROSKOVI = "putni_troskovi";
    private static final String KEY_UKUPNI_TROSKOVI = "ukupni_troskovi";
    private static final String KEY_NACIN_PLACANJA = "nacin_placanja";
    private static final String KEY_STATUS_PLACANJA = "status_placanja";
    private static final String KEY_RAD_SERVISERA = "rad_servisera";
    private static final String KEY_PUT_SERVISERA = "put_servisera";

    // Nazivi kolona tabele prijavljenih intervencija
    private static final String PI_ID = "id";
    private static final String PI_DATUM_PRIJAVE = "datum_prijave";
    private static final String PI_VRSTA_PROIZVODA = "vrsta_proizvoda";
    private static final String PI_SERIJSKI_BROJ = "serijski_broj";
    private static final String PI_KLIJENT = "klijent";
    private static final String PI_ADRESA = "adresa";
    private static final String PI_MJESTO = "mjesto";
    private static final String PI_KONTAKT1 = "kontakt1";
    private static final String PI_KONTAKT2 = "kontakt2";
    private static final String PI_OPIS_KVARA = "opis_kvara";
    private static final String PI_NAPOMENA = "napomena";




    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_SERVISNILIST_TABLE = "CREATE TABLE " + TABLE_SERVISNI_LIST + "("
                + KEY_ID + " INTEGER PRIMARY KEY,"
                + KEY_DATUM_SERVISA + " TEXT,"
                + KEY_SERVISER + " TEXT,"
                + KEY_SERIJSKI_BROJ + " TEXT,"
                + KEY_VRSTA_PROIZVODA + " TEXT,"
                + KEY_DATUM_KUPOVINE + " TEXT,"
                + KEY_DATUM_ISTEKA_GARANCIJE + " TEXT,"
                + KEY_KLIJENT + " TEXT,"
                + KEY_ADRESA + " TEXT,"
                + KEY_MJESTO + " TEXT,"
                + KEY_KONTAKT1 + " TEXT,"
                + KEY_KONTAKT2 + " TEXT,"
                + KEY_PRIMJEDBA_KUPCA + " TEXT,"
                + KEY_OPIS_INTERVENCIJE + " TEXT,"
                + KEY_NAPOMENA + " TEXT,"
                + KEY_KVAR_PODLIJEZE_GARANCIJI + " TEXT,"
                + KEY_TROSKOVI_DIJELOVA + " TEXT,"
                + KEY_TROSKOVI_RADA + " TEXT,"
                + KEY_PUTNI_TROSKOVI + " TEXT,"
                + KEY_UKUPNI_TROSKOVI + " TEXT,"
                + KEY_NACIN_PLACANJA + " TEXT,"
                + KEY_STATUS_PLACANJA + " TEXT,"
                + KEY_RAD_SERVISERA + " TEXT,"
                + KEY_PUT_SERVISERA + " TEXT" + ")";
        String CREATE_PRIJAVIINTERVENCIJU_TABLE = "CREATE TABLE " + TABLE_PRIJAVI_INTERVENCIJU + "("
                + PI_ID + " INTEGER PRIMARY KEY,"
                + PI_DATUM_PRIJAVE + " TEXT,"
                + PI_VRSTA_PROIZVODA + " TEXT,"
                + PI_SERIJSKI_BROJ + " TEXT,"
                + PI_KLIJENT + " TEXT,"
                + PI_ADRESA + " TEXT,"
                + PI_MJESTO + " TEXT,"
                + PI_KONTAKT1 + " TEXT,"
                + PI_KONTAKT2 + " TEXT,"
                + PI_OPIS_KVARA + " TEXT,"
                + PI_NAPOMENA + " TEXT" + ")";
        db.execSQL(CREATE_SERVISNILIST_TABLE);
        db.execSQL(CREATE_PRIJAVIINTERVENCIJU_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SERVISNI_LIST);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PRIJAVI_INTERVENCIJU);

        // Create tables again
        onCreate(db);
    }



    // Dodaj servisni list
    public void dodajSL(String datum_servisa, String serviser, String serijski_broj, String vrsta_proizvoda, String datum_kupovine, String datum_isteka_garancije, String klijent, String adresa, String mjesto,
                        String kontakt1, String kontakt2, String primjedba_kupca, String opis_intervencije, String napomena, String kvar_podlijeze_garanciji, String troskovi_dijelova, String troskovi_rada,
                        String putni_troskovi, String ukupni_troskovi, String nacin_placanja, String status_placanja, String rad_servisera, String put_servisera) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_DATUM_SERVISA, datum_servisa);
        values.put(KEY_SERVISER, serviser);
        values.put(KEY_SERIJSKI_BROJ, serijski_broj);
        values.put(KEY_VRSTA_PROIZVODA, vrsta_proizvoda);
        values.put(KEY_DATUM_KUPOVINE, datum_kupovine);
        values.put(KEY_DATUM_ISTEKA_GARANCIJE, datum_isteka_garancije);
        values.put(KEY_KLIJENT, klijent);
        values.put(KEY_ADRESA, adresa);
        values.put(KEY_MJESTO, mjesto);
        values.put(KEY_KONTAKT1, kontakt1);
        values.put(KEY_KONTAKT2, kontakt2);
        values.put(KEY_PRIMJEDBA_KUPCA, primjedba_kupca);
        values.put(KEY_OPIS_INTERVENCIJE, opis_intervencije);
        values.put(KEY_NAPOMENA, napomena);
        values.put(KEY_KVAR_PODLIJEZE_GARANCIJI, kvar_podlijeze_garanciji);
        values.put(KEY_TROSKOVI_DIJELOVA, troskovi_dijelova);
        values.put(KEY_TROSKOVI_RADA, troskovi_rada);
        values.put(KEY_PUTNI_TROSKOVI, putni_troskovi);
        values.put(KEY_UKUPNI_TROSKOVI, ukupni_troskovi);
        values.put(KEY_NACIN_PLACANJA, nacin_placanja);
        values.put(KEY_STATUS_PLACANJA, status_placanja);
        values.put(KEY_RAD_SERVISERA, rad_servisera);
        values.put(KEY_PUT_SERVISERA, put_servisera);

        // Inserting Row
        db.insert(TABLE_SERVISNI_LIST, null, values);
        db.close(); // Closing database connection
    }

    // Očitaj sve servisne listove
    public List<ServisniList> getAllSL() {
        List<ServisniList> sli = new LinkedList<>();

        // 1. build the query
        String query = "SELECT  * FROM " + TABLE_SERVISNI_LIST;

        // 2. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        // 3. go over each row, build book and add it to list
        ServisniList sl = null;
        if (cursor.moveToFirst()) {
            do {
                sl = new ServisniList();
                //sl.setID(Integer.parseInt(cursor.getString(0)));
                sl.setDatumServisa(cursor.getString(1));
                //sl.setServiser(cursor.getString(2));

                // Add book to books
                sli.add(sl);
            } while (cursor.moveToNext());
        }

        // return books
        return sli;
    }



        // Prijavi intervenciju
        public void prijaviIntervenciju(String datum_prijave, String vrsta_proizvoda, String serijski_broj, String klijent, String adresa, String mjesto, String kontakt1, String kontakt2,
                                        String opis_kvara, String napomena) {
            SQLiteDatabase db = getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put(PI_DATUM_PRIJAVE, datum_prijave);
            values.put(PI_VRSTA_PROIZVODA, vrsta_proizvoda);
            values.put(PI_SERIJSKI_BROJ, serijski_broj);
            values.put(PI_KLIJENT, klijent);
            values.put(PI_ADRESA, adresa);
            values.put(PI_MJESTO, mjesto);
            values.put(PI_KONTAKT1, kontakt1);
            values.put(PI_KONTAKT2, kontakt2);
            values.put(PI_OPIS_KVARA, opis_kvara);
            values.put(PI_NAPOMENA, napomena);

            // Inserting Row
            db.insert(TABLE_PRIJAVI_INTERVENCIJU, null, values);
            db.close(); // Closing database connection
        }


    // Očitaj sve otvorene intervencije
    public List<OtvorenaIntervencija> getSveOtvoreneIntervencije() {
        List<OtvorenaIntervencija> oil = new LinkedList<>();

        String query = "SELECT * FROM " + TABLE_PRIJAVI_INTERVENCIJU;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        OtvorenaIntervencija oi = null;
        if (cursor.moveToFirst()) {
            do {
                oi = new OtvorenaIntervencija();
                oi.setDatumPrijave(cursor.getString(1));
                oi.setVrstaProizvoda(cursor.getString(2));
                oi.setSerijskiBroj(cursor.getString(3));
                oi.setKlijent(cursor.getString(4));
                oi.setAdresa(cursor.getString(5));
                oi.setMjesto(cursor.getString(6));
                oi.setKontakt1(cursor.getString(7));
                oi.setKontakt2(cursor.getString(8));
                oi.setOpisKvara(cursor.getString(9));
                oi.setNapomena(cursor.getString(10));

                oil.add(oi);
            } while (cursor.moveToNext());
        }

        return oil;
    }





































    // Očitaj broj servisnih listova
    public int getContactsCount() {
        String countQuery = "SELECT  * FROM " + TABLE_SERVISNI_LIST;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        // return count
        return cursor.getCount();
    }

/*    // Izmjena servisnog lista
    public int updateContact(ServisniList contact) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_DATUM_SERVISA, contact.getDatumPrijave());
        values.put(KEY_VRSTA_PROIZVODA, contact.getVrstaProizvoda());

        // updating row
        return db.update(TABLE_SERVISNI_LIST, values, KEY_ID + " = ?",
                new String[]{String.valueOf(contact.getID())});
    }*/

/*    // Brisanje servisnog lista
    public void deleteContact(ServisniList contact) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_SERVISNI_LIST, KEY_ID + " = ?",
                new String[]{String.valueOf(contact.getID())});
        db.close();
    }*/

    public ArrayList<Cursor> getData(String Query){
        //get writable database
        SQLiteDatabase sqlDB = this.getWritableDatabase();
        String[] columns = new String[] { "mesage" };
        //an array list of cursor to save two cursors one has results from the query
        //other cursor stores error message if any errors are triggered
        ArrayList<Cursor> alc = new ArrayList<Cursor>(2);
        MatrixCursor Cursor2= new MatrixCursor(columns);
        alc.add(null);
        alc.add(null);


        try{
            String maxQuery = Query ;
            //execute the query results will be save in Cursor c
            Cursor c = sqlDB.rawQuery(maxQuery, null);


            //add value to cursor2
            Cursor2.addRow(new Object[] { "Success" });

            alc.set(1,Cursor2);
            if (null != c && c.getCount() > 0) {


                alc.set(0,c);
                c.moveToFirst();

                return alc ;
            }
            return alc;
        } catch(SQLException sqlEx){
            Log.d("printing exception", sqlEx.getMessage());
            //if any exceptions are triggered save the error message to cursor an return the arraylist
            Cursor2.addRow(new Object[] { ""+sqlEx.getMessage() });
            alc.set(1,Cursor2);
            return alc;
        } catch(Exception ex){

            Log.d("printing exception", ex.getMessage());

            //if any exceptions are triggered save the error message to cursor an return the arraylist
            Cursor2.addRow(new Object[] { ""+ex.getMessage() });
            alc.set(1,Cursor2);
            return alc;
        }


    }


}