package com.yuf.erp.utils.Impl;

import com.yuf.erp.utils.ICRUDTemplate;
import com.yuf.erp.utils.JdbcUtils;

import java.sql.*;

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
    public PreparedStatement executeQuery(String sql, Object... params) {
        return null;
    }
}
