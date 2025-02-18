package com.gaming.store.gaming_store_users.service;

import com.gaming.store.gaming_store_users.model.Users;

import java.time.LocalDateTime;

public record UsersResponseDTO(String email, String name, String adress, String countryCode, LocalDateTime createdAt,
                               LocalDateTime updatedAt) {

    public UsersResponseDTO(Users users) {
        this(users.getEmail(), users.getName(), users.getAdress(), users.getCountryCode(),
                users.getCreatedAt(), users.getUpdatedAt());
    }

}
