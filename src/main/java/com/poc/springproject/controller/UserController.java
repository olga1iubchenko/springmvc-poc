package com.poc.springproject.controller;

import com.poc.springproject.dao.UserDao;
import com.poc.springproject.dto.UserDto;
import com.poc.springproject.service.UserService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "users")
public class UserController {


    UserDao userDao;

    @Autowired
    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    @GetMapping(value = "all")
    public ResponseEntity getUsers() {
        try {
            return ResponseEntity.ok(String.format("Response is successful. List of users %s", userDao.getAllUsers()));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Can't retrieve the list of users");
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity getUserById(@PathVariable int id) {
        try {
            return ResponseEntity.ok(
                    String.format("User found. User details: %s", userDao.getUserById(id)));
        } catch (Exception e) {
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping(value = "/user")
    public ResponseEntity getUserByIdParam(@RequestParam(value = "userId", defaultValue = "1") int id, @RequestParam(required = false, defaultValue = "test@test.com") String email) {
        try {
            return ResponseEntity.ok(String.format("User found. User details: %s", userDao.getUserById(id,email)));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    @SneakyThrows
    public ResponseEntity createUser(@RequestBody @Validated UserDto userDto) {
        try {
            return ResponseEntity.ok("User successfully created. Such number of rows " + userDao.saveNewUserToUserDb(userDto) + " added");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }

    @PutMapping(value = "/user/{id}")
    public ResponseEntity updateUserData(@RequestBody UserDto userDto, @PathVariable int id) {
        try {
            return ResponseEntity.ok("User successfully updated. Such number of rows " + userDao.updateUser(userDto, id) + " added");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity deleteUser(@PathVariable int id) {
        try {
            return ResponseEntity.ok(String.format("%d user(s) has been deleted", userDao.delete(id)));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("User can't be deleted");
        }
    }
}
