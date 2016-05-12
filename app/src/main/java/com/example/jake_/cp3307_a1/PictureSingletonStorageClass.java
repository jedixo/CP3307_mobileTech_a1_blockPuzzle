package com.example.jake_.cp3307_a1;

import android.graphics.Bitmap;
import android.widget.ImageView;

import java.util.ArrayList;

public class PictureSingletonStorageClass {

    private static PictureWorker worker;
    private static ImageView topLeft, topRight, bottomLeft, bottomRight;
    private static ArrayList<Bitmap> topLeftBitmaps = new ArrayList<>();
    private static ArrayList<Bitmap> topRightBitmaps = new ArrayList<>();
    private static ArrayList<Bitmap> bottomLeftBitmaps = new ArrayList<>();
    private static ArrayList<Bitmap> bottomRightBitmaps = new ArrayList<>();

    protected static PictureSingletonStorageClass singleton = null;

    private PictureSingletonStorageClass() { }

    public static PictureSingletonStorageClass getInstance() {
        if (singleton == null) {
            singleton = new PictureSingletonStorageClass();
        }
        return  singleton;
    }

    protected static void setPictureWorker(PictureWorker wkr) {
        worker = wkr;
    }

    protected static PictureWorker getPictureWorker() { return worker; }

    protected static void AddBitmap(int position,Bitmap bitmap) {
        if (position == 1) {
            topLeftBitmaps.add(bitmap);
        } else if (position == 2) {
            topRightBitmaps.add(bitmap);
        } else if (position == 3) {
            bottomLeftBitmaps.add(bitmap);
        } else {
            bottomRightBitmaps.add(bitmap);
        }

    }

    protected static Bitmap getBitmap(int position, int index) {
        if (position == 1) {
            return topLeftBitmaps.get(index);
        } else if (position == 2) {
            return topRightBitmaps.get(index);
        } else if (position == 3) {
            return bottomLeftBitmaps.get(index);
        } else {
            return bottomRightBitmaps.get(index);
        }
        //return null;

    }

    protected static void clearBitmaps() {
        topLeftBitmaps = new ArrayList<>();
        topRightBitmaps = new ArrayList<>();
        bottomLeftBitmaps = new ArrayList<>();
        bottomRightBitmaps = new ArrayList<>();
        topLeft.setImageResource(0);
        topRight.setImageResource(0);
        bottomLeft.setImageResource(0);
        bottomRight.setImageResource(0);
    }

    protected static void setInitialBitmaps() {
        try {
            topLeft.setImageBitmap(topLeftBitmaps.get(0));
            topRight.setImageBitmap(topRightBitmaps.get(0));
            bottomLeft.setImageBitmap(bottomLeftBitmaps.get(0));
            bottomRight.setImageBitmap(bottomRightBitmaps.get(0));
        } catch (Exception e) {
            System.out.print("one or more initial images haven't loaded yet");
        }
    }

    protected static void setImageViews(int position, ImageView imgv) {
        if (position == 1) {
            topLeft = imgv;
        } else if (position == 2) {
            topRight = imgv;
        } else if (position == 3) {
            bottomLeft = imgv;
        } else {
            bottomRight = imgv;
        }
    }

    protected void next() {
        try {
            topLeft.setImageBitmap(topLeftBitmaps.get(1));
            topRight.setImageBitmap(topRightBitmaps.get(1));
            bottomLeft.setImageBitmap(bottomLeftBitmaps.get(1));
            bottomRight.setImageBitmap(bottomRightBitmaps.get(1));
        } catch (Exception e) {
            System.out.print("one or more initial images haven't loaded yet");
        }

    }
}
