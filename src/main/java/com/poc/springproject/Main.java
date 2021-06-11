package com.poc.springproject;

import com.poc.springproject.config.SpringConfig;
import com.poc.springproject.entity.UserEntity;
import com.poc.springproject.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(SpringConfig.class);

        UserService userService = context.getBean(UserService.class);

        // Add Users
//        userService.add(new User("Sunil", "jr", "Bora", 29, "suni.bora@example.com"));
//        userService.add(new User("David", "RJ", "Miller", 30, "david.miller@example.com"));
//        userService.add(new User("Sameer", "", "Singh", 45, "sameer.singh@example.com"));
//        userService.add(new User("Paul", "Helen", "Smith", 53, "paul.smith@example.com"));

        // Get Users


        System.out.println(userService.getUserById(3).toString());

       // userService.updateUser(new UserEntity("Paul", "Helen", "Smith", 53, "paul.smith@example.com"), 2);
        userService.deleteUser(6);

        List<UserEntity> userEntities = userService.listUsers();
        for (UserEntity userEntity : userEntities) {
            System.out.println("Id = " + userEntity.getId());
            System.out.println("First Name = " + userEntity.getName());
            System.out.println("Last Name = " + userEntity.getLastname());
            System.out.println("Email = " + userEntity.getEmail());
            System.out.println();
        }

        context.close();
    }
}

