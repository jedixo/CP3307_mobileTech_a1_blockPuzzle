package com.example.jake_.cp3307_a1;

public class SettingsSingleton {
    private static SettingsSingleton instance = null;
    private static String theme = "";

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
}
