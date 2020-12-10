package com.example.meckshchsws;

public class User {
    private String Login;
    private String Password;

    public User(String login, String password) {
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
}
