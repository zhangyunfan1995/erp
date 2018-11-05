package com.yuf.erp.DAO.goods;

import com.yuf.erp.domain.Goods;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public interface IGoodsDAO {
    Connection conn = null;
    PreparedStatement ps = null;
    Statement st = null;
    ResultSet rs = null;
//    1.增加一条新数据
    void save(Goods goods);
//    2.修改指定数据
    void update(int goodsNo, Goods goods);
//    3.删除一条新数据
    void delete(int goodsNo);
//    4.查询指定数据
    Goods get(int goodsNo);
//    5.查询所有数据
    List<Goods> getAll();
}
