package com.uzairproject.librarymanagement.controllers;

import com.uzairproject.librarymanagement.dtos.BookRequestDto;
import com.uzairproject.librarymanagement.dtos.BookResponseDto;
import com.uzairproject.librarymanagement.services.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {
    private BookService bookService;

    public BookController(BookService bookService){
        this.bookService = bookService;
    }

    @PostMapping("/create")
    public ResponseEntity<BookResponseDto> createBook(@RequestBody BookRequestDto bookRequestDto){
        return ResponseEntity.ok(bookService.createBook(bookRequestDto));
    }

    @GetMapping("/")
    public ResponseEntity<List<BookResponseDto>> getAllBooks(){
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @GetMapping("/{bookId}")
    public ResponseEntity<BookResponseDto> getBookById(@PathVariable Long bookId){
        return ResponseEntity.ok(bookService.getBookById(bookId));
    }

    @PutMapping("/{bookId}")
    public ResponseEntity<BookResponseDto> updateBookById(@PathVariable Long bookId, @RequestBody BookRequestDto bookRequestDto){
        return ResponseEntity.ok(bookService.updateBookById(bookId, bookRequestDto));
    }

    @DeleteMapping("/{bookId}")
    public ResponseEntity<Void> deleteBookById(@PathVariable Long bookId){
        bookService.removeBookById(bookId);
        return ResponseEntity.noContent().build();
    }
}
