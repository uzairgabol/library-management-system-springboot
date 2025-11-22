package com.uzairproject.librarymanagement.services.serviceimpl;

import com.uzairproject.librarymanagement.models.Author;
import com.uzairproject.librarymanagement.repositories.AuthorRepo;
import com.uzairproject.librarymanagement.services.AuthorService;

import java.util.List;

public class AuthorServiceImpl implements AuthorService {

    private AuthorRepo authorRepo;

    @Override
    public Author createAuthor(Author author){
        return authorRepo.save(author);
    }

    @Override
    public List<Author> getAllAuthors() {
        return authorRepo.findAll();
    }

    @Override
    public Author getAuthorById(Long authorId) {
        return authorRepo.findById(authorId).orElseThrow(() -> new RuntimeException("Author Not found: " + authorId));
    }

    @Override
    public Author updateAuthorInfo(Long authorId, Author author) {
        Author updatedAuthor = authorRepo.findById(authorId).orElseThrow(() -> new RuntimeException("Author Not found: " + authorId));
        updatedAuthor = author;
        return authorRepo.save(updatedAuthor);
    }

    @Override
    public void deleteAuthor(Long authorId) {
        Author author = authorRepo.findById(authorId).orElseThrow(() -> new RuntimeException("Author Not found: " + authorId));
        authorRepo.delete(author);
    }
}
