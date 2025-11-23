package com.uzairproject.librarymanagement.services.serviceimpl;

import com.uzairproject.librarymanagement.dtos.BookRequestDto;
import com.uzairproject.librarymanagement.dtos.BookResponseDto;
import com.uzairproject.librarymanagement.models.Author;
import com.uzairproject.librarymanagement.models.Book;
import com.uzairproject.librarymanagement.repositories.AuthorRepo;
import com.uzairproject.librarymanagement.repositories.BookRepo;
import com.uzairproject.librarymanagement.services.BookService;
import com.uzairproject.librarymanagement.utils.EntityMappers;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepo bookRepo;
    private final EntityMappers entityMappers;
    private final AuthorRepo authorRepo;

    public BookServiceImpl(BookRepo bookRepo, EntityMappers entityMappers, AuthorRepo authorRepo){
        this.bookRepo = bookRepo;
        this.entityMappers = entityMappers;
        this.authorRepo = authorRepo;
    }

    @Override
    public BookResponseDto createBook(BookRequestDto bookRequestDto) {
        Author author = authorRepo.findById(bookRequestDto.authorId()).orElseThrow(() -> new RuntimeException("Author not found with id: " + bookRequestDto.authorId()));
        return entityMappers.convertBookEntityToBookDto(bookRepo.save(entityMappers.convertBookDtoToBookEntity(bookRequestDto, author)));
    }

    @Override
    public List<BookResponseDto> getAllBooks() {
        List<Book> books = bookRepo.findAll();
        return books.stream().map(book -> entityMappers.convertBookEntityToBookDto(book)).collect(Collectors.toList());
    }

    @Override
    public BookResponseDto getBookById(Long bookId) {
        return entityMappers.convertBookEntityToBookDto(bookRepo.findById(bookId).orElseThrow(() -> new RuntimeException("Book with id not found: " + bookId)));
    }

    @Override
    public BookResponseDto updateBookById(Long bookId, BookRequestDto bookRequestDto) {
        Author author = authorRepo.findById(bookRequestDto.authorId()).orElseThrow(() -> new RuntimeException("Author not found with id: " + bookRequestDto.authorId()));
        Book existingBook = bookRepo.findById(bookId).orElseThrow(() -> new RuntimeException("Book with id not found: " + bookId));
        existingBook.setAuthor(author);
        existingBook.setTitle(bookRequestDto.title());
        existingBook.setIsbn(bookRequestDto.isbn());
        return entityMappers.convertBookEntityToBookDto(bookRepo.save(existingBook));
    }

    @Override
    public void removeBookById(Long bookId) {
        Book existingBook = bookRepo.findById(bookId).orElseThrow(() -> new RuntimeException("Book with id not found: " + bookId));
        bookRepo.delete(existingBook);
    }
}
