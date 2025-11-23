package com.uzairproject.librarymanagement.repositories;

import com.uzairproject.librarymanagement.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepo extends JpaRepository<Book, Long> {
    List<Book> findByAuthorId(Long authorId);
    Book findByIsbn(String isbn);
}
