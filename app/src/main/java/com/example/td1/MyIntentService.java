package com.example.td1;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * TODO: Customize class - update intent actions and extra parameters.
 */
public class MyIntentService extends IntentService {
    private int tempsRestant;

    public MyIntentService() {
        super("MyIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.i("Chrono", "Debut !");
        tempsRestant = 10;
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                while(tempsRestant !=0){
                    try {
                        tempsRestant--;
                        Thread.sleep(1000);
                        Log.i("Chrono", tempsRestant+ "");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                Log.i("Chrono", "Zéro !");
            }
        });
       t.run();

    }

}