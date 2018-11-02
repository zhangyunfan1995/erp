package com.yuf.erp.DAO.impl;

import com.yuf.erp.DAO.IUserDAO;
import com.yuf.erp.domain.User;
import com.yuf.erp.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements IUserDAO {
    Connection conn = null;
    Statement st = null;
    ResultSet rs = null;
    @Override
    public void save(User user) {
        try {
            this.conn = JdbcUtils.getConn();
            this.st = this.conn.createStatement();
            String sql = "INSERT INTO user(userId,userName,userPwd,userEmail) " +
                    "VALUES ("+ user.getUserId()+"," +
                    "'"+ user.getUserName()+"'," +
                    "'"+ user.getUserPwd()+"'," +
                    "'"+user.getUserEmail()+"')";
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
    public void update(int userId, User user) {
        try {
            this.conn = JdbcUtils.getConn();
            this.st = this.conn.createStatement();
            String sql = "UPDATE user SET " +
                    "userId = "+user.getUserId()+" ," +
                    "userName = '"+user.getUserName()+"' ," +
                    "userPwd = '"+user.getUserPwd()+"'," +
                    "userEmail = '"+user.getUserEmail()+"' " ;
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
    public void delete(int userId) {
        try {
            this.conn = JdbcUtils.getConn();
            this.st = this.conn.createStatement();
            String sql = "DELETE FROM user WHERE userId = "+userId+"";
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
    public User get(int userId) {
        User user = new User();
        try {
            this.conn = JdbcUtils.getConn();
            this.st = this.conn.createStatement();
            String sql = "SELECT * FROM user WHERE userId = "+userId+"";
            System.out.println(sql);
            this.rs = this.st.executeQuery(sql);
            if (this.rs.next()){
                user.setUserId(this.rs.getInt("userId"));
                user.setUserName(this.rs.getString("userName"));
                user.setUserPwd(this.rs.getString("userPwd"));
                user.setUserEmail(this.rs.getString("userEmail"));
                return user;
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
    public List<User> getAll() {
        try {
            this.conn = JdbcUtils.getConn();
            this.st = this.conn.createStatement();
            String sql = "SELECT * FROM user";
            System.out.println(sql);
            this.rs = this.st.executeQuery(sql);
            List<User> usersList = new ArrayList<>();
            while (this.rs.next()){
                User user = new User();
                user.setUserId(this.rs.getInt("userId"));
                user.setUserName(this.rs.getString("userName"));
                user.setUserPwd(this.rs.getString("userPwd"));
                user.setUserEmail(this.rs.getString("userEmail"));
                usersList.add(user);
            }
            return usersList;
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
