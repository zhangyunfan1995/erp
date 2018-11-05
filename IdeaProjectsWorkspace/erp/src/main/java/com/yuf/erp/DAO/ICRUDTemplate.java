package com.yuf.erp.DAO;

import com.yuf.erp.DAO.IResultSetHandler;

import java.util.List;


public interface ICRUDTemplate {
    int executeUpdate(String sql,Object... params);
     List executeQuery(String sql, IResultSetHandler iResultSetHandler, Object... params);
}
