package com.example.meckshchsws;

import com.google.android.gms.maps.model.LatLng;

import java.sql.Time;
import java.text.SimpleDateFormat;

public class Bank {
    private String Address;
    private BankStatus Status;
    private TypeOfBank Type;
    private Time OpenFrom;
    private Time ClosedAfter;

    public LatLng getLocation() {
        return Location;
    }

    public void setLocation(LatLng location) {
        Location = location;
    }

    private LatLng Location;
    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public BankStatus getStatus() {
        return Status;
    }

    public void setStatus(BankStatus status) {
        Status = status;
    }

    public TypeOfBank getType() {
        return Type;
    }

    public void setType(TypeOfBank type) {
        Type = type;
    }

    public Time getOpenFrom() {
        return OpenFrom;
    }

    public void setOpenFrom(Time openFrom) {
        OpenFrom = openFrom;
    }

    public Time getClosedAfter() {
        return ClosedAfter;
    }

    public void setClosedAfter(Time closedAfter) {
        ClosedAfter = closedAfter;
    }

    public Bank(String address, BankStatus status, TypeOfBank type, LatLng location, Time openFrom, Time closedAfter) {
        Location = location;
        Address = address;
        Status = status;
        Type = type;
        OpenFrom = openFrom;
        ClosedAfter = closedAfter;
    }

    public String getStatusAsString() {
        switch (Status)
        {
            case OPEN: return "окртытоо";
            case CLOSED: return "закртыо";
            default: return "это как";
        }
    }

    public String getTypeAsString() {
        switch (Type)
        {
            case ATM: return "банкотмат";
            case BRANCH: return "отделелные";
            default: return "кто";
        }
    }

    public String getTimeAsString() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        return sdf.format(getOpenFrom()) + "-" + sdf.format(getClosedAfter());
    }
}

