package com.uzairproject.librarymanagement.controllers;

import com.uzairproject.librarymanagement.models.Author;
import com.uzairproject.librarymanagement.services.AuthorService;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService){
        this.authorService = authorService;
    }

    @PostMapping("/create")
    public ResponseEntity<Author> createAuthor(@RequestBody Author newAuthor){
        return ResponseEntity.ok(
                authorService.createAuthor(newAuthor)
        );
    }

    @GetMapping("/")
    public ResponseEntity<List<Author>> getAuthors(){
        List<Author> authors = authorService.getAllAuthors();
        return ResponseEntity.ok(authors);
    }

    @GetMapping("/{authorId}")
    public ResponseEntity<Author> getAuthorById(@PathVariable Long authorId){
        return ResponseEntity.ok(
                authorService.getAuthorById(authorId)
        );
    }

    @PutMapping("/update/{authorId}")
    public ResponseEntity<Author> updateAuthor(@PathVariable Long authorId, @RequestBody Author author){
        return ResponseEntity.ok(
                authorService.updateAuthorInfo(authorId, author)
        );
    }

    @DeleteMapping("/delete/{authorId}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable Long authorId){
        authorService.deleteAuthor(authorId);
        return ResponseEntity.noContent().build();
    }
}
