package com.example.hill;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class HillSplashScreen extends AppCompatActivity {
    //variable for splash screen time out in milliseconds
    private static final int SPLASH_TIME_OUT = 2000;
    //Class Handler that handles splash screen activity
    Handler sScreenHandler;
    //Class Intent handles activity transfer from splash to main
    Intent loadMainIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hill_splash_screen);
        //New object of Handler class
        sScreenHandler = new Handler();
        sScreenHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                loadMainIntent = new Intent(HillSplashScreen.this,
                                                           MainActivity.class);
                startActivity(loadMainIntent);
                finish();
            }
        },SPLASH_TIME_OUT);
    }
}