package com.uzairproject.librarymanagement.exceptions;

public class AuthorNotFoundException extends RuntimeException{
    public AuthorNotFoundException(String msg){
        super(msg);
    }

    public AuthorNotFoundException(Throwable cause){
        super(cause);
    }
}
