package com.example.jake_.cp3307_a1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DatabaseAccess extends SQLiteOpenHelper {

    private static int VERSION = 5;
    private static String TABLENAME = "performance";
    private static String DATABASE = "performanceData";

    public DatabaseAccess(Context context) {
        super(context, DATABASE, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        setup(db);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        setup(db);

    }

    private void setup(SQLiteDatabase up) {
        up.execSQL("DROP TABLE IF EXISTS " + TABLENAME + ";");
        up.execSQL("CREATE TABLE " + TABLENAME + " (_id INTEGER PRIMARY KEY, completed INTEGER, tousches INTEGER);");

    }

    public Cursor getAllCursor() {
        return getReadableDatabase().rawQuery("SELECT * FROM " + TABLENAME + ";", null);
    }

    public Cursor getCursor(int id) {
        return getReadableDatabase().rawQuery("SELECT * FROM " + TABLENAME + " WHERE id = ?", new String[]{id + ""});
    }

    public boolean addNewEntry(int comp, int touches) {
        try {
            ContentValues values = new ContentValues();
            values.put("completed", comp);
            values.put("touches", touches);
            getReadableDatabase().insert(TABLENAME, null, values);
            return true;
        } catch (Exception e) {
            System.out.println(e.toString());
            return false;
        }
    }

    public void clearAll() {
        this.getReadableDatabase().execSQL("delete from " + TABLENAME + ";");
    }
}
