package com.poc.springproject.service;

import com.poc.springproject.entity.UserEntity;
import com.poc.springproject.exception.UserAlreadyExistsException;
import com.poc.springproject.repository.UserRepository;
import com.poc.springproject.repository.UserRepositoryCustom;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final UserRepositoryCustom userRepositoryCustom;

    public UserServiceImpl(UserRepository userRepository, UserRepositoryCustom userRepositoryCustom) {
        this.userRepository = userRepository;
        this.userRepositoryCustom = userRepositoryCustom;
    }

    @Override
    @SneakyThrows
    public UserEntity add(UserEntity userEntity)  {
            if (userRepository.findById(userEntity.getId()) != null) {
                throw new UserAlreadyExistsException("User with this id is already exists", HttpStatus.CONFLICT);
            }
            return userRepository.save(userEntity);
    }

    @Transactional(readOnly = true)
    @Override
    public List<UserEntity> listUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserEntity getUserById(long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public long deleteUser(long id) {
        userRepository.deleteById(id);
        return id;
    }

//    @Override
//    public void updateUser(UserEntity userEntity, long id) {
//        userRepositoryCustom.setUserInfoById(userEntity, id);
//    }

}
