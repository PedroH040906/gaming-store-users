package com.gaming.store.gaming_store_users.controller;

import com.gaming.store.gaming_store_users.service.UsersDTO;
import com.gaming.store.gaming_store_users.service.UsersService;
import com.gaming.store.gaming_store_users.utils.ErrorMapper;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequestMapping("/users")
public class UsersController {

    private final UsersService usersService;

    private final ErrorMapper errorMapper;

    public UsersController(UsersService usersService, ErrorMapper errorMapper) {
        this.usersService = usersService;
        this.errorMapper = errorMapper;
    }

    @PostMapping
    ResponseEntity createUser(
            @Valid
            @RequestBody UsersDTO userDto) {
        try {
            return new ResponseEntity<>(this.usersService.createUser(userDto), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(this.errorMapper.createErrorMap(e), HttpStatus.BAD_REQUEST);
        }
    }
}
