package com.example.meckshchsws;

public class CreditCard {
    private CreditCardType Type;
    private String Number;
    private double Balance;
    private CardProvider CardProviderType;
    public CreditCardType getType() {
        return Type;
    }

    public void setType(CreditCardType type) {
        Type = type;
    }

    public String getNumber() {
        return Number;
    }

    public void setNumber(String number) {
        Number = number;
    }


    public CreditCard(CreditCardType type, String number, double balance) {
        Type = type;
        Number = number;
        Balance = balance;
    }

    public String getNumberObscured() {
        String num = getNumber();
        return num.substring(0, 4) + " **** " + num.substring(num.length()-4);
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

    public CreditCard setProvider(CardProvider provider) { CardProviderType = provider; return this;}
    public CardProvider getCardProvider() {return CardProviderType;}
    public int getIconID() {
        switch (CardProviderType) {
            case MIR: return R.drawable.mir_icon;
            case VISA: return R.drawable.visa_icon;
            case MASTERCARD: return R.drawable.mastercard_icon;
            default: return 0;
        }
    }
}

