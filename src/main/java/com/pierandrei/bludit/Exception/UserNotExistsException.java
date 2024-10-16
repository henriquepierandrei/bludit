package com.pierandrei.bludit.Exception;

public class UserNotExistsException extends RuntimeException{
    public UserNotExistsException(){
        super("User not found.");
    }
}
