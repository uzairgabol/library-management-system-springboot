package com.uzairproject.librarymanagement.models;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "author")
public class Author extends BaseEntity{

    public Author(){}

    public Author(String name, String email, String bio, Set<Book> books){
        this.name = name;
        this.email = email;
        this.bio = bio;
        this.books = books;
    }

    @Column(nullable = false)
    private String name;

    @Column(unique = true)
    private String email;

    private String bio;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Book> books;

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getBio() {
        return bio;
    }

    public Set<Book> getBooks() {
       return books;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }
}
