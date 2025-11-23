package com.uzairproject.librarymanagement.services.serviceimpl;

import com.uzairproject.librarymanagement.dtos.AuthorRequestDto;
import com.uzairproject.librarymanagement.dtos.AuthorResponseDto;
import com.uzairproject.librarymanagement.dtos.BookResponseDto;
import com.uzairproject.librarymanagement.exceptions.AuthorHasBooksException;
import com.uzairproject.librarymanagement.exceptions.AuthorNotFoundException;
import com.uzairproject.librarymanagement.exceptions.EmailAlreadyUsedException;
import com.uzairproject.librarymanagement.models.Author;
import com.uzairproject.librarymanagement.models.Book;
import com.uzairproject.librarymanagement.repositories.AuthorRepo;
import com.uzairproject.librarymanagement.repositories.BookRepo;
import com.uzairproject.librarymanagement.services.AuthorService;
import com.uzairproject.librarymanagement.utils.EntityMappers;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepo authorRepo;
    private final EntityMappers entityMappers;
    private final BookRepo bookRepo;

    public AuthorServiceImpl(AuthorRepo authorRepo, EntityMappers entityMappers, BookRepo bookRepo){
        this.authorRepo = authorRepo;
        this.entityMappers = entityMappers;
        this.bookRepo = bookRepo;
    }

    @Override
    public AuthorResponseDto createAuthor(AuthorRequestDto authorDto){
        Author existingAuthor = authorRepo.findByEmail(authorDto.email());
        if (existingAuthor != null){
            throw new EmailAlreadyUsedException("Email is already in use by another author");
        }
        Author author = entityMappers.convertAuthorDtoToAuthorEntity(authorDto);
        Author savedAuthor = authorRepo.save(author);
        return entityMappers.convertAuthorEntityToAuthorDto(savedAuthor);
    }

    @Override
    public List<AuthorResponseDto> getAllAuthors() {
        List<Author> authors = authorRepo.findAll();
        return authors.stream().map(author -> entityMappers.convertAuthorEntityToAuthorDto(author)).collect(Collectors.toList());
    }


    @Override
    public AuthorResponseDto getAuthorById(Long authorId) {
        Author author = authorRepo.findById(authorId).orElseThrow(() -> new AuthorNotFoundException("Author Not found: " + authorId));
        return entityMappers.convertAuthorEntityToAuthorDto(author);
    }

    @Override
    public AuthorResponseDto updateAuthorInfo(Long authorId, AuthorRequestDto authorDto) {
        Author existingAuthor = authorRepo.findById(authorId).orElseThrow(() -> new AuthorNotFoundException("Author Not found: " + authorId));
        Author updatedAuthor = entityMappers.convertAuthorDtoToAuthorEntity(authorDto);
        existingAuthor.setName(updatedAuthor.getName());
        existingAuthor.setEmail(updatedAuthor.getEmail());
        existingAuthor.setBio(updatedAuthor.getBio());
        authorRepo.save(existingAuthor);
        return entityMappers.convertAuthorEntityToAuthorDto(existingAuthor);
    }

    @Override
    public void deleteAuthor(Long authorId) {
        List<Book> books = bookRepo.findByAuthorId(authorId);
        if (books.isEmpty()){
            Author author = authorRepo.findById(authorId).orElseThrow(() -> new AuthorNotFoundException("Author Not found: " + authorId));
            authorRepo.delete(author);
        }
        else {
            throw new AuthorHasBooksException("Before deleting author remove their books.");
        }
    }

    @Override
    public List<BookResponseDto> getBooksByAuthor(Long authorId){
        List<Book> books = bookRepo.findByAuthorId(authorId);
        return books.stream().map(book -> entityMappers.convertBookEntityToBookDto(book)).collect(Collectors.toList());
    }
}
