package com.yuf.erp.DAO.category;

import com.yuf.erp.DAO.IResultSetHandler;
import com.yuf.erp.domain.Category;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ICategoryResultSetHandlerImpl implements IResultSetHandler<List<Category>> {
    @Override
    public List<Category> Handler(ResultSet rs) {
        Category category = new Category();
        List<Category> categoriesList = new ArrayList<>();
        try {
            while(rs.next()) {
                category.setCategoryNo(rs.getInt("categoryNo"));
                category.setCategory(rs.getString("category"));
                categoriesList.add(category);
            }
            return categoriesList;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
