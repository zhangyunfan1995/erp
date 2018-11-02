package com.yuf.erp.test.DAOTest;

import com.yuf.erp.DAO.ICategoryDAO;
import com.yuf.erp.DAO.impl.CategoryDAOImpl;
import com.yuf.erp.domain.Category;
import com.yuf.erp.domain.Goods;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class CategoryDAOImplTest {

    @Test
    public void save() {
        Category category = new Category(4, "ipsaud");
        ICategoryDAO iCategoryDAO = new CategoryDAOImpl();
        iCategoryDAO.save(category);
    }

    @Test
    public void update() {
        Category category = new Category(2, "ipaddmm");
        ICategoryDAO iCategoryDAO = new CategoryDAOImpl();
        iCategoryDAO.update(2,category);
    }

    @Test
    public void delete() {
        ICategoryDAO iCategoryDAO = new CategoryDAOImpl();
        iCategoryDAO.delete(2);
    }

    @Test
    public void get() {
        ICategoryDAO iCategoryDAO = new CategoryDAOImpl();
        Category category = iCategoryDAO.get(1);
        System.out.println(category.toString());
    }

    @Test
    public void getAll() {
        ICategoryDAO iCategoriesDAO = new CategoryDAOImpl();
        List<Category> categoryList = iCategoriesDAO.getAll();
        System.out.println(categoryList);
    }
}