package com.example.jake_.cp3307_a1;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Controls the operation of the ImageViews and main logic behind the puzzle
 */
public class ImageViewController {

    //the imageViews array {preview, topLeft, topRight, bottomLeft, bottomRight}
    private static ImageView[] imageViews = {};

    //the nested bitmaps array in the same order as the ImageViews array
    private static List<List<Bitmap>> bitmaps = new ArrayList<>(5);

    //array the controls which image is currently being displayed
    private static int[] currentLoadedImage = new int[5];

    //this singleton's instance
    private static ImageViewController singleton = null;

    /**
     * Singleton self initializer
     */
    private ImageViewController() {
    }

    /**
     * getInstance - returns the instance of the singleton
     *
     * @return ImageViewController
     */
    public static ImageViewController getInstance() {
        if (singleton == null) {
            singleton = new ImageViewController();
        }
        return singleton;
    }

    /**
     * AddBitmap - adds a bitmap to an array for respective positions
     *
     * @param position - the position that the bitmap belongs to 0 - 4 = {p,tl,tr,bl,br}
     * @param bitmap   - the Bitmap object
     */
    protected void AddBitmap(int position, Bitmap bitmap) {
        bitmaps.add(new ArrayList<Bitmap>());
        bitmaps.get(position).add(bitmap);
    }

    /**
     * clearBitmaps - clears all the bitmaps and set images from memory
     */
    protected static void clearBitmaps() {
        bitmaps = new ArrayList<>(5);
        try {
            for (ImageView imageView : imageViews) {
                imageView.setImageResource(0);
            }
        } catch (Exception e) {
            //ImageViews haven't been loaded yet
        }
    }

    /**
     * randomiseImages - loads images to a view at random so that the puzzle is jumbled up
     * - randomly selects a target image
     */
    protected static void randomiseImages() {
        Random random = new Random();
        int size = bitmaps.get(0).size();
        int[] positions = {random.nextInt(size), random.nextInt(size), random.nextInt(size), random.nextInt(size), random.nextInt(size)};
        currentLoadedImage = positions;

        for (int i = 0; i < imageViews.length; i++) {
            imageViews[i].setImageBitmap(bitmaps.get(i).get(positions[i]));
        }
    }

    /**
     * nextImage - gets the next sequential image for a particular ImageView
     *
     * @param id - the identification of an ImageView 1 - 4 {tl, tr, bl, br}
     */
    protected static void nextImage(int id) {
        if (currentLoadedImage[id] + 1 < bitmaps.get(id).size()) {
            currentLoadedImage[id]++;
        } else {
            currentLoadedImage[id] = 0;
        }

        imageViews[id].setImageBitmap(bitmaps.get(id).get(currentLoadedImage[id]));
    }

    /**
     * isComplete - checks if the puzzle has been matched to the target image
     *
     * @return boolean - false if the puzzle is not complete, true if it is complete
     */
    protected static boolean isComplete() {
        if (currentLoadedImage[1] == currentLoadedImage[2] && currentLoadedImage[1] == currentLoadedImage[3]
                && currentLoadedImage[1] == currentLoadedImage[4] && currentLoadedImage[1] == currentLoadedImage[0]) {

            for (ImageView imageView : imageViews) {
                imageView.setColorFilter(Color.argb(100, 0, 255, 0));
                imageView.setEnabled(false);
            }
            return true;
        }
        return false;
    }

    /**
     * reset - Resets the game
     */
    protected static void reset() {
        for (ImageView imageView : imageViews) {
            imageView.setColorFilter(Color.argb(0, 0, 0, 0));
            imageView.setEnabled(true);
        }
        randomiseImages();
    }

    /**
     * setViews - sets the ImageView array
     *
     * @param imgViews - an array containing all 5 imageViews
     */
    protected static void setViews(ImageView[] imgViews) {
        imageViews = imgViews;
    }
}
