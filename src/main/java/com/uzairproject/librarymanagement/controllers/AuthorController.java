package com.uzairproject.librarymanagement.controllers;

import com.uzairproject.librarymanagement.models.Author;
import com.uzairproject.librarymanagement.services.AuthorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {

    private AuthorService authorService;

    @PostMapping("/create")
    public ResponseEntity<Author> createAuthor(@RequestBody Author newAuthor){
        return ResponseEntity.ok(
                authorService.createAuthor(newAuthor)
        );
    }

    @GetMapping()
    public ResponseEntity<List<Author>> getAuthors(){
        List<Author> authors = authorService.getAllAuthors();
        return ResponseEntity.ok(authors);
    }
}
