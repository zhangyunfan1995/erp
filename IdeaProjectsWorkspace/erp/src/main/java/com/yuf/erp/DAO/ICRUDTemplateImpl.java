package com.yuf.erp.DAO;

import com.yuf.erp.DAO.ICRUDTemplate;
import com.yuf.erp.DAO.IResultSetHandler;
import com.yuf.erp.utils.JdbcUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ICRUDTemplateImpl implements ICRUDTemplate {
    Connection conn = null;
    PreparedStatement ps = null;
    Statement st = null;
    ResultSet rs = null;
    @Override
    public int executeUpdate(String sql, Object ... params) {
        try {
            conn = JdbcUtils.getConn();
            ps = conn.prepareStatement(sql);
            for(int i = 0;i < params.length;i++) {
                ps.setObject(i+1,params[i]);
            }
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(conn,ps,st,rs);
        }
        return 0;
    }

    @Override
    public List executeQuery(String sql,IResultSetHandler iResultSetHandler, Object... params) {
        try {
            conn = JdbcUtils.getConn();
            ps = conn.prepareStatement(sql);
            for(int i = 0;i < params.length;i++) {
                ps.setObject(i+1,params[i]);
            }
            rs = ps.executeQuery();
            List handler = iResultSetHandler.Handler(rs);
            return handler;


        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(conn,ps,st,rs);
        }
        return null;
    }

}
