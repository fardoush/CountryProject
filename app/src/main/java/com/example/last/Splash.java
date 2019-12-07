package com.example.last;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;

public class Splash extends AppCompatActivity {
    ProgressBar progressBar;
    int progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);

        progressBar= findViewById(R.id.pBar);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                splash();
                StartApp();
            }
        });
        thread.start();

    }

    public  void splash(){
        for (progress =40;progress<=100;progress=progress+40){
            try {
                Thread.sleep(1000);
                progressBar.setProgress(progress);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }
    public  void  StartApp(){
        Intent i = new Intent(Splash.this,MainActivity.class);
        startActivity(i);
        finish();

    }
}
