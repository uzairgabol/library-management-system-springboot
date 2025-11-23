package com.uzairproject.librarymanagement.advice;

import com.uzairproject.librarymanagement.exceptions.*;
import com.uzairproject.librarymanagement.utils.ServiceResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = AuthorNotFoundException.class)
    public ResponseEntity<ServiceResponse> authorNotFoundException(AuthorNotFoundException ex){
        ServiceResponse resp = new ServiceResponse(HttpStatus.BAD_REQUEST, ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resp);
    }

    @ExceptionHandler(value = BookNotFoundException.class)
    public ResponseEntity<ServiceResponse> bookNotFoundException(BookNotFoundException ex){
        ServiceResponse resp = new ServiceResponse(HttpStatus.BAD_REQUEST, ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resp);
    }

    @ExceptionHandler(value = EmailAlreadyUsedException.class)
    public ResponseEntity<ServiceResponse> emailAlreadyUsedException(EmailAlreadyUsedException ex){
        ServiceResponse resp = new ServiceResponse(HttpStatus.BAD_REQUEST, ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resp);
    }

    @ExceptionHandler(value = IsbnAlreadyUsedException.class)
    public ResponseEntity<ServiceResponse> isbnAlreadyUsedException(IsbnAlreadyUsedException ex){
        ServiceResponse resp = new ServiceResponse(HttpStatus.BAD_REQUEST, ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resp);
    }


    @ExceptionHandler(value = AuthorHasBooksException.class)
    public ResponseEntity<ServiceResponse> authorHasBooksException(AuthorHasBooksException ex){
        ServiceResponse resp = new ServiceResponse(HttpStatus.BAD_REQUEST, ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resp);
    }
}
