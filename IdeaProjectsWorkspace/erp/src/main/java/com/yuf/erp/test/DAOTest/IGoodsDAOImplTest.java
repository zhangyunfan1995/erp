package com.yuf.erp.test.DAOTest;

import com.yuf.erp.DAO.goods.IGoodsDAO;
import com.yuf.erp.DAO.goods.IGoodsDAOImpl;
import com.yuf.erp.domain.Goods;
import org.junit.Test;

import java.util.List;

public class IGoodsDAOImplTest {

    @Test
    public void save() {
        Goods goods = new Goods(5,
                "ipad",
                1000.00,
                "from QIXIN",
                1);
        IGoodsDAO iGoodsDAO = new IGoodsDAOImpl();
        iGoodsDAO.save(goods);
    }

    @Test
    public void update() {
        Goods goods = new Goods(3,
                "ipadd",
                10004.00,
                "from QQIXIN",
                1);
        IGoodsDAO iGoodsDAO = new IGoodsDAOImpl();
        iGoodsDAO.update(3,goods);
    }

    @Test
    public void delete() {
        IGoodsDAO iGoodsDAO = new IGoodsDAOImpl();
        iGoodsDAO.delete(4);
    }

    @Test
    public void get() {
        IGoodsDAO iGoodsDAO = new IGoodsDAOImpl();
        Goods goods = iGoodsDAO.get(5);
            System.out.println(goods.toString());
    }

    @Test
    public void getAll() {
        IGoodsDAO iGoodsDAO = new IGoodsDAOImpl();
        List<Goods> goodsList = iGoodsDAO.getAll();
        System.out.println(goodsList);
    }
}