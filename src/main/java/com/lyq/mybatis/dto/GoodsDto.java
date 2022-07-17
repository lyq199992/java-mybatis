package com.lyq.mybatis.dto;

import com.lyq.mybatis.entity.Goods;

// 对原始 Goods 对象数据进行修改
// Data Transfer Object 数据传输对象
public class GoodsDto {
    private Goods goods = new Goods();
    private String categoryName;
    private String goods_name;

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getGoods_name() {
        return goods_name;
    }

    public void setGoods_name(String goods_name) {
        this.goods_name = goods_name;
    }
}
