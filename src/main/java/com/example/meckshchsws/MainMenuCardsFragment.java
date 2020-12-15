package com.example.meckshchsws;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MainMenuCardsFragment extends Fragment {
    private User _user;
    public MainMenuCardsFragment() {
        // Required empty public constructor
    }

    public MainMenuCardsFragment(User user) {
        _user = user;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main_menu_cards, container, false);
    }
}