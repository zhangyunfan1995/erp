package com.yuf.erp.test.DAOTest;

import com.yuf.erp.DAO.category.ICategoryDAO;
import com.yuf.erp.DAO.category.ICategoryDAOImpl;
import com.yuf.erp.domain.Category;
import org.junit.Test;

import java.util.List;

public class ICategoryDAOImplTest {

    @Test
    public void save() {
        Category category = new Category(20, "ipsaud");
        ICategoryDAO iCategoryDAO = new ICategoryDAOImpl();
        iCategoryDAO.save(category);
    }

    @Test
    public void update() {
        Category category = new Category(20, "ipaddmm");
        ICategoryDAO iCategoryDAO = new ICategoryDAOImpl();
        iCategoryDAO.update(20,category);
    }

    @Test
    public void delete() {
        ICategoryDAO iCategoryDAO = new ICategoryDAOImpl();
        iCategoryDAO.delete(20);
    }

    @Test
    public void get() {
        ICategoryDAO iCategoryDAO = new ICategoryDAOImpl();
        Category category = iCategoryDAO.get(3);
        System.out.println(category.toString());
    }

    @Test
    public void getAll() {
        ICategoryDAO iCategoriesDAO = new ICategoryDAOImpl();
        List<Category> categoryList = iCategoriesDAO.getAll();
        System.out.println(categoryList);
    }
}