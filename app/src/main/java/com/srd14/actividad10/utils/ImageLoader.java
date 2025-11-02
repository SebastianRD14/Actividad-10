package com.srd14.actividad10.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.IOException;
import java.io.InputStream;

// Clase para cargar imagenes externas
public class ImageLoader {
    public static Bitmap loadFromAssets(Context context, String fileName) {
        try (InputStream is = context.getAssets().open(fileName)) {
            return BitmapFactory.decodeStream(is);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
