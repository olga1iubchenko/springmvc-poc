package com.poc.springproject.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonFormat
public class UserDto {
    @NotBlank(message = "User's name can't be empty")
    @Size(min = 3, max = 24, message = "Name field must contain between 3 and 24 characters")
    String name;
    String middleName;
    @NotBlank(message = "User's last name can't be empty")
    String lastname;
    @Positive
    int age;
    @Email(message = "Email should be valid")
    String email;

    @Override
    public String toString() {
        return "User information:" +
                "name='" + name + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastname='" + lastname + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }
}
