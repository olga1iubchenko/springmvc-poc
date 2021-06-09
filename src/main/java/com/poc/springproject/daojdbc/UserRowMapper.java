package com.poc.springproject.daojdbc;

import com.poc.springproject.dto.UserDto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<UserDto> {
    @Override
    public UserDto mapRow(ResultSet resultSet, int i) throws SQLException {
        UserDto user = new UserDto();
        user.setName(resultSet.getString("name"));
        user.setMiddleName(resultSet.getString("middlename"));
        user.setLastname(resultSet.getString("lastname"));
        user.setAge(resultSet.getInt("age"));
        user.setEmail(resultSet.getString("email"));
        return user;
    }
}
