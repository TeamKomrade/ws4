package com.example.meckshchsws;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Random;

public class BankListMenu extends AppCompatActivity implements OnMapReadyCallback {

    private static ArrayList<Bank> banks;
    LayoutInflater layoutInflater;
    ListView listView;
    BankListAdapter bankListAdapter;
    private GoogleMap mMap;
    LatLng oren = new LatLng(51.766225, 55.123008);
    Random rng = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank_list);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync((OnMapReadyCallback) this);
        Init();
    }

    private void Init() {
        banks = new ArrayList<Bank>();
        banks.add(new Bank("ул шушкина", BankStatus.OPEN, TypeOfBank.ATM, newRandomLocation(), new Time(10000000), new Time(20000000)));
        banks.add(new Bank("ул шушкина", BankStatus.CLOSED, TypeOfBank.ATM, newRandomLocation(), new Time(40000000), new Time(80000000)));

        listView = findViewById(R.id.BanksListView);
        layoutInflater = LayoutInflater.from(this);
        bankListAdapter = new BankListAdapter();
        listView.setAdapter(bankListAdapter);
    }

    protected class BankListAdapter extends BaseAdapter
    {

        @Override
        public int getCount() {
            return banks.size();
        }

        @Override
        public Bank getItem(int position) {
            return banks.get(position);
        }

        @Override
        public long getItemId(int position) {
            return banks.indexOf(position);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            final Bank bank = getItem(position);
            convertView = layoutInflater.inflate(R.layout.item_bank, parent,false);
            TextView addressView = convertView.findViewById(R.id.AddressTextView);
            TextView typeView = convertView.findViewById(R.id.TypeTextView);
            TextView statusView = convertView.findViewById(R.id.StatusTextView);
            TextView hoursView = convertView.findViewById(R.id.HoursTextView);
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
            int color;
            switch (bank.getStatus()) {
                case OPEN: color = getResources().getColor(R.color.colorAccent); break;
                case CLOSED: color = getResources().getColor(R.color.colorPrimaryDark); break;
                default: color = getResources().getColor(R.color.colorGray);
            }

            addressView.setText(bank.getAddress());
            typeView.setText(bank.getTypeAsString());
            statusView.setText(bank.getStatusAsString());
            statusView.setTextColor(color);
            hoursView.setText(sdf.format(bank.getOpenFrom()) + "-" + sdf.format(bank.getClosedAfter()));
            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(bank.getLocation()));
                }
            });
            mMap.addMarker(new MarkerOptions()
                    .position(bank.getLocation())
            .title(bank.getAddress()))
            .setSnippet(bank.getStatusAsString() + " [" + bank.getTimeAsString() + "] ");
            return convertView;
        }
    }

    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.moveCamera(CameraUpdateFactory.newLatLng(oren));
    }

    private LatLng newRandomLocation()
    {
        return new LatLng(oren.latitude+rng.nextDouble()*0.01-rng.nextDouble()*0.01,
                oren.longitude+rng.nextDouble()*0.01-rng.nextDouble()*0.01);
    }
}