package com.poc.springproject.controller;

import com.poc.springproject.entity.UserEntity;
import com.poc.springproject.service.UserService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;


@RestController
@RequestMapping(path = "users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "all")
    public ResponseEntity getUsers() {
        try {
            return ResponseEntity.ok(String.format("Response is successful. List of users %s", userService.listUsers().stream().map(u -> u.toString()).collect(Collectors.joining())));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Can't retrieve the list of users");
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity getUserById(@PathVariable long id) {
        try {
            return ResponseEntity.ok(
                    String.format("User found. User details: %s", userService.getUserById(id).toString()));
        } catch (Exception e) {
            return ResponseEntity.noContent().build();
        }
    }

//    @GetMapping(value = "/user")
//    public ResponseEntity getUserByIdParam(@RequestParam(value = "userId", defaultValue = "1") int id, @RequestParam(required = false, defaultValue = "test@test.com") String email) {
//        try {
//            return ResponseEntity.ok(String.format("User found. User details: %s", userService.getUserById(id,email)));
//        } catch (Exception e) {
//            return ResponseEntity.notFound().build();
//        }
//    }

    @PostMapping
    @SneakyThrows
    public ResponseEntity createUser(@RequestBody @Validated UserEntity userEntity) {
        try {
            userService.add(userEntity);
            return ResponseEntity.ok("User successfully created");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }

//    @PutMapping(value = "/user/{id}")
//    public ResponseEntity updateUserData(@RequestBody UserEntity userEntity, @PathVariable long id) {
//        try {
//            userService.updateUser(userEntity, id);
//            return ResponseEntity.ok("User successfully updated.");
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
//        }
//    }

    @DeleteMapping(value="/{id}")
   public ResponseEntity deleteUser(@PathVariable long id) {
        try {
            return ResponseEntity.ok(String.format("%d user(s) has been deleted", userService.deleteUser(id)));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("User can't be deleted");
        }
    }
}
