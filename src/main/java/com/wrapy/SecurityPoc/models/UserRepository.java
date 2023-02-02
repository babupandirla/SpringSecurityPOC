package com.wrapy.SecurityPoc.models;

import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<Users, Integer> {
    Users findByUsername(String s);
    Users findByUserId(int s);
}
