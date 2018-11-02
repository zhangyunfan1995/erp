package com.yuf.erp.DAO.impl;

import com.yuf.erp.DAO.ICategoryDAO;
import com.yuf.erp.domain.Category;
import com.yuf.erp.utils.CRUDTemplate;
import com.yuf.erp.utils.JdbcUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class CategoryDAOImpl implements ICategoryDAO {
    @Override
    public void save(Category category) {
        String sql = "INSERT INTO category(categoryNo,category) VALUES (?,?)";
        CRUDTemplate.executeUpdate(sql, category.getCategoryNo(), category.getCategory());
    }

    @Override
    public void update(int categoryNo, Category category) {
        String sql = "UPDATE category SET categoryNo = ? ,category = ? WHERE categoryNo = ?";
        CRUDTemplate.executeUpdate(sql, category.getCategoryNo(), category.getCategory(), categoryNo);
    }

    @Override
    public void delete(int categoryNo) {
            String sql = "DELETE FROM category WHERE categoryNo = ?";
            CRUDTemplate.executeUpdate(sql,categoryNo);
    }

    @Override
    public Category get(int categoryNo) {
        Category category = new Category();
            String sql = "SELECT * FROM category WHERE categoryNo = ?";
        List categoriesList = CRUDTemplate.executeQuery(sql, categoryNo);

    }

    @Override
    public List<Category> getAll() {

            String sql = "SELECT * FROM category";

}
