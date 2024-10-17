package com.pierandrei.bludit.Exception.UserException;

public class UsernameAlreadyExistsException extends RuntimeException {
    public UsernameAlreadyExistsException(){
        super("Username already exists.");
    }
}
