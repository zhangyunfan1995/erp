package com.yuf.erp.test;

import com.yuf.erp.utils.JdbcUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;


public class JdbcUtilsTest {
    Connection conn = null;
    @Test
    public void getConn() throws SQLException, ClassNotFoundException {
        this.conn = JdbcUtils.getConn();
        System.out.println(this.conn);
        this.conn.close();
    }
}