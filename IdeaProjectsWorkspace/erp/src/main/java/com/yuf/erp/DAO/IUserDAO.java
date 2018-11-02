package com.yuf.erp.DAO;

import com.yuf.erp.domain.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public interface IUserDAO {
    Connection conn = null;
    Statement st = null;
    ResultSet rs = null;
    //    1.增加一条新数据
    void save(User user);
    //    2.修改指定数据
    void update(int userId, User user);
    //    3.删除一条新数据
    void delete(int userId);
    //    4.查询指定数据
     User get(int userId);
    //    5.查询所有数据
    List<User> getAll();
}
