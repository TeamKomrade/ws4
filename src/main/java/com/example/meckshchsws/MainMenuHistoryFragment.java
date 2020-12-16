package com.example.meckshchsws;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MainMenuHistoryFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainMenuHistoryFragment extends Fragment {

    public MainMenuHistoryFragment() {
        // Required empty public constructor
    }

    public static MainMenuHistoryFragment newInstance(String param1, String param2) {
        MainMenuHistoryFragment fragment = new MainMenuHistoryFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_main_menu_history, container, false);
    }
}