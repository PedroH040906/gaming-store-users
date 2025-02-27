package com.gaming.store.gaming_store_users.service;

import com.gaming.store.gaming_store_users.model.Users;
import com.gaming.store.gaming_store_users.repository.UsersRepository;
import com.gaming.store.gaming_store_users.utils.EntityToDtoMapper;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsersService {

    private final UsersRepository usersRepository;

    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public UsersResponseDTO createUser(UsersDTO userDTO) {
        if (usersRepository.existsById(userDTO.getEmail())) {
            throw new RuntimeException("E-mail já cadastrado.");
        }

        Users userToBeCreated = EntityToDtoMapper.mapUserDtoToUser(userDTO);
        Users savedUser = usersRepository.save(userToBeCreated);

        return new UsersResponseDTO(savedUser);
    }

    public UsersResponseDTO updateUserInfo(UsersDTO userDTO) {
        Optional<Users> optionalUser = usersRepository.findById(userDTO.getEmail());

        if (optionalUser.isPresent()) {
            Users user = optionalUser.get();

            if (userDTO.getName() != null && !userDTO.getName().isBlank()) {
                user.setName(userDTO.getName());
            }

            if (userDTO.getAdress() != null && !userDTO.getAdress().isBlank()) {
                user.setAdress(userDTO.getAdress());
            }

            if (userDTO.getCountryCode() != null && !userDTO.getCountryCode().isBlank()) {
                user.setCountryCode(userDTO.getCountryCode());
            }

            Users updatedUser = usersRepository.save(user);
            return new UsersResponseDTO(updatedUser);
        }

        throw new RuntimeException("E-mail não encontrado.");
    }



}