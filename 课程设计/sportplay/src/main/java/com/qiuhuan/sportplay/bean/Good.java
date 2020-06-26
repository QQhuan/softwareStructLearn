package com.qiuhuan.sportplay.bean;

public class Good {
    private int id;
    private String goodName;
    private int goodType;
    private int fee = 0;
    private String img;

    public Good() {
    }

    public Good(String goodName, int goodType, int fee, String img) {
        this.goodName = goodName;
        this.goodType = goodType;
        this.fee = fee;
        this.img = img;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public int getGoodType() {
        return goodType;
    }

    public void setGoodType(int goodType) {
        this.goodType = goodType;
    }

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "Good{" +
                "id=" + id +
                ", goodName='" + goodName + '\'' +
                ", goodType=" + goodType +
                ", fee=" + fee +
                ", img='" + img + '\'' +
                '}';
    }
}
