package com.pierandrei.bludit.Exception;

public class PhoneAlreadyExistsException extends RuntimeException {
    public PhoneAlreadyExistsException(){
        super("Phone already exists.");

    }

}
