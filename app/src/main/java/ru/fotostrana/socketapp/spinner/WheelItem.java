package ru.fotostrana.socketapp.spinner;

import android.graphics.Bitmap;

/**
 * Created by mohamed on 22/04/17.
 */

public class WheelItem {
    public int color;
    public Bitmap bitmap;
    public int number;

    public WheelItem(int color, Bitmap bitmap/*,int number*/) {
        this.color = color;
        this.bitmap = bitmap;
       // this.number =  number;
    }
}