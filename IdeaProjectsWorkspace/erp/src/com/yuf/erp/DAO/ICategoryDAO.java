package com.yuf.erp.DAO;

import com.yuf.erp.domain.Category;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public interface ICategoryDAO {
    Connection conn = null;
    Statement st = null;
    ResultSet rs = null;
    //    1.增加一条新数据
    void save(Category category);
    //    2.修改指定数据
    void update(int categoryNo,Category category);
    //    3.删除一条新数据
    void delete(int categoryNo);
    //    4.查询指定数据
    Category get(int categoryNo);
    //    5.查询所有数据
    List<Category> getAll();
}
