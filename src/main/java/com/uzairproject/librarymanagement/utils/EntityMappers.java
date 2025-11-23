package com.uzairproject.librarymanagement.utils;

import com.uzairproject.librarymanagement.dtos.AuthorRequestDto;
import com.uzairproject.librarymanagement.dtos.AuthorResponseDto;
import com.uzairproject.librarymanagement.dtos.BookRequestDto;
import com.uzairproject.librarymanagement.dtos.BookResponseDto;
import com.uzairproject.librarymanagement.models.Author;
import com.uzairproject.librarymanagement.models.Book;
import org.springframework.stereotype.Component;

@Component
public class EntityMappers {

    public Author convertAuthorDtoToAuthorEntity(AuthorRequestDto dto) {
        Author entity = new Author();
        entity.setName(dto.name());
        entity.setEmail(dto.email());
        entity.setBio(dto.bio());
        return entity;
    }

    public AuthorResponseDto convertAuthorEntityToAuthorDto(Author author){
        return new AuthorResponseDto(author.getId(), author.getName(), author.getEmail(), author.getBio(), author.getCreatedAt(), author.getUpdatedAt());
    }

    public Book convertBookDtoToBookEntity(BookRequestDto bookRequestDto, Author author){
        Book book = new Book();
        book.setTitle(bookRequestDto.title());
        book.setIsbn(bookRequestDto.isbn());
        book.setAuthor(author);
        return book;
    }

    public BookResponseDto convertBookEntityToBookDto(Book book){
        AuthorResponseDto authorResponseDto = convertAuthorEntityToAuthorDto(book.getAuthor());
        return new BookResponseDto(book.getId(), book.getTitle(), book.getIsbn(), authorResponseDto, book.getCreatedAt(), book.getUpdatedAt());
    }
}
