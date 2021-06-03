package com.poc.springproject.dao;

import com.poc.springproject.dao.Dao;
import com.poc.springproject.dao.UserRowMapper;
import com.poc.springproject.dto.UserDto;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.util.List;

@Component
public class UserDao extends Dao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @SneakyThrows
    public List<UserDto> getAllUsers() {
        return jdbcTemplate.query(getSelectAllFromTargetDb(), new BeanPropertyRowMapper<>(UserDto.class));
    }

    @SneakyThrows
    public UserDto getUserById(int userId) {
        return jdbcTemplate.query(getSelectUserById(), new Object[]{userId}, new BeanPropertyRowMapper<>(UserDto.class))
                .stream().findAny().orElse(null);
    }

    @SneakyThrows
    public UserDto getUserById(int userId, String email) {
        return jdbcTemplate.query(getSelectUserByIdAndEmail(), new Object[]{userId, email}, new BeanPropertyRowMapper<>(UserDto.class))
                .stream().findAny().orElse(null);
    }

    @SneakyThrows
    public Integer saveNewUserToUserDb(UserDto user) {
        return jdbcTemplate.update(insertNewUserToUserDb(),
                user.getId(), user.getName(), user.getMiddleName(), user.getLastname(), user.getAge(), user.getEmail());
    }

    @SneakyThrows
    public Integer updateUser(UserDto user, int userId) {
        return jdbcTemplate.update(updateUserInUserDb(),
                user.getName(), user.getMiddleName(), user.getLastname(), user.getAge(), user.getEmail(), userId);
    }

    public Integer delete(int id) {
        return jdbcTemplate.update(deleteUserFromUserDb(), id);
    }

}
