package com.yuf.erp.test.jdbcUtilsTest;

import com.yuf.erp.utils.JdbcUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;


public class JdbcUtilsTest {
    Connection conn1 = null;
    Connection conn2 = null;
    @Test
    public void getConn() throws SQLException, ClassNotFoundException {
        this.conn1 = JdbcUtils.getConn();
        System.out.println(this.conn1);
        this.conn2 = JdbcUtils.getConn();
        System.out.println(this.conn2);
        this.conn1.close();
        this.conn2.close();
    }
}