package com.poc.springproject.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {
    int id;
    String name;
    String middleName;
    String lastname;
    int age;
    String email;

    @Override
    public String toString() {
        return "User information:" +
                "id" + id + '\'' +
                "name='" + name + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastname='" + lastname + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }
}
