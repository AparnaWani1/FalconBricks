package com.example.falconbricks.ui.splash.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import com.example.falconbricks.R;
import com.example.falconbricks.ui.splash.viewmodel.SplashViewModel;

public class SplashActivity extends AppCompatActivity {


    SplashViewModel splashActivityViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        splashActivityViewModel = ViewModelProviders.of(this).get(SplashViewModel.class);
        splashActivityViewModel.movetonext(this);

    }
}
