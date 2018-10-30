package com.yuf.erp.DAO.impl;

import com.yuf.erp.DAO.ICategoryDAO;
import com.yuf.erp.domain.Category;
import com.yuf.erp.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAOImpl implements ICategoryDAO {
    Connection conn = null;
    Statement st = null;
    ResultSet rs = null;
    @Override
    public void save(Category category) {
        try {
            this.conn = JdbcUtils.getConn();
            this.st = this.conn.createStatement();
            String sql = "INSERT INTO category(categoryNo,category) " +
                    "VALUES ("+ category.getCategoryNo()+"," +
                    "'"+ category.getCategory()+"')";
            System.out.println(sql);
            this.st.executeUpdate(sql);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                JdbcUtils.close(this.conn,this.st,this.rs);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void update(int categoryNo, Category category) {
        try {
            this.conn = JdbcUtils.getConn();
            this.st = this.conn.createStatement();
            String sql = "UPDATE category SET " +
                    "categoryNo = "+category.getCategoryNo()+" ," +
                    "category = '"+category.getCategory()+"'" +
                    "WHERE categoryNo = "+categoryNo;
            System.out.println(sql);
            this.st.executeUpdate(sql);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                JdbcUtils.close(this.conn,this.st,this.rs);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void delete(int categoryNo) {
        try {
            this.conn = JdbcUtils.getConn();
            this.st = this.conn.createStatement();
            String sql = "DELETE FROM category WHERE categoryNo = "+categoryNo+"";
            System.out.println(sql);
            this.st.executeUpdate(sql);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                JdbcUtils.close(this.conn,this.st,this.rs);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public Category get(int categoryNo) {
        Category category = new Category();
        try {
            this.conn = JdbcUtils.getConn();
            this.st = this.conn.createStatement();
            String sql = "SELECT * FROM category WHERE categoryNo = "+categoryNo+"";
            System.out.println(sql);
            this.rs = this.st.executeQuery(sql);
            if (this.rs.next()){
                category.setCategoryNo(this.rs.getInt("categoryNo"));
                category.setCategory(this.rs.getString("category"));
                return category;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                JdbcUtils.close(this.conn,this.st,this.rs);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public List<Category> getAll() {
         try {
            this.conn = JdbcUtils.getConn();
            this.st = this.conn.createStatement();
            String sql = "SELECT * FROM category";
            System.out.println(sql);
            this.rs = this.st.executeQuery(sql);
            List<Category> categoriesList = new ArrayList<>();
            while (this.rs.next()){
                Category category = new Category();
                category.setCategoryNo(this.rs.getInt("categoryNo"));
                category.setCategory(this.rs.getString("category"));
                categoriesList.add(category);
            }
            return categoriesList;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                JdbcUtils.close(this.conn,this.st,this.rs);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
