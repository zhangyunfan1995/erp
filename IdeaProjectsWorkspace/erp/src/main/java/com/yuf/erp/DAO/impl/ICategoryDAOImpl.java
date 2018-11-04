package com.yuf.erp.DAO.impl;

import com.yuf.erp.DAO.ICategoryDAO;
import com.yuf.erp.domain.Category;
import com.yuf.erp.utils.ICRUDTemplate;
import com.yuf.erp.utils.Impl.ICRUDTemplateImpl;
import com.yuf.erp.utils.JdbcUtils;

import java.sql.*;
import java.util.List;

public class ICategoryDAOImpl implements ICategoryDAO {


    @Override
    public void save(Category category) {
        String sql = "INSERT INTO category(categoryNo,category) VALUES (?,?)";
        new ICRUDTemplateImpl().executeUpdate(sql, category.getCategoryNo(), category.getCategory());
    }

    @Override
    public void update(int categoryNo, Category category) {
        String sql = "UPDATE category SET categoryNo = ?,category = ? WHERE categoryNo = ?";
        new ICRUDTemplateImpl().executeUpdate(sql, category.getCategoryNo(), category.getCategory(),categoryNo);
    }

    @Override
    public void delete(int categoryNo) {
        String sql = "DELETE FROM category WHERE categoryNo = ?";
        new ICRUDTemplateImpl().executeUpdate(sql, categoryNo);
    }

    @Override
    public Category get(int categoryNo) {
        return null;
    }

    @Override
    public List<Category> getAll() {
        return null;
    }
}
