package com.poc.springproject.dao;

import com.poc.springproject.dto.UserDto;
import lombok.SneakyThrows;

import java.sql.ResultSet;

public class Dao {
    private static final String SELECT_ALL_FROM_TARGET_DB = "SELECT * FROM %s";
    private static final String SELECT_USER_BY_ID_FROM_TARGET_DB = "SELECT NAME, MIDDLENAME, LASTNAME, AGE, EMAIL FROM USERS WHERE ID = %d";
    private static final String SELECT_USER_BY_ID_AND_EMAIL_FROM_TARGET_DB = "SELECT NAME, MIDDLENAME, LASTNAME, AGE, EMAIL FROM %s WHERE ID = %d AND EMAIL = %s";
    private static final String INSERT_NEW_USER_IN_USER_DB = "INSERT INTO USERS VALUES %s, %s, %s, %d, %s";
    private static final String UPDATE_USER_IN_USER_DB = "UPDATE USERS SETS %s, %s, %s, %d, %s WHERE id = %d";


    @SneakyThrows
    public String getSelectAllFromTargetDb( String targetDbName ){
        return String.format(SELECT_ALL_FROM_TARGET_DB, targetDbName);
    }

    @SneakyThrows
    public synchronized String getSelectUserById( int userId ){
        return String.format(SELECT_USER_BY_ID_FROM_TARGET_DB, userId);
    }

    @SneakyThrows
    public synchronized String getSelectUserByIdAndEmail( int userId, String email ){
        return String.format(SELECT_USER_BY_ID_AND_EMAIL_FROM_TARGET_DB, userId, email);
    }

    @SneakyThrows
    public synchronized String insertNewUserToUserDb( UserDto user ){
        return String.format(INSERT_NEW_USER_IN_USER_DB, user.getName(), user.getMiddleName(), user.getLastname(), user.getAge(), user.getEmail());
    }

    @SneakyThrows
    public synchronized String updateUserInUserDb( UserDto user, int userId ){
        return String.format(UPDATE_USER_IN_USER_DB, user.getName(), user.getMiddleName(), user.getLastname(), user.getAge(), user.getEmail(), userId);
    }
}
