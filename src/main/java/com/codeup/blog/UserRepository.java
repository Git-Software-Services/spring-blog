package com.codeup.blog;

import com.codeup.blog.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    User save(User user);
    User findById(int id);
    void delete(int id);
}