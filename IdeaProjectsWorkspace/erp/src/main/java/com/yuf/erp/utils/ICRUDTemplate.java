package com.yuf.erp.utils;

import java.sql.PreparedStatement;

public interface ICRUDTemplate {
    int executeUpdate(String sql,Object... params);
    PreparedStatement executeQuery(String sql,Object... params);
}
