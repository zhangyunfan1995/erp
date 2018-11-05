package com.yuf.erp.DAO;

import com.yuf.erp.domain.Category;
import com.yuf.erp.domain.Goods;
import com.yuf.erp.domain.User;

import java.sql.ResultSet;
import java.util.List;

public interface IResultSetHandler {
     List Handler(ResultSet rs);
}
