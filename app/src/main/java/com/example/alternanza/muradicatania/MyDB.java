package com.example.alternanza.muradicatania;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class MyDB
{
    static final String KEY_RIGAID = "id";
    static final String KEY_NOME = "nome";
    static final String KEY_DESCRIZIONE = "Descrizione";
    static final String KEY_LONGITUDINE = "Longitudine";
    static final String KEY_LATITUDINE = "Latitudine";
    static final String KEY_IMMAGINE = "Immagine";
    static final String TAG = "MyDB";
    static final String DATABASE_NOME = "Database_monumenti";
    static final String DATABASE_TABELLA = "Monumenti";
    static final int DATABASE_VERSIONE = 1;
    static final String DATABASE_CREAZIONE =
            "CREATE TABLE Monumenti (id integer primary key autoincrement, "
                    + "nome text not null, Descrizione  text not null, Latitudine integer not null, Longitudine integer not null," +
                    "immagine integer not null );";
    final Context context;
    DatabaseHelper DBHelper;
    SQLiteDatabase db;

    public MyDB(Context ctx)
    {
        this.context = ctx;
        DBHelper = new DatabaseHelper(context);
    }

    private static class DatabaseHelper extends SQLiteOpenHelper
    {
        DatabaseHelper(Context context) {
            super(context, DATABASE_NOME, null, DATABASE_VERSIONE);
        }

        @Override
        public void onCreate(SQLiteDatabase db)
        {
            try
            {
                db.execSQL(DATABASE_CREAZIONE);
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
        {
            //Ignora...
        }
    }

    public MyDB open() throws SQLException {
        db = DBHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        DBHelper.close();
    }

    public long inserisciMonumento(String nome, String Descrizione, int Latitudine, int Longitudine, int Immagine)
    {
        ContentValues initialValues = new ContentValues();
        initialValues.put(KEY_NOME, nome);
        initialValues.put(KEY_DESCRIZIONE, Descrizione);
        initialValues.put(KEY_LATITUDINE, Latitudine);
        initialValues.put(KEY_LONGITUDINE, Longitudine);
        initialValues.put(KEY_IMMAGINE, Immagine);
        return db.insert(DATABASE_TABELLA, null, initialValues);
    }
    public boolean cancellaMonumento(long rigaId)
    {
        return db.delete(DATABASE_TABELLA, KEY_RIGAID + "=" + rigaId, null) > 0;
    }
    public Cursor ottieniTuttiMonumenti()
    {
        return db.query(DATABASE_TABELLA, new String[] {KEY_RIGAID, KEY_NOME,
                KEY_DESCRIZIONE, KEY_LATITUDINE, KEY_LONGITUDINE, KEY_IMMAGINE}, null, null, null, null, null);
    }
    public Cursor ottieniMonumento(long rigaId) throws SQLException
    {
        Cursor mCursore = db.query(true, DATABASE_TABELLA, new String[] {KEY_RIGAID,
                KEY_NOME, KEY_DESCRIZIONE, KEY_LATITUDINE, KEY_LONGITUDINE, KEY_IMMAGINE}, KEY_RIGAID + "=" + rigaId, null, null, null, null, null);
        if (mCursore != null) {
            mCursore.moveToFirst();
        }
        return mCursore;
    }

    public boolean aggiornaMonumento(long rigaId, String name,  String Descrizione, int Latitudine, int Longitudine, int Immagine)
    {
        ContentValues args = new ContentValues();
        args.put(KEY_NOME, name);
        args.put(KEY_DESCRIZIONE, Descrizione);
        args.put(KEY_LATITUDINE, Latitudine);
        args.put(KEY_LONGITUDINE, Longitudine);
        args.put(KEY_IMMAGINE, Immagine);
        return db.update(DATABASE_TABELLA, args, KEY_RIGAID + "=" + rigaId, null) > 0;
    }
}