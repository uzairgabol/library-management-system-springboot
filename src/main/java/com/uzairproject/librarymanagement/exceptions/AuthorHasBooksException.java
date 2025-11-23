package com.uzairproject.librarymanagement.exceptions;

public class AuthorHasBooksException extends RuntimeException{
    public AuthorHasBooksException(String msg){
        super(msg);
    }

    public AuthorHasBooksException(Throwable cause){
        super(cause);
    }
}
