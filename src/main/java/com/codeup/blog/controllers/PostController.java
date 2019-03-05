package com.codeup.blog.controllers;

import com.codeup.blog.PostRepository;
import com.codeup.blog.UserRepository;
import com.codeup.blog.models.Post;
import com.codeup.blog.models.User;
import com.codeup.blog.services.EmailServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

@Controller
public class PostController {

    private final PostRepository postDao;
    private final UserRepository userDao;

   @Autowired
   private EmailServices emailServices;

    public PostController( PostRepository postDao, UserRepository userDao){
        this.postDao = postDao;
        this.userDao = userDao;
    }

    @GetMapping("/posts")
    public String allPosts(Model model){
        model.addAttribute("posts", postDao.findAll());
        return "blog-grid";
    }

    @GetMapping("/posts/{id}")
    public String viewPost(@PathVariable int id, Model model){
        Post postView = postDao.findById(id);
        model.addAttribute("postView", postView);
        return "blog-single";
    }

    @GetMapping("/posts/create")
    public String viewPostForm(Model model){
        model.addAttribute("post", new Post());
        return "create-blog-single";
    }

    @PostMapping("/posts/create")
    public String createPost(@ModelAttribute Post post, @RequestParam(name="file") MultipartFile uploadedFile, Model model) {
        String filename = uploadedFile.getOriginalFilename();
        String filepath = Paths.get(uploadPath, filename).toString();
        File destinationFile = new File(filepath);


        User user = userDao.findOne(1);
        post.setUser(user);

        try {
            uploadedFile.transferTo(destinationFile);
            model.addAttribute("message", "File successfully uploaded!");
        } catch (IOException e) {
            e.printStackTrace();
            model.addAttribute("message", "Oops! Something went wrong! " + e);
        }
        post.setImage(filename);
        postDao.save(post);
        emailServices.prepareAndSend(post, "Post created", "the post was created successfully with the id" + post.getId());

        return "redirect:/posts";
    }

    @GetMapping("/posts/edit/{id}")
    public String editPostForm(@PathVariable int id, Model model){
        Post post = postDao.findOne(id);
        model.addAttribute("post", post);
        return "edit-blog-single";
    }

    @Value("${file-upload-path}")
private String uploadPath;


    @PostMapping("/posts/edit/{id}")
    public String editPost(@PathVariable int id, @ModelAttribute Post post, @RequestParam(name="file") MultipartFile uploadedFile, Model model) {
        String filename = uploadedFile.getOriginalFilename();
        String filepath = Paths.get(uploadPath, filename).toString();
        File destinationFile = new File(filepath);

        try {
            uploadedFile.transferTo(destinationFile);
            model.addAttribute("message", "File successfully uploaded!");
        } catch (IOException e) {
            e.printStackTrace();
            model.addAttribute("message", "Oops! Something went wrong! " + e);
        }
        post.setImage(filename);
        postDao.save(post);
        return "redirect:/posts/" + id;
    }

    @PostMapping("/posts/delete")
    public String deletePost( @RequestParam int deleteId) {
        postDao.delete(deleteId);
        return "redirect:/posts";
    }
}
