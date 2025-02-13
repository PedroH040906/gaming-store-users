package com.gaming.store.gaming_store_users.service;

import com.gaming.store.gaming_store_users.model.Users;
import com.gaming.store.gaming_store_users.repository.UsersRepository;
import com.gaming.store.gaming_store_users.utils.EntityToDtoMapper;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

    private final UsersRepository usersRepository;

    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public UsersResponseDTO createUser (UsersDTO userDTO) {
        if (usersRepository.existsById(userDTO.getEmail())) {
            throw new RuntimeException("E-mail já cadastrado.");
        }

        Users userToBeCreated = EntityToDtoMapper.mapUserDtoToUser (userDTO);
        Users savedUser  = usersRepository.save(userToBeCreated);

        return new UsersResponseDTO(savedUser );
    }
}