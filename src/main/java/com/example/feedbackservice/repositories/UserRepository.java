package com.example.feedbackservice.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.feedbackservice.models.User;

public interface UserRepository extends CrudRepository<User, Long>
{
    User findByUsername(String username);
}
