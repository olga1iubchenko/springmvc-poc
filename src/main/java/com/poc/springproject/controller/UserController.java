package com.poc.springproject.controller;

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

    @Autowired
    UserService userService;


    @GetMapping(value = "all")
    public ResponseEntity getUsers() {
        try {
            return ResponseEntity.ok("Response is successful");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Bad Request for list of users");
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity getUserById(@PathVariable int id) {
        try {
            return ResponseEntity.ok(String.format("User with id %d found. User's name: %s and lastname: %s", id, UserService.getUserById(id).getName(), UserService.getUserById(id).getLastname()));
        } catch (Exception e) {
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping(value = "/user")
    public ResponseEntity getUserByIdParam(@RequestParam(value = "userId", defaultValue = "1") int id, @RequestParam(required = false, defaultValue = "test@test.com") String email) {
        try {
            return ResponseEntity.ok(String.format("User with id %d found. User's name: %s and lastname: %s and email: %s", id, UserService.getUserById(id).getName(), UserService.getUserById(id).getLastname(), email));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    @SneakyThrows
    public ResponseEntity createUser(@RequestBody @Validated UserDto userDto) {
        try {
            UserService.createNewUser(userDto);
            return ResponseEntity.ok(UserService.getNewCreatedUserDataString());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }

    @PutMapping(value = "/user/{id}")
    public ResponseEntity updateUserData(@RequestBody @Validated UserDto userDto, @PathVariable int id) {
        try {
            return ResponseEntity.ok(String.format("User with id: %d had been successfully updated. %s", id, UserService.updateUser(id, userDto).toString()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity deleteUser(@PathVariable int id) {
        try {
            UserService.deleteUser(id);
            return ResponseEntity.ok(String.format("User with id = %d has been deleted", id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("User can't be deleted");
        }
    }
}
