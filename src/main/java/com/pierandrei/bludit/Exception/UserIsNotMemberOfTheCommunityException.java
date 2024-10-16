package com.pierandrei.bludit.Exception;

public class UserIsNotMemberOfTheCommunityException extends RuntimeException{
    public UserIsNotMemberOfTheCommunityException(){
        super("You isn't a member!");
    }
}
