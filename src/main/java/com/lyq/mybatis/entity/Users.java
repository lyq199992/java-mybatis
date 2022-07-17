package com.lyq.mybatis.entity;

public class Users {
    private String userName;
    private String userPassword;
    private Integer userId;

    public Users() {
    }

    public Users(String userName, String userPassword, Integer userId) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Users{" +
                "userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userId=" + userId +
                '}';
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
