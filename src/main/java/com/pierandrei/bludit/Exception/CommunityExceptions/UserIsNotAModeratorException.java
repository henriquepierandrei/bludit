package com.pierandrei.bludit.Exception.CommunityExceptions;

public class UserIsNotAModeratorException extends RuntimeException{
    public UserIsNotAModeratorException(){
        super("User is not a moderator!");
    }
}
