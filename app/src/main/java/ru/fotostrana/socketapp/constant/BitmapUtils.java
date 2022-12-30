package ru.fotostrana.socketapp.constant;

import android.graphics.Bitmap;

import java.nio.ByteBuffer;

public class BitmapUtils {
    public static float getTransparentPixelPercent(Bitmap bitmap) {
        if (bitmap == null) {
            return 0f;
        }
        ByteBuffer buffer = ByteBuffer.allocate(bitmap.getHeight() * bitmap.getRowBytes());
        bitmap.copyPixelsToBuffer(buffer);
        byte[] array = buffer.array();
        int len = array.length;
        int count = 0;
        for(int i=0;i<len;i++) {
            if(array[i] == 0) {
                count++;
            }
        }
        return ((float)(count))/len;
    }
}