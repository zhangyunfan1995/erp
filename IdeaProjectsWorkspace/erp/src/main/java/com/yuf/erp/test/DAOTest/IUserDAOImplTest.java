package com.yuf.erp.test.DAOTest;

import com.yuf.erp.DAO.user.IUserDAO;
import com.yuf.erp.DAO.user.IUserDAOImpl;
import com.yuf.erp.domain.User;
import org.junit.Test;

import java.util.List;

public class IUserDAOImplTest {

    @Test
    public void save() {
        User user = new User(4,"root","root","1");
        IUserDAO iUserDAO = new IUserDAOImpl();
        iUserDAO.save(user);
    }

    @Test
    public void update() {
        User user = new User(1,
                "ipadd",
                "from QQIXIN",
                "1");
        IUserDAO iUserDAO = new IUserDAOImpl();
        iUserDAO.update(1,user);
    }

    @Test
    public void delete() {
        IUserDAO iUserDAO = new IUserDAOImpl();
        iUserDAO.delete(3);
    }

    @Test
    public void get() {
        IUserDAO iUserDAO = new IUserDAOImpl();
        User user = iUserDAO.get(1);
        System.out.println(user.toString());
    }

    @Test
    public void getAll() {
        IUserDAO iUserDAO = new IUserDAOImpl();
        List<User> usersList = iUserDAO.getAll();
        System.out.println(usersList);
    }
}