package com.example.meckshchsws;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private static final String APP_PREFERENCES = "MaksWS";
    private static final String USER_LOGIN = "login";
    private static final String USER_PASSOWRD = "password";

    private ArrayList<User> users = new ArrayList<User>();
    private SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView dateTextView = findViewById(R.id.DateTextView);
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.YYYY");
        dateTextView.setText(sdf.format(date));

        users.add(new User("user", "password"));

        prefs = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
        String login = prefs.getString(USER_LOGIN, "");
        String password = prefs.getString(USER_PASSOWRD, "");
        if (!login.isEmpty() && !password.isEmpty()) tryLogin(login, password);
    }

    public void ShowBanks(View view) {
        Intent mainMenu = new Intent(MainActivity.this, BankListMenu.class);
        startActivity(mainMenu);
    }

    public void ShowRates(View view) {
        Intent ratesMenu = new Intent(MainActivity.this, ExchangeRatesMenu.class);
        startActivity(ratesMenu);
    }

    public void ToastText(String text)
    {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
    }

    public void openLogin(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        final View login_view = getLayoutInflater().inflate(R.layout.login_alert, null);
        builder.setTitle("voidi");
        builder.setMessage("Введите лологен и паролк");
        builder.setView(login_view);
        builder.setPositiveButton("vhodi", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                EditText login = login_view.findViewById(R.id.editTextTextPersonName);
                EditText password = login_view.findViewById(R.id.editTextTextPassword);
                tryLogin(login.getEditableText().toString(), password.getEditableText().toString());
            }
        });
        builder.show();
    }

    private void tryLogin(String login, String password) {
        boolean userExists = false;
        for (User user: users) {
            boolean loginExists = user.getLogin().equals(login);
            boolean passwordExists = user.getPassword().equals(password);
            if (loginExists && passwordExists) {
                userExists = true;
                break;
            }
        }
        if (userExists)
        {
            SharedPreferences.Editor e = prefs.edit();
            e.putString(USER_LOGIN, login);
            e.putString(USER_PASSOWRD, password);
            e.apply();

            Intent logIntent = new Intent(MainActivity.this, MainMenuActivity.class);
            startActivity(logIntent);
            finish();
        }
        else ToastText("net");
    }
}