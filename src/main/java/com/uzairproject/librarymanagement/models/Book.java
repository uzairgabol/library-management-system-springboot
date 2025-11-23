package com.uzairproject.librarymanagement.models;

import jakarta.persistence.*;

@Entity
@Table(name = "book")
public class Book extends BaseEntity{

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, unique = true)
    private String isbn;

    @ManyToOne
    @JoinColumn(name = "authorId", nullable = false, referencedColumnName = "id")
    private Author author;

    public String getTitle() {
        return title;
    }

    public String getIsbn() {
        return isbn;
    }

    public Author getAuthor() {
        return author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
