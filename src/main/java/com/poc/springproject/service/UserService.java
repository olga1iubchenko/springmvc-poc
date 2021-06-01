package com.poc.springproject.service;

import com.poc.springproject.dto.UserDto;
import com.poc.springproject.exception.UserAlreadyExistsException;
import com.poc.springproject.exception.UserNotExistsException;
import com.poc.springproject.exception.UserNotUpdatedException;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class UserService {

    private static Map<Integer, UserDto> users = new HashMap<Integer, UserDto>();
    private static AtomicInteger id = new AtomicInteger(0);
    private static String newUser;

    @SneakyThrows
    public static Map<Integer, UserDto> createNewUser(UserDto user) {
        if (!isUserWithEmailExists(user.getEmail())) {
            int userId = id.incrementAndGet();
            users.put(userId, user);
            setNewUserDataToString(userId);
            return users;
        } else {
            throw new UserAlreadyExistsException(String.format("User with this email : %s is already exists", user.getEmail()), HttpStatus.CONFLICT);
        }
    }

    public static void setNewUserDataToString(int userId) {
        newUser = String.format("User with name: %s, lastname: %s and email: %s has been created. User id is: %d"
                , getUserById(userId).getName()
                , getUserById(userId).getLastname()
                , getUserById(userId).getEmail()
                , userId);
    }

    @SneakyThrows
    public static UserDto updateUser(int userId, UserDto user) {
        if (users.containsKey(userId)) {
            users.put(userId, user);
            return users.get(userId);
        } else {
            throw new UserNotUpdatedException("User can't be updated", HttpStatus.FORBIDDEN);
        }
    }


    public static String getNewCreatedUserDataString() {
        return newUser;
    }

    public static Boolean isUserWithEmailExists(String email) {
        return users.values().stream().filter(u -> u.getEmail().equalsIgnoreCase(email)).findFirst().isPresent();
    }

    public static Boolean isUserWithNameExists(String name) {
        return users.values().stream().filter(u -> u.getName().equalsIgnoreCase(name)).findFirst().isPresent();
    }

    @SneakyThrows
    public static UserDto getUserByEmail(String email) {
        if (isUserWithEmailExists(email)) {
            return users.get(users.values().stream().filter(u -> u.getEmail().equalsIgnoreCase(email)).findFirst().get());
        } else throw new UserNotExistsException(String.format("User with this email : %s doesn't exists", email));
    }

    @SneakyThrows
    public static UserDto getUserById(int id) {
        if (users.containsKey(id)) {
            return users.get(users.keySet().stream().filter(u -> u == id).findFirst().get());
        } else throw new UserNotExistsException(String.format("User with this id : %d doesn't exists", id));
    }

    @SneakyThrows
    public static UserDto getUserByName(String name) {
        if (isUserWithNameExists(name)) {
            return users.get(users.values().stream().filter(u -> u.getName().equalsIgnoreCase(name)).findFirst().get());
        } else throw new UserNotExistsException(String.format("User with this name : %s doesn't exists", name));
    }


    public static boolean deleteUser(int id) {
        if (users.keySet().stream().filter(u -> u == id).findFirst().isPresent()) {
            users.remove(id);
            return true;
        } else return false;
    }

}
