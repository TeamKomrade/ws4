package com.example.meckshchsws;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainMenuActivity extends AppCompatActivity {
    private static final String APP_PREFERENCES = "MaksWS";
    private static final String USER_LOGIN = "login";
    private static final String USER_PASSWORD = "password";
    private final FragmentManager fm = getSupportFragmentManager();

    private User user;
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        SharedPreferences prefs = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);

        String login = prefs.getString(USER_LOGIN, "");
        String password = prefs.getString(USER_PASSWORD, "");
        user = Util.getUser(login, password);

        TextView name = findViewById(R.id.fullNameTextView);
        name.setText(user.getFirstAndMiddleName());

        MainMenuCardsFragment fragment = new MainMenuCardsFragment(user);
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fragmentFrameLayout, fragment);
        ft.commit();
        //
    }

    public void exitToMain(View view) {
        SharedPreferences prefs = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor e = prefs.edit();
        e.putString(USER_LOGIN, "");
        e.putString(USER_PASSWORD, "");
        e.apply();

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void openHistoryPage(View view) {
        MainMenuHistoryFragment fragment = new MainMenuHistoryFragment();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fragmentFrameLayout, fragment);
        ft.commit();
    }

    public void openMainPage(View view) {
        MainMenuCardsFragment fragment = new MainMenuCardsFragment(user);
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fragmentFrameLayout, fragment);
        ft.commit();
    }
}