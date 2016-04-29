package com.example.jake_.cp3307_a1;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

//make this work as a worker thread
public class Picture  {

    private Bitmap topLeft;
    private Bitmap topRight;
    private Bitmap bottomLeft;
    private Bitmap bottomRight;

    public Picture(Resources res, int i) {
        Bitmap original = BitmapFactory.decodeResource(res, i);
        topLeft = Bitmap.createBitmap(original, 0, 0, original.getWidth() / 2, original.getHeight() / 2);
        topRight = Bitmap.createBitmap(original, original.getWidth() / 2, 0, original.getWidth() / 2, original.getHeight() / 2);
        bottomLeft = Bitmap.createBitmap(original, 0, original.getHeight() / 2, original.getWidth() /2, original.getHeight() /2);
        bottomRight = Bitmap.createBitmap(original, original.getWidth() /2, original.getHeight() / 2, original.getWidth() /2, original.getHeight() /2);
    }

    public Bitmap getTopLeft() {
        return topLeft;
    }

    public Bitmap getTopRight() {
        return topRight;
    }

    public Bitmap getBottomLeft() {
        return bottomLeft;
    }

    public Bitmap getBottomRight() {
        return bottomRight;
    }

}
