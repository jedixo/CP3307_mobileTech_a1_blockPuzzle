package com.example.jake_.cp3307_a1;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView;


public class PictureWorker extends Thread {

    private Handler handler;
    private Context context;

    public PictureWorker(Context context) {
        this.context = context;
    }

    public static int calculateInSampleSize(BitmapFactory.Options options, int reqWidth, int reqHeight) {
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {
            final int halfHeight = height / 2;
            final int halfWidth = width / 2;

            while ((halfHeight / inSampleSize) > reqHeight && (halfWidth / inSampleSize) > reqWidth) {
                inSampleSize += 2;
            }
        }
        return inSampleSize;
    }

    public static Bitmap decodeSampledBitmapFromResource(Resources res, int resId, int reqWidth, int reqHeight) {

        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(res, resId, options);

        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);

        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(res, resId, options);
    }

    @Override
    public void run() {
        Looper.prepare();
        Looper looper = Looper.myLooper();
        handler = new Handler(looper);

        Looper.loop();
    }

    public void loadResource(final ImageView imageView, final int position, final int id, final Handler runner) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                final Bitmap original = decodeSampledBitmapFromResource(context.getResources(), id, 300, 300);
                final Bitmap bitmap;
                //old code needs improving
                if (position == 1) {
                    bitmap = Bitmap.createBitmap(original, 0, 0, original.getWidth() / 2, original.getHeight() / 2);
                } else if (position == 2) {
                    bitmap = Bitmap.createBitmap(original, original.getWidth() / 2, 0, original.getWidth() / 2, original.getHeight() / 2);
                } else if (position == 3) {
                    bitmap = Bitmap.createBitmap(original, 0, original.getHeight() / 2, original.getWidth() / 2, original.getHeight() / 2);
                } else if (position == 4) {
                    bitmap = Bitmap.createBitmap(original, original.getWidth() / 2, original.getHeight() / 2, original.getWidth() / 2, original.getHeight() / 2);
                } else {
                    bitmap = original;
                }

                runner.post(new Runnable() {
                    @Override
                    public void run() {
                        imageView.setImageBitmap(bitmap);
                    }
                });
            }
        });
    }
}
