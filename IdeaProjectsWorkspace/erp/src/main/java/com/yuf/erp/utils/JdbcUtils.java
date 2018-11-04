package com.yuf.erp.utils;


import com.alibaba.druid.pool.DruidDataSource;

import java.sql.*;

public class JdbcUtils {
    private JdbcUtils() {}

    private static final JdbcUtils jdbcUtils = new JdbcUtils();

//    public static Connection getConn() throws ClassNotFoundException, SQLException {
//        String url = "jdbc:mysql://localhost:3306/demo";
//        String user = "root";
//        String password = "root";
////        1.加载容器
//        Class.forName("com.mysql.jdbc.Driver");
////        2.获取连接
//        Connection conn = DriverManager.getConnection(url, user, password);
//        return conn;
//    }
//    public static void close(Connection conn, Statement st, ResultSet rs){
//        if(conn != null){
//            try {
//                conn.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//        if(st != null){
//            try {
//                st.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//        if(rs != null){
//            try {
//                rs.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//    }

    public static Connection getConn() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/demo";
        String user = "root";
//        String password = "root";
        String password = "zhangyunfan371!";
        String driverName = "com.mysql.jdbc.Driver";

//        配置连接池
        DruidDataSource ds = new DruidDataSource();
        ds.setDriverClassName(driverName);
        ds.setUsername(user);
        ds.setPassword(password);
        ds.setUrl(url);
//        获取连接
        Connection conn = ds.getConnection();
        return conn;
    }
    public static void close(Connection conn, PreparedStatement ps,Statement st, ResultSet rs) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (st != null) {
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public JdbcUtils getJdbcUtils() {
        return jdbcUtils;
    }
}
