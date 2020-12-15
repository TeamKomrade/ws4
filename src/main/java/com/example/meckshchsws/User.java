package com.example.meckshchsws;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String FirstName;
    private String LastName;
    private String MiddleName;

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public User(String firstName, String lastName, String middleName, String login, String password) {
        Cards = new ArrayList<CreditCard>();
        FirstName = firstName;
        LastName = lastName;
        MiddleName = middleName;
        Login = login;
        Password = password;
    }

    public String getMiddleName() {
        return MiddleName;
    }

    public void setMiddleName(String middleName) {
        MiddleName = middleName;
    }

    private String Login;
    private String Password;

    public User(String login, String password) {
        Cards = new ArrayList<CreditCard>();
        Login = login;
        Password = password;
    }

    public String getLogin() {
        return Login;
    }

    public void setLogin(String login) {
        Login = login;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    private ArrayList<CreditCard> Cards;

    public ArrayList<CreditCard> getCards() {
        return Cards;
    }

    public void setCards(ArrayList<CreditCard> cards) {
        Cards = cards;
    }

    public void addCard(CreditCard cc) {
        Cards.add(cc);
    }

    public String getFirstAndMiddleName () {
        return FirstName + " " + MiddleName;
    }
}
