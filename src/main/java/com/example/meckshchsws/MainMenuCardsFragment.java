package com.example.meckshchsws;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.model.MarkerOptions;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class MainMenuCardsFragment extends Fragment {
    private User _user;

    private ListView cardsListView;
    private ListView accountsListView;
    private ListView creditsListView;

    private CardListAdapter cardListAdapter;
    private AccountListAdapter accountListAdapter;
    private CardListAdapter creditListAdapter;

    private LayoutInflater layoutInflater;
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

    private void Init(View view) {
        cardsListView = view.findViewById(R.id.cardsListView);
        cardListAdapter = new CardListAdapter();
        cardsListView.setAdapter(cardListAdapter);

        accountsListView = view.findViewById(R.id.accountsListView);
        accountListAdapter = new AccountListAdapter();
        accountsListView.setAdapter(accountListAdapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        layoutInflater = inflater;
        View view = layoutInflater.inflate(R.layout.fragment_main_menu_cards, container, false);
        Init(view);
        return view;
    }

    protected class CardListAdapter extends BaseAdapter
    {
        @Override
        public int getCount() {
            return _user.getCards().size();
        }

        @Override
        public CreditCard getItem(int position) {
            return _user.getCards().get(position);
        }

        @Override
        public long getItemId(int position) {
            return  _user.getCards().indexOf(position);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            final CreditCard card = getItem(position);
            convertView = layoutInflater.inflate(R.layout.item_card, parent,false);

            TextView cardTypeTextView = convertView.findViewById(R.id.cardTypeTextView);
            TextView cardBalanceTextView = convertView.findViewById(R.id.cardBalanceTextView);
            TextView cardNumberTextView = convertView.findViewById(R.id.cardNumberTextView);
            ImageView cardIconView = convertView.findViewById(R.id.cardIconView);

            cardTypeTextView.setText(card.getTypeAsString());
            cardBalanceTextView.setText(card.getBalanceAsString());
            cardNumberTextView.setText(card.getNumberObscured());
            cardIconView.setImageResource(card.getIconID());
            return convertView;
        }
    }

    protected class AccountListAdapter extends BaseAdapter
    {
        @Override
        public int getCount() {
            return _user.getAccounts().size();
        }

        @Override
        public BankAccount getItem(int position) {
            return _user.getAccounts().get(position);
        }

        @Override
        public long getItemId(int position) {
            return  _user.getCards().indexOf(position);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            final BankAccount account = getItem(position);
            convertView = layoutInflater.inflate(R.layout.item_account, parent,false);

            TextView accountBalanceTextView = convertView.findViewById(R.id.accountBalanceTextView);
            TextView accountNumberTextView = convertView.findViewById(R.id.accountNumberTextView);

            accountBalanceTextView.setText(account.getBalanceAsString());
            accountNumberTextView.setText(account.getNumberObscured());
            return convertView;
        }
    }
}