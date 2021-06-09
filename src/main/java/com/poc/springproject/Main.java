package com.poc.springproject;

import com.google.gson.Gson;
import com.poc.springproject.config.SpringConfig;
import com.poc.springproject.dto.UserDto;
import com.poc.springproject.entity.User;
import com.poc.springproject.service.UserService;
import com.poc.springproject.service.UserServiceImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(SpringConfig.class);

        UserService userService = context.getBean(UserService.class);

        // Add Users
        userService.add(new User("Sunil", "jr", "Bora", 29, "suni.bora@example.com"));
        userService.add(new User("David", "RJ", "Miller", 30, "david.miller@example.com"));
        userService.add(new User("Sameer", "", "Singh", 45, "sameer.singh@example.com"));
        userService.add(new User("Paul", "Helen", "Smith", 53, "paul.smith@example.com"));

        // Get Users
        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getName());
            System.out.println("Last Name = " + user.getLastname());
            System.out.println("Email = " + user.getEmail());
            System.out.println();
        }

        context.close();
    }
}

