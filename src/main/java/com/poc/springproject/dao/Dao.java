package com.poc.springproject.dao;

import com.poc.springproject.dto.UserDto;
import lombok.SneakyThrows;

import java.sql.ResultSet;

public class Dao {
    private static final String SELECT_ALL_FROM_USERS = "SELECT * FROM USERS";
    private static final String SELECT_USER_BY_ID_FROM_TARGET_DB = "SELECT * FROM USERS WHERE ID = ?";
    private static final String SELECT_USER_BY_ID_AND_EMAIL_FROM_TARGET_DB = "SELECT * FROM USERS WHERE ID = ? AND EMAIL = ?";
    private static final String INSERT_NEW_USER_IN_USER_DB = "INSERT INTO USERS VALUES (?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_USER_IN_USER_DB = "UPDATE USERS SET  name = ?, middlename = ?, lastname = ?, age = ?, email = ? WHERE id = ?";
    private static final String DELETE_USER = "DELETE FROM USERS WHERE id=?";


    @SneakyThrows
    public String getSelectAllFromTargetDb( ){
        return String.format(SELECT_ALL_FROM_USERS);
    }

    @SneakyThrows
    public synchronized String getSelectUserById(){
        return SELECT_USER_BY_ID_FROM_TARGET_DB;
    }

    @SneakyThrows
    public synchronized String getSelectUserByIdAndEmail(){
        return SELECT_USER_BY_ID_AND_EMAIL_FROM_TARGET_DB;
    }

    @SneakyThrows
    public synchronized String insertNewUserToUserDb(){
        return INSERT_NEW_USER_IN_USER_DB;
    }

    @SneakyThrows
    public synchronized String updateUserInUserDb( ){
        return UPDATE_USER_IN_USER_DB;
    }
    @SneakyThrows
    public synchronized String deleteUserFromUserDb( ){
        return DELETE_USER;
    }
}
