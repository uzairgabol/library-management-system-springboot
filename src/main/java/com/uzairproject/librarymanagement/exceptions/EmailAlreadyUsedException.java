package com.uzairproject.librarymanagement.exceptions;

public class EmailAlreadyUsedException extends RuntimeException{
    public EmailAlreadyUsedException(String msg){
        super(msg);
    }

    public EmailAlreadyUsedException(Throwable cause){
        super(cause);
    }
}