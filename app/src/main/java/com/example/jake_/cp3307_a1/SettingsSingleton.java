package com.example.jake_.cp3307_a1;

import android.content.Context;

public class SettingsSingleton {
    private static SettingsSingleton instance = null;
    private static String theme = "";
    private static DatabaseAccess database;

    private SettingsSingleton() {
    }

    public static SettingsSingleton getInstance() {
        if (instance == null) {
            instance = new SettingsSingleton();
        }
        return instance;
    }

    protected static void setTheme(String thm) {
        theme = thm;
    }

    protected static String getTheme() {
        return theme;
    }

    protected static void setDatabase(DatabaseAccess db) {
        database = db;
    }

    protected static DatabaseAccess getDataaseAccess() {
        return database;
    }
}
