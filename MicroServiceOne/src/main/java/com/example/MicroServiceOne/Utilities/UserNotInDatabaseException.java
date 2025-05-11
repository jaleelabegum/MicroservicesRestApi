package com.example.MicroServiceOne.Utilities;

public class UserNotInDatabaseException extends Exception{

    public UserNotInDatabaseException(String message){
        super(message);
    }
}
