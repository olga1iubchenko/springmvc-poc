package com.poc.springproject.dao;

import com.poc.springproject.entity.User;

import java.util.List;

public interface UserDao {
    void add(User user);
    List<User> listUsers();
    User getUserById(long id);
    int deleteUser(long id);
    int updateUser(User user,long id);
}
