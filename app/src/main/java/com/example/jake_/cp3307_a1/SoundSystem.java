package com.example.jake_.cp3307_a1;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Handler;
import android.os.Looper;

/**
 * Created by jakedixon on 22/05/2016.
 */
public class SoundSystem {

    public int id;
    public int count;
    public int MAX_COUNT = 1;
    public boolean ready = false;
    private SoundPool pool;

    public SoundSystem(Context context) {
        pool = new SoundPool(12, AudioManager.STREAM_MUSIC, 0);

        pool.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() {
            @Override
            public void onLoadComplete(SoundPool soundPool, int sampleId, int status) {

                if (status != 0) {
                    //error
                    return;
                }

                count++;
                if (count == MAX_COUNT) {
                    ready = true;
                }
            }
        });

        id = pool.load(context, R.raw.tada, 1);
    }

    public void start() {

    }

    public void stop() {

    }

    public void play(int sampleID) {

    }


    private Looper looper;
    private Handler handler;

    private class LooperThread extends Thread {
        @Override
        public void run() {
            
        }



    }
}