package com.example.meckshchsws;

public class BankAccount {
    private double Balance;
    private String Number;

    public String getNumber() {
        return Number;
    }

    public void setNumber(String number) {
        Number = number;
    }

    public String getNumberObscured() {
        String num = getNumber();
        return " **** " + num.substring(num.length()-6); }

    public double getBalance() {
        return Balance;
    }

    public BankAccount(double balance, String number) {
        Balance = balance;
        Number = number;
    }

    public void setBalance(double balance) {
        Balance = balance;
    }

    public String getBalanceAsString() {
        return String.format("%.2f",getBalance());
    }
}
