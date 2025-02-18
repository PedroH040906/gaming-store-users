package com.gaming.store.gaming_store_users.service;

import jakarta.validation.constraints.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Locale;

public class UsersDTO {

    @Email
    @NotBlank(message = "Email cannot be blank.")
    private String email;

    @NotBlank(message = "Name cannot be blank.")
    @Size(min = 5, message = "The name needs at least 5 characters")
    private String name;

    @Size(max = 80, message = "adress should be up to 80 characters")
    private String adress;

    @NotBlank(message = "Country code cannot be blank.")
    @Size(max = 2, min = 2)
    private String countryCode;

    @AssertTrue(message = "Invalid country code.")
    public boolean isValidCountryCode() {
        return Arrays.asList(Locale.getISOCountries()).contains(countryCode);
    }

    @NotBlank(message = "Password cannot be blank.")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$", message = "The password must be at least 8 characters long, including a lowercase letter, an uppercase letter, a number and a special character.")
    private String password;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private LocalDateTime lastLogin;

    public UsersDTO(String email, String name, String adress, String countryCode, String password, LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime lastLogin) {
        this.email = email;
        this.name = name;
        this.adress = adress;
        this.countryCode = countryCode;
        this.password = password;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.lastLogin = lastLogin;
    }


    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getAdress() {
        return adress;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getPassword() {
        return password;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public LocalDateTime getLastLogin() {
        return lastLogin;
    }


}
