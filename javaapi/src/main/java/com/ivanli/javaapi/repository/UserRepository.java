package com.ivanli.javaapi.repository;

import com.ivanli.javaapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Integer> {

}
