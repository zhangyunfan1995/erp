package com.yuf.erp.test.DAOTest;

import com.yuf.erp.DAO.IGoodsDAO;
import com.yuf.erp.DAO.IUserDAO;
import com.yuf.erp.DAO.impl.UserDAOImpl;
import com.yuf.erp.domain.User;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class UserDAOImplTest {

    @Test
    public void save() {
        User user = new User(3,"root","root","1");
        IUserDAO iUserDAO = new UserDAOImpl();
        iUserDAO.save(user);
    }

    @Test
    public void update() {
        User user = new User(1,
                "ipadd",
                "from QQIXIN",
                "1");
        IUserDAO iUserDAO = new UserDAOImpl();
        iUserDAO.update(1,user);
    }

    @Test
    public void delete() {
        IUserDAO iUserDAO = new UserDAOImpl();
        iUserDAO.delete(1);
    }

    @Test
    public void get() {
        IUserDAO iUserDAO = new UserDAOImpl();
        User user = iUserDAO.get(1);
        System.out.println(user.toString());
    }

    @Test
    public void getAll() {
        IUserDAO iUserDAO = new UserDAOImpl();
        List<User> usersList = iUserDAO.getAll();
        System.out.println(usersList);
    }
}