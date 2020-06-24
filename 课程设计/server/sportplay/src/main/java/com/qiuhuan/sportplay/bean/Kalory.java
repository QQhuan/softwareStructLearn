package com.qiuhuan.sportplay.bean;

public class Kalory {
    private int id;
    private int userId;
    private int days;
    private int kalories; //运动卡路里
    private String username;

    public Kalory() {
    }

    public Kalory(int userId, int days, int kalories, String username) {
        this.userId = userId;
        this.days = days;
        this.kalories = kalories;
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public int getKalories() {
        return kalories;
    }

    public void setKalories(int kalories) {
        this.kalories = kalories;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "Kalory{" +
                "id=" + id +
                ", userId=" + userId +
                ", days=" + days +
                ", kalories=" + kalories +
                ", username='" + username + '\'' +
                '}';
    }
}
