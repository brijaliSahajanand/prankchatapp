package ru.fotostrana.socketapp;

import android.app.Application;

public class MyAppDefult extends Application {

    private static MyAppDefult ourInstance = new MyAppDefult();

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        ourInstance = MyAppDefult.this;

    }

    public static MyAppDefult getApp() {
        if (ourInstance == null) {
            ourInstance = new MyAppDefult();
        }
        return ourInstance;
    }


}
