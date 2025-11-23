package com.uzairproject.librarymanagement.controllers;

import com.uzairproject.librarymanagement.dtos.AuthorRequestDto;
import com.uzairproject.librarymanagement.dtos.AuthorResponseDto;
import com.uzairproject.librarymanagement.dtos.BookResponseDto;
import com.uzairproject.librarymanagement.services.AuthorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService){
        this.authorService = authorService;
    }

    @PostMapping("/create")
    public ResponseEntity<AuthorResponseDto> createAuthor(@RequestBody AuthorRequestDto newAuthor){
        System.out.println(newAuthor);
        return ResponseEntity.ok(
                authorService.createAuthor(newAuthor)
        );
    }

    @GetMapping("/")
    public ResponseEntity<List<AuthorResponseDto>> getAuthors(){
        List<AuthorResponseDto> authors = authorService.getAllAuthors();
        return ResponseEntity.ok(authors);
    }

    @GetMapping("/{authorId}")
    public ResponseEntity<AuthorResponseDto> getAuthorById(@PathVariable Long authorId){
        return ResponseEntity.ok(
                authorService.getAuthorById(authorId)
        );
    }

    @PutMapping("/update/{authorId}")
    public ResponseEntity<AuthorResponseDto> updateAuthor(@PathVariable Long authorId, @RequestBody AuthorRequestDto author){
        return ResponseEntity.ok(
                authorService.updateAuthorInfo(authorId, author)
        );
    }

    @DeleteMapping("/delete/{authorId}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable Long authorId){
        authorService.deleteAuthor(authorId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/getbooks/{authorId}")
    public ResponseEntity<List<BookResponseDto>> getBooksByAuthor(@PathVariable Long authorId){
        return ResponseEntity.ok(authorService.getBooksByAuthor(authorId));
    }
}
