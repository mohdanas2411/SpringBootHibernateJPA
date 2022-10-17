package com.example.SpringBootFirst.HQLpractical;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

@Entity
public class User{
    @Id
    @GeneratedValue
    private int userId;

    private String userName;

    private int userBal;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserBal() {
        return userBal;
    }

    public void setUserBal(int userBal) {
        this.userBal = userBal;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userBal='" + userBal + '\'' +
                '}';
    }
}
