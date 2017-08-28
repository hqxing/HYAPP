package com.example.lenovo.hyapp.model;

public class User {
    String userNmae;
    int userId;
    String userPassword;
    String userRePw;

    public String getUserNmae() {
        return userNmae;
    }

    public void setUserNmae(String userNmae) {
        this.userNmae = userNmae;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {this.userPassword = userPassword;}

    public int getUserId() {return userId;}

    public void setUserId(int userId) {this.userId = userId;}

    public String getUserRePw() {return userRePw;}

    public void setUserRePw(String userRePw) {this.userRePw = userRePw;}
}
