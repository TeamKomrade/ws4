package com.example.meckshchsws;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

public class MainMenuActivity extends AppCompatActivity {
    private static final String APP_PREFERENCES = "MaksWS";
    private static final String USER_LOGIN = "login";
    private static final String USER_PASSOWRD = "password";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
    }

    public void exitToMain(View view) {
        SharedPreferences prefs = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor e = prefs.edit();
        e.putString(USER_LOGIN, "");
        e.putString(USER_PASSOWRD, "");
        e.apply();

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}