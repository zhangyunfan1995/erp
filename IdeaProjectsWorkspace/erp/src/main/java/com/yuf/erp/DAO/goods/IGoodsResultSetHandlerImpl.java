package com.yuf.erp.DAO.goods;

import com.yuf.erp.DAO.IResultSetHandler;
import com.yuf.erp.domain.Goods;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IGoodsResultSetHandlerImpl implements IResultSetHandler<List<Goods>> {
    @Override
    public List<Goods> Handler(ResultSet rs) {
        Goods goods = new Goods();
        List<Goods> goodsList = new ArrayList();
        try {
            while (rs.next()) {
                goods.setGoodsNo(rs.getInt("goodsNo"));
                goods.setGoodsName(rs.getString("goodsName"));
                goods.setGoodsPrice(rs.getDouble("goodsPrice"));
                goods.setGoodsInfo(rs.getString("goodsInfo"));
                goods.setGoodsCategoryNo(rs.getInt("goodsCategoryNo"));
                goodsList.add(goods);
            }
            return goodsList;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}

