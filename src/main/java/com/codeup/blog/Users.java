package com.codeup.blog;

import com.codeup.blog.models.User;
import org.springframework.data.repository.CrudRepository;

public interface Users extends CrudRepository<User, Long> {
    User findByUsername(String username);
}