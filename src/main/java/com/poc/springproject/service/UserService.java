package com.poc.springproject.service;

import com.poc.springproject.entity.User;

import java.util.List;

public interface UserService {
        void add(User user);
        List<User> listUsers();
        User getUserById(long id);
        int deleteUser(long id);
        int updateUser(User user, long id);

}
