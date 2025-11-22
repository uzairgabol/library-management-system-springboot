package com.uzairproject.librarymanagement.services;

import com.uzairproject.librarymanagement.models.Author;
import com.uzairproject.librarymanagement.repositories.AuthorRepo;

import java.util.List;

public interface AuthorService{
    Author createAuthor(Author author);
    List<Author> getAllAuthors();
    Author getAuthorById(Long authorId);
    Author updateAuthorInfo(Long authorId, Author author);
    void deleteAuthor(Long authorId);
}
