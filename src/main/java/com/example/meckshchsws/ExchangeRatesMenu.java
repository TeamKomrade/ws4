package com.example.meckshchsws;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ExchangeRatesMenu extends AppCompatActivity {

    LayoutInflater layoutInflater;
    ListView listView;
    RatesListAdapter ratesListAdapter;
    private static ArrayList<ExchangeRate> exrates;
    private static double bankSellToCoeff = 0.95;
    private static double bankBuyFromCoeff = 1.10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exrates);
        Init();
    }

    private void Init() {
        exrates = new ArrayList<ExchangeRate>();
        exrates.add(new ExchangeRate("🇺🇸","грязная бумажка", "ДОЛ", 69.69));
        exrates.add(new ExchangeRate("🇪🇺","волюта немцов", "ЕВРО", 108));
        exrates.add(new ExchangeRate("🇺🇬","+реп", "РЕП", 1));
        exrates.add(new ExchangeRate("🇿🇼","тото -- африка", "ЗМД", 97617870));



        TextView dateTextView = findViewById(R.id.ExRatesDateTextView);
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.YYYY");
        dateTextView.setText(sdf.format(date));

        listView = findViewById(R.id.ExRatesListView);
        layoutInflater = LayoutInflater.from(this);
        ratesListAdapter = new RatesListAdapter();
        listView.setAdapter(ratesListAdapter);
    }

    protected class RatesListAdapter extends BaseAdapter
    {

        @Override
        public int getCount() {
            return exrates.size();
        }

        @Override
        public ExchangeRate getItem(int position) {
            return exrates.get(position);
        }

        @Override
        public long getItemId(int position) {
            return exrates.indexOf(position);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ExchangeRate rate = getItem(position);
            convertView = layoutInflater.inflate(R.layout.item_exrate, parent,false);
            TextView currencyImageView = convertView.findViewById(R.id.CurrencyIconImageView);
            TextView currencyNameView = convertView.findViewById(R.id.CurrencyNameTextView);
            TextView currencyShortNameView = convertView.findViewById(R.id.CurrencyShortNameTextView);
            TextView buyPriceView = convertView.findViewById(R.id.BuyPriceTextView);
            TextView sellPriceView = convertView.findViewById(R.id.SellPriceTextView);

            currencyImageView.setText(rate.getImageName());
            currencyNameView.setText(rate.getCurrencyName());
            currencyShortNameView.setText(rate.getCurrencyShortName());
            buyPriceView.setText(String.format("%.2f",rate.getExchangeRate()*bankBuyFromCoeff));
            sellPriceView.setText(String.format("%.2f",rate.getExchangeRate()*bankSellToCoeff));

            return convertView;
        }
    }
}