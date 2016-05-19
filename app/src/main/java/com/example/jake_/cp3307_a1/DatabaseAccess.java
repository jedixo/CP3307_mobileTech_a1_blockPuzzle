package com.example.jake_.cp3307_a1;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DatabaseAccess extends SQLiteOpenHelper{

    public DatabaseAccess(Context context) {
        super(context,"performanceData", null, 2);
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
        up.execSQL("DROP TABLE IF EXISTS Performance;");
        up.execSQL("CREATE TABLE performance (_id INTEGER PRIMARY KEY, completed INTEGER, touches INTEGER);");

    }

    public Cursor getAllCursor() {
        return getReadableDatabase().rawQuery("SELECT * FROM Performance;", null);
    }

    public Cursor getCursor(int id) {
        return getReadableDatabase().rawQuery("SELECT * FROM Performance WHERE id = ?", new String[] {id + ""});
    }
}
