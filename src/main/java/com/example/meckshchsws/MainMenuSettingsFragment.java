package com.example.meckshchsws;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Toast;

public class MainMenuSettingsFragment extends Fragment {

    MainMenuActivity Main;

    public MainMenuSettingsFragment() {
    }

    public MainMenuSettingsFragment(MainMenuActivity main) {
        Main = main;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    private void Init(View v) {
        FrameLayout changePassView = v.findViewById(R.id.changePassView);
        FrameLayout exitToMainView = v.findViewById(R.id.exitToMainView);


        exitToMainView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Main.exitToMain();
            }
        });

        changePassView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_main_menu_settings, container, false);
        Init(v);
        return v;

    }
}