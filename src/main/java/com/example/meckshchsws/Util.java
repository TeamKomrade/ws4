package com.example.meckshchsws;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.List;

public class Util {
    private static List<User> Users = new ArrayList<User>();
    @RequiresApi(api = Build.VERSION_CODES.N)
    public static User getUser(String login, String password) {
        return Users.stream()
                .filter(u -> u.getLogin().equals(login) && u.getPassword().equals(password))
                .findAny().orElse(null);
    }

    public static void FillUsers() {
        User newUser = new User("Валерий","Жмышенко","Альбертович","user", "password");
        newUser.addCard(new CreditCard(CreditCardType.DEBIT,"880099990088", 1047.09).setProvider(CardProvider.MASTERCARD));
        newUser.addCard(new CreditCard(CreditCardType.CREDIT,"198755198557", -190.99).setProvider(CardProvider.VISA));
        newUser.addCard(new CreditCard(CreditCardType.DEBIT,"16638123671263", 298.11).setProvider(CardProvider.MIR));
        Users.add(newUser);
    }
}
