package com.gaming.store.gaming_store_users.service;

import com.gaming.store.gaming_store_users.model.Users;

import java.time.LocalDateTime;

public record UsersResponseDTO(String email, String name, String adress, String country_code, LocalDateTime created_at,LocalDateTime updated_at) {

    public UsersResponseDTO(Users users){
        this(users.getEmail(), users.getName(), users.getAdress(), users.getCountry_code(), users.getUpdated_at(),users.getCreated_at());
    }
}
