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
    public String viewPost(@PathVariable int id, Model model){
        Post postView = postDao.findById(id);
        model.addAttribute("postView", postView);

        return "blog-single";
    }

    @GetMapping("/posts/create")
    public String viewPostForm(){
        return "create-blog-single";
    }

    @PostMapping("/posts/create")
    public String createPost(@RequestParam String title, @RequestParam String content, @RequestParam String quote, @RequestParam String author) {
        Post post = new Post(title, content, quote, author);
        postDao.save(post);
        return "redirect:/posts";
    }

    @GetMapping("/posts/edit/{id}")
    public String editPostForm(@PathVariable int id, Model model){
        Post post = postDao.findOne(id);
        model.addAttribute("post", post);
        return "edit-blog-single";
    }

    @PostMapping("/posts/edit/{id}")
    public String editPost(@PathVariable int id, @RequestParam String title, @RequestParam String content, @RequestParam String quote, @RequestParam String author, Model model) {
        Post post = postDao.findOne(id);

        post.setAuthor(author);
        post.setBody(content);
        post.setQuote(quote);
        post.setTitle(title);

        postDao.save(post);
        return "redirect:/posts/" + id;
    }

    @PostMapping("/posts/delete")
    public String deletePost(@RequestParam int deleteId) {
        postDao.delete(deleteId);
        return "redirect:/posts";
    }
}
