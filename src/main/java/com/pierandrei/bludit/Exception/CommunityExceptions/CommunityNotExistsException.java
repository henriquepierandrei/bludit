package com.pierandrei.bludit.Exception.CommunityExceptions;

public class CommunityNotExistsException extends RuntimeException{
    public CommunityNotExistsException(){
        super("Community not found!");
    }
}
