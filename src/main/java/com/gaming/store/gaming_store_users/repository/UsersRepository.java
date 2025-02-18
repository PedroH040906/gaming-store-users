package com.gaming.store.gaming_store_users.repository;

import com.gaming.store.gaming_store_users.model.Users;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, String> {
}
