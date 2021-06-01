package com.poc.springproject.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;


@AllArgsConstructor
public class UserNotExistsException extends Exception {
    @Builder
    public UserNotExistsException(String message) {
        super(message);
    }
}
