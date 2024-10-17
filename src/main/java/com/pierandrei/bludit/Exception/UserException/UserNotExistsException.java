package com.pierandrei.bludit.Exception.UserException;

public class UserNotExistsException extends RuntimeException{
    public UserNotExistsException(){
        super("User not found.");
    }
}
