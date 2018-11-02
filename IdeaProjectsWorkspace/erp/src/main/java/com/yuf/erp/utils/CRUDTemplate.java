package com.yuf.erp.utils;

import com.yuf.erp.domain.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class CRUDTemplate {

    private static Connection conn = null;
    private static Statement st = null;
    private static ResultSet rs = null;

    /**
     *
     * @param sql
     * @param param
     * @return
     */
    public static int executeUpdate(String sql,Object ... param){
        try {
            conn = JdbcUtils.getConn();
            PreparedStatement ps = conn.prepareStatement(sql);
            for(int i = 0;i<param.length;i++){
                ps.setObject(i+1,param[i]);
            }
            return ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                JdbcUtils.close(conn,st,rs);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    public static List executeQuery(String sql, Object ... param) {
        try {
            conn = JdbcUtils.getConn();
            PreparedStatement ps = conn.prepareStatement(sql);
            for (int i = 0; i < param.length; i++) {
                ps.setObject(i + 1, param[i]);
            }
            rs = ps.executeQuery();
            while (rs.next()){
                Category category = new Category();
                category.setCategoryNo(rs.getInt("categoryNo"));
                category.setCategory(rs.getString("category"));
                List<Category> categoriesList = null;
                categoriesList.add(category);
                return categoriesList;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                JdbcUtils.close(conn, st, rs);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
