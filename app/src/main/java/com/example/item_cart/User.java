package com.example.item_cart;

public class User {
    private String userName;
    private String userAddress;
    private int userAge;
    private String userEmail;
    private String userPhone;
    private String userPassword;

    public User(String userName, String userAddress, int userAge, String userEmail, String userPhone, String userPassword) {
        this.userName = userName;
        this.userAddress = userAddress;
        this.userAge = userAge;
        this.userEmail = userEmail;
        this.userPhone = userPhone;
        this.userPassword = userPassword;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public int getUserAge() {
        return userAge;
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
