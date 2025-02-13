package com.gaming.store.gaming_store_users.service;

import jakarta.validation.constraints.*;

import java.time.LocalDateTime;
import java.time.ZoneId;
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
    private String  adress;

    @NotBlank(message = "Country code cannot be blank.")
    @Size(max = 2,min = 2)
    private String country_code;

    @AssertTrue(message = "Invalid country code.")
    public boolean isValidCountryCode() {
        return Arrays.asList(Locale.getISOCountries()).contains(country_code);
    }

    @NotBlank(message = "Password cannot be blank.")
    @Pattern(
            regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",
            message = "The password must be at least 8 characters long, including a lowercase letter, an uppercase letter, a number and a special character."
    )
    private String password;

    private LocalDateTime created_at;

    private LocalDateTime updated_at;

    private LocalDateTime last_login;

    public UsersDTO(String email, String name, String adress, String country_code, String password, LocalDateTime created_at, LocalDateTime updated_at, LocalDateTime last_login) {
        this.email = email;
        this.name = name;
        this.adress = adress;
        this.country_code = country_code;
        this.password = password;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.last_login = last_login;
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

    public String getCountry_code() {
        return country_code;
    }

    public String getPassword() {
        return password;
    }
    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public LocalDateTime getUpdated_at() {
        return updated_at;
    }

    public LocalDateTime getLast_login() {
        return last_login;
    }


}
