package com.uzairproject.librarymanagement.dtos;

import java.time.Instant;

public record AuthorResponseDto(Long id, String name, String email, String bio, Instant createdAt, Instant updatedAt) {
}
