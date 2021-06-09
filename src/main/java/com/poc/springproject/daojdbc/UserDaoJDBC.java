package com.poc.springproject.daojdbc;

import com.poc.springproject.dto.UserDto;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDaoJDBC extends Dao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDaoJDBC(JdbcTemplate jdbcTemplate) {
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
                 user.getName(), user.getMiddleName(), user.getLastname(), user.getAge(), user.getEmail());
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
