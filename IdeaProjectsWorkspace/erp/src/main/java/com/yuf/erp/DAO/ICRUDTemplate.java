package com.yuf.erp.DAO;

import com.yuf.erp.DAO.IResultSetHandler;

import java.util.List;


public interface ICRUDTemplate {
    int executeUpdate(String sql,Object... params);
     <T>T executeQuery(String sql, IResultSetHandler<T> iResultSetHandler, Object... params);
}
