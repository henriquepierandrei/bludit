package com.pierandrei.bludit.Exception;

public class CommunityNotExistsException extends RuntimeException{
    public CommunityNotExistsException(){
        super("Community not found!");
    }
}
