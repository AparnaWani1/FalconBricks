package com.example.falconbricks.ui.splash.viewmodel;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;

import androidx.lifecycle.ViewModel;

import com.example.falconbricks.ui.mainPage.view.MainActivity;


public class SplashViewModel extends ViewModel {

    private static int SPLASH_TIME_OUT = 2000;

    public void movetonext(final Context context) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                context.startActivity(new Intent(context, MainActivity.class));
                ((Activity) context).finish();
            }
        }, SPLASH_TIME_OUT);
    }
}
