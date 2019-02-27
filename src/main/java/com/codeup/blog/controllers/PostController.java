package com.codeup.blog.controllers;

import com.codeup.blog.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {

    private final PostRepository postDao;

    public PostController(PostRepository postDao){
        this.postDao = postDao;
    }
    @GetMapping("/posts")
    public String allPosts(Model model){
//        List<Post> posts = new ArrayList<>();
//        posts.add(new Post(2, "CSS rocks", "Declarative programming languages are awesome"));
//        posts.add(new Post(3, "JS is fun", "Programming is a way of thinking. Think in JS"));
        model.addAttribute("posts", postDao.findAll());
//        model.addAttribute("posts", posts);
        return "blog-grid";
    }

    @GetMapping("/posts/{id}")
    public String viewPost(@PathVariable int id){
        return "blog-single";
    }

    @GetMapping("/posts/create")
    public String viewPostForm(){
        return "create-blog-single";
    }

    @PostMapping("/posts/create")
    public String createPost(@RequestParam String title, @RequestParam String content) {
        Post post = new Post(title, content);
        postDao.save(post);
        return "redirect:/posts";
    }
}
