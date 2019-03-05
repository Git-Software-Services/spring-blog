package com.codeup.blog.controllers;

import com.codeup.blog.UserRepository;
import com.codeup.blog.models.User;

public class UserController {
    private final UserRepository userDao;

    public UserController( UserRepository userDao){
        this.userDao = userDao;}
}
