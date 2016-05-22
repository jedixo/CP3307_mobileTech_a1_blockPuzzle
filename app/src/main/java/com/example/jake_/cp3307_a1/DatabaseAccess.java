package com.example.jake_.cp3307_a1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Database access controller
 */
public class DatabaseAccess extends SQLiteOpenHelper {

    private static int VERSION = 6;
    private static String TABLENAME = "performance";
    private static String DATABASE = "performanceData";

    /**
     * Initiator that sets up access to the database
     *
     * @param context the context of the activities
     */
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

    /**
     * Setup - creates a table if none exists and sets it uo
     *
     * @param db - the database handle
     */
    private void setup(SQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLENAME + ";");
        db.execSQL("CREATE TABLE " + TABLENAME + " (_id INTEGER PRIMARY KEY, touches INTEGER);");
    }

    /**
     * getAllCursor - gets every row from the table
     *
     * @return - returns a cursor containing all rows
     */
    public Cursor getAllCursor() {
        return getReadableDatabase().rawQuery("SELECT * FROM " + TABLENAME + ";", null);
    }

    /**
     * addNewEntry - adds a new entry to the db
     *
     * @param touches - number of touches to record
     * @return - returns if the operation succeeded or not
     */
    public boolean addNewEntry(int touches) {
        try {
            ContentValues values = new ContentValues();
            values.put("touches", touches);
            getReadableDatabase().insert(TABLENAME, null, values);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * clearAll - deletes everything form the table
     */
    public void clearAll() {
        this.getReadableDatabase().execSQL("delete from " + TABLENAME + ";");
    }
}
