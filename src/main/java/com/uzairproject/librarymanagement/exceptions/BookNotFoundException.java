package com.uzairproject.librarymanagement.exceptions;

public class BookNotFoundException extends RuntimeException{
    public BookNotFoundException(String msg){
        super(msg);
    }

    public BookNotFoundException(Throwable cause){
        super(cause);
    }
}
