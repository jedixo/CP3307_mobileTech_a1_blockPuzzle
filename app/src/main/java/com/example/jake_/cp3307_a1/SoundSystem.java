package com.example.jake_.cp3307_a1;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Handler;
import android.os.Looper;


public class SoundSystem {

    public int id;
    public int count;
    public int MAX_COUNT = 1;
    public boolean ready = false;

    private SoundPool pool;
    private Looper looper;
    private Handler handler;

    public SoundSystem(Context context) {
        pool = new SoundPool(12, AudioManager.STREAM_MUSIC, 0);

        pool.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() {
            @Override
            public void onLoadComplete(SoundPool soundPool, int sampleId, int status) {

                if (status != 0) return;

                count++;
                if (count == MAX_COUNT) {
                    ready = true;
                }
            }
        });

        id = pool.load(context, R.raw.tada, 1);
    }

    public void start() {
        LooperThread thread = new LooperThread();
        thread.start();
    }

    public void stop() {
        looper.quit();
    }

    public void play() {
        if (!ready) return;

        handler.post(new Runnable() {
            @Override
            public void run() {
                pool.play(id, 1, 1, 1, 0, 1);
            }
        });
    }


    private class LooperThread extends Thread {
        @Override
        public void run() {
            try {
                Looper.prepare();
                looper = Looper.myLooper();
                handler = new Handler(looper);
                Looper.loop();
            } catch (Exception e) {
                //looper terminated
            }
        }
    }
}