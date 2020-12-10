package com.example.meckshchsws;

import java.io.StringReader;

public class ExchangeRate {
    private String ImageName;

    public String getImageName() {
        return ImageName;
    }

    public void setImageName(String imageName) {
        ImageName = imageName;
    }

    private String CurrencyName;
    private String CurrencyShortName;
    private double ExchangeRate;

    public ExchangeRate(String imageName, String currencyName, String currencyShortName, double exchangeRate) {
        ImageName = imageName;
        CurrencyName = currencyName;
        CurrencyShortName = currencyShortName;
        ExchangeRate = exchangeRate;
    }

    public String getCurrencyName() {
        return CurrencyName;
    }

    public void setCurrencyName(String currencyName) {
        CurrencyName = currencyName;
    }

    public String getCurrencyShortName() {
        return CurrencyShortName;
    }

    public void setCurrencyShortName(String currencyShortName) {
        CurrencyShortName = currencyShortName;
    }

    public double getExchangeRate() {
        return ExchangeRate;
    }

    public void setExchangeRate(double exchangeRate) {
        ExchangeRate = exchangeRate;
    }
}
