package com.example.falconbricks.ui.mainPage.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.os.Handler;
import android.widget.LinearLayout;

import com.example.falconbricks.R;
import com.example.falconbricks.ui.mainPage.model.Block;
import com.example.falconbricks.ui.mainPage.viewModel.MainActivityViewModel;
import com.example.falconbricks.ui.searchPageBonus1.viewModel.SearchViewModel;
import com.google.android.material.snackbar.Snackbar;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    MainActivityViewModel mainActivityViewModel;
    SearchViewModel searchViewModel;
LinearLayout ll_main_activity;
    boolean doubleBackToExitPressedOnce = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mainActivityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);
        searchViewModel = ViewModelProviders.of(this).get(SearchViewModel.class);
        String json = mainActivityViewModel.getJsonData(this);

        Gson gson = new Gson();
        List<Block> towerList = gson.fromJson(json, new TypeToken<ArrayList<Block>>() {
        }.getType());

        int count = searchViewModel.getCount(this);
        if (count == 0) {
            mainActivityViewModel.insertIntoDb(this, towerList);
        }

        ll_main_activity = findViewById(R.id.ll_main_activity);

        FragmentMenu fragmentMenu = FragmentMenu.newInstance();
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_frame, fragmentMenu, "")
                .commit();


    }

    @Override
    public void onBackPressed() {

        int count = getSupportFragmentManager().getBackStackEntryCount();

        if (count == 0) {
            if (doubleBackToExitPressedOnce) {
                ActivityCompat.finishAffinity(MainActivity.this);
                return;
            }
            this.doubleBackToExitPressedOnce = true;
            Snackbar.make(ll_main_activity, "Please click BACK again to exit", Snackbar.LENGTH_SHORT).show();

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    doubleBackToExitPressedOnce = false;
                }
            }, 2000);
        } else {
            getSupportFragmentManager().popBackStack();
        }
    }
}