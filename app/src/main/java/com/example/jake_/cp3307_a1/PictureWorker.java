package com.example.jake_.cp3307_a1;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Looper;

/**
 * Picture worker class - 75% of the code is from the example poster to LJCU
 */
public class PictureWorker extends Thread {

    private ImageViewController imageViewController = ImageViewController.getInstance();

    private Handler handler;
    private Context context;
    private Looper looper;
    public int totalImages = 0;
    private int loaded = 0;

    public PictureWorker(Context context) {
        this.context = context;
    }

    /**
     * calculates the resample size
     *
     * @param options   - options for bitmap
     * @param reqWidth  - set width
     * @param reqHeight - set height
     * @return - returns sample size
     */
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

    /**
     * decodes the bitmap and resamples it
     *
     * @param res       - resources
     * @param resId     - resource id for a particular bitmap
     * @param reqWidth  - set width
     * @param reqHeight - set height
     * @return returns the bitmap
     */
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
        looper = Looper.myLooper();
        handler = new Handler(looper);
        Looper.loop();
    }

    /**
     * stops the worker
     */
    public void quit() {
        looper.quit();
    }

    /**
     * loads each quarter of the original bitmap and the sample
     *
     * @param id     - id of the bitmap to load
     * @param runner - the thread to run on
     */
    public void loadResource(final int id, final Handler runner) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                final Bitmap original = decodeSampledBitmapFromResource(context.getResources(), id, 300, 300);
                imageViewController.AddBitmap(0, decodeSampledBitmapFromResource(context.getResources(), id, 50, 60));
                imageViewController.AddBitmap(1, Bitmap.createBitmap(original, 0, 0, original.getWidth() / 2, original.getHeight() / 2));
                imageViewController.AddBitmap(2, Bitmap.createBitmap(original, original.getWidth() / 2, 0, original.getWidth() / 2, original.getHeight() / 2));
                imageViewController.AddBitmap(3, Bitmap.createBitmap(original, 0, original.getHeight() / 2, original.getWidth() / 2, original.getHeight() / 2));
                imageViewController.AddBitmap(4, Bitmap.createBitmap(original, original.getWidth() / 2, original.getHeight() / 2, original.getWidth() / 2, original.getHeight() / 2));
                loaded++;

                runner.post(new Runnable() {
                    @Override
                    public void run() {
                        if (loaded == totalImages) {
                            //imageViewController.setInitialBitmaps();
                            ImageViewController.randomiseImages();
                        }
                    }
                });
            }
        });
    }
}
