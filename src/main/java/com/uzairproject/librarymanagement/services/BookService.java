package com.uzairproject.librarymanagement.services;

import com.uzairproject.librarymanagement.dtos.BookRequestDto;
import com.uzairproject.librarymanagement.dtos.BookResponseDto;

import java.util.List;

public interface BookService {
    public BookResponseDto createBook(BookRequestDto bookRequestDto);
    public List<BookResponseDto> getAllBooks();
    public BookResponseDto getBookById(Long bookId);
    public BookResponseDto updateBookById(Long bookId, BookRequestDto bookRequestDto);
    public void removeBookById(Long bookId);
}
