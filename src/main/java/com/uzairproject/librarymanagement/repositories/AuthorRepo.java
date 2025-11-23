package com.uzairproject.librarymanagement.repositories;

import com.uzairproject.librarymanagement.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepo extends JpaRepository<Author, Long> {
    Author findByEmail(String email);
}
