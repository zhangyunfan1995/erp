package com.yuf.erp.DAO.category;

import com.yuf.erp.DAO.IResultSetHandler;
import com.yuf.erp.domain.Category;
import com.yuf.erp.DAO.ICRUDTemplateImpl;

import java.util.List;

public class ICategoryDAOImpl implements ICategoryDAO {


    @Override
    public void save(Category category) {
        String sql = "INSERT INTO category(categoryNo,category) VALUES (?,?)";
        new ICRUDTemplateImpl().executeUpdate(
                sql,
                category.getCategoryNo(),
                category.getCategory());
    }

    @Override
    public void update(int categoryNo, Category category) {
        String sql = "UPDATE category SET categoryNo = ?,category = ? WHERE categoryNo = ?";
        new ICRUDTemplateImpl().executeUpdate(
                sql,
                category.getCategoryNo(),
                category.getCategory(),
                categoryNo);
    }

    @Override
    public void delete(int categoryNo) {
        String sql = "DELETE FROM category WHERE categoryNo = ?";
        new ICRUDTemplateImpl().executeUpdate(
                sql,
                categoryNo);
    }

    @Override
    public Category get(int categoryNo) {
        String sql = "SELECT * FROM category WHERE categoryNo = ?";
        IResultSetHandler<List<Category>> iResultSetHandler = new ICategoryResultSetHandlerImpl();
        List<Category> categoriesList = new ICRUDTemplateImpl().executeQuery(sql,iResultSetHandler, categoryNo);
        if(categoriesList.size()==1){
            return categoriesList.get(0);
        }else{
            return null;
        }
    }

    @Override
    public List<Category> getAll() {
        String sql = "SELECT * FROM category ";
        IResultSetHandler<List<Category>> iResultSetHandler = new ICategoryResultSetHandlerImpl();
        List<Category> categoriesList = new ICRUDTemplateImpl().executeQuery(sql,iResultSetHandler);
        if(categoriesList != null) {
            return categoriesList;
        }else {
            return null;
        }
    }
}

