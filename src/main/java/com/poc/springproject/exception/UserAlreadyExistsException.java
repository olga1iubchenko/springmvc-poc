package com.poc.springproject.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@Setter
@AllArgsConstructor
@ResponseStatus (value = HttpStatus.CONFLICT, reason = "Such user is already exists")
public class UserAlreadyExistsException extends Exception {

    HttpStatus httpStatus;

    @Builder
    public UserAlreadyExistsException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }
}
