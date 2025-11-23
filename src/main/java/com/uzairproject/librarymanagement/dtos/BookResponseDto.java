package com.uzairproject.librarymanagement.dtos;

import java.time.Instant;

public record BookResponseDto(Long id, String title, String isbn, AuthorResponseDto author, Instant createdAt, Instant updatedAt) {
}
