package com.railApplication.Entity;

public class User {
    private String userName;

    public User(String username, String encode) {
        this.userName = username;
        this.password = encode;
    }
    public User(){
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String password;

}
