package com.poc.springproject.client;

import com.poc.springproject.dao.Dao;
import com.poc.springproject.dao.PostgresDbConnection;
import com.poc.springproject.dto.UserDto;
import lombok.SneakyThrows;

import java.sql.*;

public class SqlClient extends Dao {


    @SneakyThrows
    public Statement getStatement() {
        return PostgresDbConnection.getConnection().createStatement();
    }

    @SneakyThrows
    public ResultSet getAllUsers(final String targetDBTable) {
        return getStatement().executeQuery(getSelectAllFromTargetDb(targetDBTable));
    }

    @SneakyThrows
    public ResultSet getUserById( int userId) {
       return getStatement().executeQuery(getSelectUserById( userId));
    }

    @SneakyThrows
    public ResultSet getUserById( int userId, String email) {
        return getStatement().executeQuery(getSelectUserByIdAndEmail( userId, email));
    }

    @SneakyThrows
    public ResultSet saveNewUserToUserDb(UserDto user) {
        return getStatement().executeQuery(insertNewUserToUserDb(user));
    }

    @SneakyThrows
    public ResultSet updateUser(UserDto user, int userId) {
        return getStatement().executeQuery(updateUserInUserDb(user, userId));
    }
}
