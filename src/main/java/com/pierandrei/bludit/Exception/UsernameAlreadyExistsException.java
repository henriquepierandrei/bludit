package com.pierandrei.bludit.Exception;

public class UsernameAlreadyExistsException extends RuntimeException {
    public UsernameAlreadyExistsException(){
        super("Username already exists.");
    }
}
