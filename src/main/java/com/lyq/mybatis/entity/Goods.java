package com.lyq.mybatis.entity;

public class Goods {
    private Integer goodsId;
    private String goodsName;
    private Integer categoryId;

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Goods() {
    }

    public Goods(Integer goodsId, String goodsName) {
        this.goodsId = goodsId;
        this.goodsName = goodsName;
    }
}
