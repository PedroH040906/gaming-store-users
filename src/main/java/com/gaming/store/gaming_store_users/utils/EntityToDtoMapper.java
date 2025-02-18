package com.gaming.store.gaming_store_users.utils;

import com.gaming.store.gaming_store_users.model.Users;
import com.gaming.store.gaming_store_users.service.UsersDTO;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;

public class EntityToDtoMapper {

    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    // Converte Users para UsersDTO
    public static UsersDTO mapUserToUserDto(Users users) {
        return new UsersDTO(users.getEmail(), users.getName(), users.getAdress(), users.getCountryCode(), users.getPassword(), users.getUpdatedAt(), users.getCreatedAt(), users.getLastLogin());
    }

    // Converte UsersDTO para Users (Novo Usuário)
    public static Users mapUserDtoToUser(UsersDTO usersDTO) {
        Users users = new Users();
        users.setEmail(usersDTO.getEmail());
        users.setName(usersDTO.getName());
        users.setAdress(usersDTO.getAdress());
        users.setCountryCode(usersDTO.getCountryCode());
        users.setPassword(passwordEncoder.encode(usersDTO.getPassword()));
        users.setUpdatedAt(LocalDateTime.now());
        users.setCreatedAt(LocalDateTime.now()); // ✅ Correção aqui

        // Garante que lastLogin seja null na criação do usuário
        users.setLastLogin(null);
        return users;
    }
}
