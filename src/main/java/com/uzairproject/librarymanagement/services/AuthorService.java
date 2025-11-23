package com.uzairproject.librarymanagement.services;

import com.uzairproject.librarymanagement.dtos.AuthorRequestDto;
import com.uzairproject.librarymanagement.dtos.AuthorResponseDto;
import com.uzairproject.librarymanagement.dtos.BookResponseDto;

import java.util.List;

public interface AuthorService{
    AuthorResponseDto createAuthor(AuthorRequestDto authorDto);
    List<AuthorResponseDto> getAllAuthors();
    AuthorResponseDto getAuthorById(Long authorId);
    AuthorResponseDto updateAuthorInfo(Long authorId, AuthorRequestDto author);
    void deleteAuthor(Long authorId);
    List<BookResponseDto> getBooksByAuthor(Long authorId);
}
