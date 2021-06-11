package com.poc.springproject.service;

import com.poc.springproject.entity.UserEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
        UserEntity add(UserEntity userEntity);
        List<UserEntity> listUsers();
        UserEntity getUserById(long id);
        long deleteUser(long id);
      //  void updateUser(UserEntity userEntity, long id);

}
