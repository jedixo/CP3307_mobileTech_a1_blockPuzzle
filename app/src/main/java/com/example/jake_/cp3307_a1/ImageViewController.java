package com.example.jake_.cp3307_a1;

import android.graphics.Bitmap;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Random;

/**
 * Controls the operation of the ImageViews and main logic behind the puzzle
 */
public class ImageViewController {

    //the imageViews
    private static ImageView preview, topLeft, topRight, bottomLeft, bottomRight;

    // the parts of all the images for the puzzle
    private static ArrayList<Bitmap> topLeftBitmaps = new ArrayList<>();
    private static ArrayList<Bitmap> topRightBitmaps = new ArrayList<>();
    private static ArrayList<Bitmap> bottomLeftBitmaps = new ArrayList<>();
    private static ArrayList<Bitmap> bottomRightBitmaps = new ArrayList<>();
    private static ArrayList<Bitmap> previewBitmaps = new ArrayList<>();

    //other variables to keep track of things
    private static boolean loadInitalDone = false;
    private static int[] currentLoadedImage = new int[4];
    private static int targetImageIndex = 0;

    //this singleton's instance so can be accessed from any class
    protected static ImageViewController singleton = null;

    //self instanciator
    private ImageViewController() {
    }

    //returns the instance of this singleton
    public static ImageViewController getInstance() {
        if (singleton == null) {
            singleton = new ImageViewController();
        }
        return singleton;
    }

    //adds bitmaps to their repsective arrays
    protected void AddBitmap(int position, Bitmap bitmap) {
        switch (position) {
            case 0:
                previewBitmaps.add(bitmap);
                break;
            case 1:
                topLeftBitmaps.add(bitmap);
                break;
            case 2:
                topRightBitmaps.add(bitmap);
                break;
            case 3:
                bottomLeftBitmaps.add(bitmap);
                break;
            default:
                bottomRightBitmaps.add(bitmap);
                break;
        }

    }

    //clears the pictures from memory and clears the imageViews
    protected static void clearBitmaps() {
        previewBitmaps = new ArrayList<>();
        topLeftBitmaps = new ArrayList<>();
        topRightBitmaps = new ArrayList<>();
        bottomLeftBitmaps = new ArrayList<>();
        bottomRightBitmaps = new ArrayList<>();
        try {
            preview.setImageResource(0);
            topLeft.setImageResource(0);
            topRight.setImageResource(0);
            bottomLeft.setImageResource(0);
            bottomRight.setImageResource(0);
        } catch (Exception e) {
            //not loaded yet
        }
        loadInitalDone = false;
    }

    //sets the inital image (change this)
    protected static void setInitialBitmaps() {
        try {
            if (!loadInitalDone) {
                preview.setImageBitmap(previewBitmaps.get(0));
                topLeft.setImageBitmap(topLeftBitmaps.get(0));
                topRight.setImageBitmap(topRightBitmaps.get(0));
                bottomLeft.setImageBitmap(bottomLeftBitmaps.get(0));
                bottomRight.setImageBitmap(bottomRightBitmaps.get(0));
                loadInitalDone = true;
            }
        } catch (Exception e) {
            System.out.println("one or more initial images haven't loaded yet");
        }
    }

    //randomises the imagees on the imageviews
    protected static void randomiseImages() {
        Random random = new Random();

        int[] positions = {random.nextInt(topLeftBitmaps.size()), random.nextInt(topLeftBitmaps.size()),
                random.nextInt(topLeftBitmaps.size()), random.nextInt(topLeftBitmaps.size())};
        targetImageIndex = random.nextInt(topLeftBitmaps.size());
        currentLoadedImage = positions;

        topLeft.setImageBitmap(topLeftBitmaps.get(positions[0]));
        topRight.setImageBitmap(topRightBitmaps.get(positions[1]));
        bottomLeft.setImageBitmap(bottomLeftBitmaps.get(positions[2]));
        bottomRight.setImageBitmap(bottomRightBitmaps.get(positions[3]));
    }

    //gets the next image for a particular view
    protected static void nextImage(int id) {
        switch (id) {
            case 1:
                if (currentLoadedImage[0] + 1 < topLeftBitmaps.size()) {
                    currentLoadedImage[0]++;
                } else {
                    currentLoadedImage[0] = 0;
                }
                topLeft.setImageBitmap(topLeftBitmaps.get(currentLoadedImage[0]));
                break;
            case 2:
                if (currentLoadedImage[1] + 1 < topLeftBitmaps.size()) {
                    currentLoadedImage[1]++;
                } else {
                    currentLoadedImage[1] = 0;
                }
                topRight.setImageBitmap(topRightBitmaps.get(currentLoadedImage[1]));
                break;
            case 3:
                if (currentLoadedImage[2] + 1 < topLeftBitmaps.size()) {
                    currentLoadedImage[2]++;
                } else {
                    currentLoadedImage[2] = 0;
                }
                bottomLeft.setImageBitmap(bottomLeftBitmaps.get(currentLoadedImage[2]));
                break;
            default:
                if (currentLoadedImage[3] + 1 < topLeftBitmaps.size()) {
                    currentLoadedImage[3]++;
                } else {
                    currentLoadedImage[3] = 0;
                }
                bottomRight.setImageBitmap(bottomRightBitmaps.get(currentLoadedImage[3]));
                break;
        }
    }

    // makes the imageViews known to the class
    protected static void setImageViews(int position, ImageView imgv) {
        switch (position) {
            case 0:
                preview = imgv;
                break;
            case 1:
                topLeft = imgv;
                break;
            case 2:
                topRight = imgv;
                break;
            case 3:
                bottomLeft = imgv;
                break;
            default:
                bottomRight = imgv;
                break;
        }
    }

    //checks if every tile belongs to the same image and that the image is the target image
    protected static boolean isComplete() {
        return currentLoadedImage[0] == currentLoadedImage[1] && currentLoadedImage[0] == currentLoadedImage[2]
                && currentLoadedImage[0] == currentLoadedImage[3] && currentLoadedImage[0] == targetImageIndex;
    }
}
