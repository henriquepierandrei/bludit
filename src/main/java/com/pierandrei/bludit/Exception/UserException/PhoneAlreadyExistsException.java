package com.pierandrei.bludit.Exception.UserException;

public class PhoneAlreadyExistsException extends RuntimeException {
    public PhoneAlreadyExistsException(){
        super("Phone already exists.");

    }

}
