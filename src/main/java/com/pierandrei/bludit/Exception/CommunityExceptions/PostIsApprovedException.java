package com.pierandrei.bludit.Exception.CommunityExceptions;

public class PostIsApprovedException extends RuntimeException{
    public PostIsApprovedException(){
        super("Post is already activated!");
    }
}
