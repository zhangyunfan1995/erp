package com.yuf.erp.DAO.user;

import com.yuf.erp.DAO.ICRUDTemplate;
import com.yuf.erp.DAO.IResultSetHandler;
import com.yuf.erp.domain.User;
import com.yuf.erp.DAO.ICRUDTemplateImpl;
import com.yuf.erp.utils.JdbcUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class IUserDAOImpl implements IUserDAO {
    private Connection conn = null;
    private PreparedStatement ps = null;
    private Statement st = null;
    private ResultSet rs = null;
    @Override
    public void save(User user) {
        String sql = "INSERT INTO user (userId,userName,userPwd,userEmail) VALUES (?,?,?,?)";
        new ICRUDTemplateImpl().executeUpdate(
                sql,
                user.getUserId(),
                user.getUserName(),
                user.getUserPwd(),
                user.getUserEmail());
    }


    @Override
    public void update(int userId, User user) {
        String sql = "UPDATE user SET userId = ?,userName = ?,userPwd = ?,userEmail = ? WHERE userId = ?";
        new ICRUDTemplateImpl().executeUpdate(
                sql,
                user.getUserId(),
                user.getUserName(),
                user.getUserPwd(),
                user.getUserEmail(),
                userId);
    }

    @Override
    public void delete(int userId) {

            String sql = "DELETE FROM user WHERE userId = ?";
            new ICRUDTemplateImpl().executeUpdate(
                    sql,
                    userId);
    }

    @Override
    public User get(int userId) {
        String sql = "SELECT * FROM user WHERE userId = ?";
        ICRUDTemplate icrudTemplate = new ICRUDTemplateImpl();
        IResultSetHandler iResultSetHandler = new IResultSetHandlerImpl();
        List userslist = icrudTemplate.executeQuery(sql, iResultSetHandler, userId);
        if (userslist.size() == 1){
            return (User) userslist.get(0);
        }else {
            return null;
        }

    }

    @Override
    public List<User> getAll() {
        String sql = "SELECT * FROM user";
        ICRUDTemplate icrudTemplate = new ICRUDTemplateImpl();
        IResultSetHandler iResultSetHandler = new IResultSetHandlerImpl();
        List userslist = icrudTemplate.executeQuery(sql, iResultSetHandler);
        if (userslist.size() != 0) {
            return userslist;
        } else {
            return null;
        }
    }
}
