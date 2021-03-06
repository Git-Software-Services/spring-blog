package com.codeup.blog;

import com.codeup.blog.models.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository <Post, Integer> {
    Post save(Post post);
    Post findById(int id);
    void delete(int id);
}
