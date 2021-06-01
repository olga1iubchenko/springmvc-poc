package com.poc.springproject.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
public class UserAlreadyExistsException extends Exception {

    HttpStatus httpStatus;

    @Builder
    public UserAlreadyExistsException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }
}
