package com.pierandrei.bludit.Exception;

public class UserIsMemberOfTheCommunityException extends RuntimeException{
    public UserIsMemberOfTheCommunityException(){
        super("You are already a member of the community!");
    }
}
