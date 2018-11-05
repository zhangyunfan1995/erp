package com.yuf.erp.DAO.user;

import com.yuf.erp.DAO.IResultSetHandler;
import com.yuf.erp.domain.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IResultSetHandlerImpl implements IResultSetHandler {
    @Override
    public List Handler(ResultSet rs) {
        User user = new User();
        List usersList = new ArrayList();
        try {
            while (rs.next()) {
                user.setUserId(rs.getInt("userId"));
                user.setUserName(rs.getString("userName"));
                user.setUserPwd(rs.getString("userPwd"));
                user.setUserEmail(rs.getString("userEmail"));
                usersList.add(user);
            }
            return usersList;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
