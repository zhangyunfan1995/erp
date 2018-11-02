package com.yuf.erp.DAO.impl;

import com.yuf.erp.DAO.IGoodsDAO;
import com.yuf.erp.domain.Goods;
import com.yuf.erp.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GoodsDAOImpl implements IGoodsDAO {
    private Connection conn = null;
    private Statement st = null;
    private ResultSet rs = null;
    @Override
    public void save(Goods goods) {

        try {
            this.conn = JdbcUtils.getConn();
            this.st = this.conn.createStatement();
            String sql = "INSERT INTO goods(goodsNo,goodsName,goodsPrice,goodsInfo,goodsCategoryNo) " +
                    "VALUES ("+ goods.getGoodsNo()+"," +
                    "'"+ goods.getGoodsName()+"'," +
                    ""+ goods.getGoodsPrice()+"," +
                    "'"+ goods.getGoodsInfo()+"'," +
                    ""+ goods.getGoodsCategoryNo()+")";
            System.out.println(sql);
            this.st.executeUpdate(sql);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                JdbcUtils.close(this.conn,this.st,this.rs);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void update(int goodsNo,Goods goods) {
        try {
            this.conn = JdbcUtils.getConn();
            this.st = this.conn.createStatement();
            String sql = "UPDATE goods SET " +
                    "goodsNo = "+goods.getGoodsNo()+" ," +
                    "goodsName = '"+goods.getGoodsName()+"' ," +
                    "goodsPrice = "+goods.getGoodsPrice()+"," +
                    "goodsInfo = '"+goods.getGoodsInfo()+"' ," +
                    "goodsCategoryNo = "+goods.getGoodsCategoryNo()+" "+
                    "WHERE goodsNo = "+goodsNo+"";
            System.out.println(sql);
            this.st.executeUpdate(sql);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                JdbcUtils.close(this.conn,this.st,this.rs);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void delete(int goodsNo) {
        try {
            this.conn = JdbcUtils.getConn();
            this.st = this.conn.createStatement();
            String sql = "DELETE FROM goods WHERE goodsNo = "+goodsNo+"";
            System.out.println(sql);
            this.st.executeUpdate(sql);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                JdbcUtils.close(this.conn,this.st,this.rs);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public Goods get(int goodsNo) {
        Goods goods = new Goods();
        try {
            this.conn = JdbcUtils.getConn();
            this.st = this.conn.createStatement();
            String sql = "SELECT * FROM goods WHERE goodsNo = "+goodsNo+"";
            System.out.println(sql);
            this.rs = this.st.executeQuery(sql);
            if (this.rs.next()){
                goods.setGoodsNo(this.rs.getInt("goodsNo"));
                goods.setGoodsName(this.rs.getString("goodsName"));
                goods.setGoodsPrice(this.rs.getDouble("goodsPrice"));
                goods.setGoodsInfo(this.rs.getString("goodsInfo"));
                goods.setGoodsCategoryNo(this.rs.getInt("goodsCategoryNo"));
                return goods;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                JdbcUtils.close(this.conn,this.st,this.rs);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public List<Goods> getAll() {
        try {
            this.conn = JdbcUtils.getConn();
            this.st = this.conn.createStatement();
            String sql = "SELECT * FROM goods";
            System.out.println(sql);
            this.rs = this.st.executeQuery(sql);
            List<Goods> goodsList = new ArrayList<>();
            while (this.rs.next()){
                Goods goods = new Goods();
                goods.setGoodsNo(this.rs.getInt("goodsNo"));
                goods.setGoodsName(this.rs.getString("goodsName"));
                goods.setGoodsPrice(this.rs.getDouble("goodsPrice"));
                goods.setGoodsInfo(this.rs.getString("goodsInfo"));
                goods.setGoodsCategoryNo(this.rs.getInt("goodsCategoryNo"));
                goodsList.add(goods);
            }
            return goodsList;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                JdbcUtils.close(this.conn,this.st,this.rs);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
