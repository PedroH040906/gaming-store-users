package com.gaming.store.gaming_store_users.service;

import com.gaming.store.gaming_store_users.model.Users;
import com.gaming.store.gaming_store_users.repository.UsersRepository;
import com.gaming.store.gaming_store_users.utils.EntityToDtoMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UsersServiceTest {

    @Mock
    private UsersRepository usersRepository;

    @InjectMocks
    private UsersService usersService;

    private UsersDTO usersDTO;
    private Users users;

    @BeforeEach
    void setUp() {
        usersDTO = new UsersDTO(
                "test@example.com",
                "John Doe",
                "123 Main St",
                "US",
                "StrongP@ss1",
                LocalDateTime.now(),
                LocalDateTime.now(),
                null
        );

        users = EntityToDtoMapper.mapUserDtoToUser(usersDTO);
    }

    @Test
    void createUser_Success() {
        when(usersRepository.existsById(usersDTO.getEmail())).thenReturn(false);
        when(usersRepository.save(any(Users.class))).thenReturn(users);

        UsersResponseDTO responseDTO = usersService.createUser(usersDTO);

        assertNotNull(responseDTO);
        assertEquals(usersDTO.getEmail(), responseDTO.email());
        verify(usersRepository, times(1)).save(any(Users.class));
    }

    @Test
    void createUser_ShouldThrowException_WhenEmailAlreadyExists() {
        when(usersRepository.existsById(usersDTO.getEmail())).thenReturn(true);

        RuntimeException exception = assertThrows(RuntimeException.class, () -> usersService.createUser(usersDTO));

        assertEquals("E-mail já cadastrado.", exception.getMessage());
        verify(usersRepository, never()).save(any(Users.class));
    }
}