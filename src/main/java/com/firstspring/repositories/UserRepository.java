package com.firstspring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.firstspring.entities.User;

public interface UserRepository extends JpaRepository<User, String> {
  public User findUserByUsername(String username);
}
