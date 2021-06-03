package com.poc.springproject;

import com.google.gson.Gson;
import com.poc.springproject.dto.UserDto;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Gson().toJson(new UserDto(1,"Jon", "Middlename", "Snow", 29, "jon@gmail.com")));
    }
}
