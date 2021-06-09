package com.poc.springproject.service;

import com.poc.springproject.dao.UserDao;
import com.poc.springproject.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Transactional
    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> listUsers() {
        return userDao.listUsers();
    }

    @Transactional
    @Override
    public User getUserById(long id) {
        return userDao.getUserById(id);
    }

    @Transactional
    @Override
    public int deleteUser(long id) {
        return userDao.deleteUser(id);
    }

    @Transactional
    @Override
    public int updateUser(User user, long id) {
        return userDao.updateUser(user, id);
    }

}
