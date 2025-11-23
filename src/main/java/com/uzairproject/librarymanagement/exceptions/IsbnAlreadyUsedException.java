package com.uzairproject.librarymanagement.exceptions;

public class IsbnAlreadyUsedException extends RuntimeException{
    public IsbnAlreadyUsedException(String msg){
        super(msg);
    }

    public IsbnAlreadyUsedException(Throwable cause){
        super(cause);
    }
}
