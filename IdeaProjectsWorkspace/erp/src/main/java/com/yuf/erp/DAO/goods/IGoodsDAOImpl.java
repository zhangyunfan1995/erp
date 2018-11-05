package com.yuf.erp.DAO.goods;

import com.yuf.erp.domain.Goods;
import com.yuf.erp.DAO.IResultSetHandler;
import com.yuf.erp.DAO.ICRUDTemplateImpl;
import com.yuf.erp.utils.JdbcUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class IGoodsDAOImpl implements IGoodsDAO {
    private Connection conn = null;
    private  PreparedStatement ps = null;
    private Statement st = null;
    private ResultSet rs = null;
    @Override
    public void save(Goods goods) {
        String sql = "INSERT INTO goods(goodsNo,goodsName,goodsPrice,goodsInfo,goodsCategoryNo) VALUES (?,?,?,?,?)";
        new ICRUDTemplateImpl().executeUpdate(
                sql,
                goods.getGoodsNo(),
                goods.getGoodsName(),
                goods.getGoodsPrice(),
                goods.getGoodsInfo(),
                goods.getGoodsCategoryNo());
    }

    @Override
    public void update(int goodsNo,Goods goods) {
            String sql = "UPDATE goods SET goodsNo = ?,goodsName =?,goodsPrice =?,goodsInfo =?,goodsCategoryNo =? WHERE goodsNo = ?";
            new ICRUDTemplateImpl().executeUpdate(
                    sql,
                    goods.getGoodsNo(),
                    goods.getGoodsName(),
                    goods.getGoodsPrice(),
                    goods.getGoodsInfo(),
                    goods.getGoodsCategoryNo(),
                    goodsNo);

    }

    @Override
    public void delete(int goodsNo) {
        String sql = "DELETE FROM goods WHERE goodsNo = ?";
        new ICRUDTemplateImpl().executeUpdate(
                sql,
                goodsNo);
    }

    @Override
    public Goods get(int goodsNo) {

        String sql = "SELECT * FROM goods WHERE goodsNo = ?";
        IResultSetHandler iResultSetHandler = new IResultSetHandlerImpl();
        List goodslist = new ICRUDTemplateImpl().executeQuery(sql, iResultSetHandler, goodsNo);
        if (goodslist.size() ==1){
            return (Goods)goodslist.get(0);
        }else {
            return null;
        }
    }

    @Override
    public List<Goods> getAll() {

        String sql = "SELECT * FROM goods";
        IResultSetHandler iResultSetHandler = new IResultSetHandlerImpl();
        List goodsList = new ICRUDTemplateImpl().executeQuery(sql, iResultSetHandler);
        return goodsList;
    }
}
