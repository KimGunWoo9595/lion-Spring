package com.lion.refactoring7;

import com.lion.domain.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddStrategy implements StatementStrategy {
    //AddStrategy 
    private User user;

    public AddStrategy(User user) {
        this.user = user;
    }

    @Override
    public PreparedStatement makePreparedStatement(Connection connection) throws SQLException {

        PreparedStatement pstmt = connection.prepareStatement(
                "INSERT INTO users(id, name, password) VALUES(?,?,?);");
        pstmt.setString(1, user.getId());
        pstmt.setString(2, user.getName());
        pstmt.setString(3, user.getPassword());
        return pstmt;
    }
}
