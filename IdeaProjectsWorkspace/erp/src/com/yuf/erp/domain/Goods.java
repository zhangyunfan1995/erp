package com.yuf.erp.domain;

public class Goods {
    private int goodsNo;
    private String goodsName;
    private Double goodsPrice;
    private String goodsInfo;
    private int goodsCategoryNo;

    public Goods() {
    }

    public Goods(int goodsNo, String goodsName, Double goodsPrice, String goodsInfo, int goodsCategoryNo) {
        this.goodsNo = goodsNo;
        this.goodsName = goodsName;
        this.goodsPrice = goodsPrice;
        this.goodsInfo = goodsInfo;
        this.goodsCategoryNo = goodsCategoryNo;
    }

    public int getGoodsNo() {
        return goodsNo;
    }

    public void setGoodsNo(int goodsNo) {
        this.goodsNo = goodsNo;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Double getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(Double goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public String getGoodsInfo() {
        return goodsInfo;
    }

    public void setGoodsInfo(String goodsInfo) {
        this.goodsInfo = goodsInfo;
    }

    public int getGoodsCategoryNo() {
        return goodsCategoryNo;
    }

    public void setGoodsCategoryNo(int goodsCategoryNo) {
        this.goodsCategoryNo = goodsCategoryNo;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "goodsNo=" + goodsNo +
                ", goodsName='" + goodsName + '\'' +
                ", goodsPrice=" + goodsPrice +
                ", goodsInfo='" + goodsInfo + '\'' +
                ", goodsCategoryNo=" + goodsCategoryNo +
                '}';
    }
}
