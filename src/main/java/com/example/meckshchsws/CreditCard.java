package com.example.meckshchsws;

public class CreditCard {
    private CredicCardType Type;
    private String Number;
    private double Balance;

    public CredicCardType getType() {
        return Type;
    }

    public void setType(CredicCardType type) {
        Type = type;
    }

    public String getNumber() {
        return Number;
    }

    public void setNumber(String number) {
        Number = number;
    }


    public CreditCard(CredicCardType type, String number, double balance) {
        Type = type;
        Number = number;
        Balance = balance;
    }

    public String getNumberObscured() {
        String num = getNumber();
        return num.substring(0, 4) + " **** " + num.substring(num.length()-5);
    }


    public String getTypeAsString() {
        String type;

        switch (getType()) {
            case DEBIT: type = "Дебетовая"; break;
            case CREDIT: type = "Кредитная"; break;
            default: type = "UNDEFINED"; break;
        }
        return type;
    }

    public double getBalance() {
        return Balance;
    }

    public void setBalance(double balance) {
        Balance = balance;
    }

    public String getBalanceAsString() {
        return String.format("%.2f",getBalance());
    }
}

