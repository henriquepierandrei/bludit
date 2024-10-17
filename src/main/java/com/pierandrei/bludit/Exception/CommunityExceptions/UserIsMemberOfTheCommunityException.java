package com.pierandrei.bludit.Exception.CommunityExceptions;

public class UserIsMemberOfTheCommunityException extends RuntimeException{
    public UserIsMemberOfTheCommunityException(){
        super("You are already a member of the community!");
    }


}
