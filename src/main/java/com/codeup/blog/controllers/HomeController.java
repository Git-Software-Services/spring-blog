package com.codeup.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {
    @GetMapping("/hello/{name}/{age}")
    @ResponseBody
    public String hello(@PathVariable String name, @PathVariable int age) {
        return "Hello from " + name + " who's age is " + age;
    }

    @GetMapping("/")
    public String landingPage() {
        return "index";
    }

    @GetMapping("/resume")
    public String showResume() {
        return "resume";
    }

    @PostMapping("/hello")
    @ResponseBody
    public String getPassword(@RequestParam(name = "password") String pass) {
        return pass + "adinwginr";
    }

    @GetMapping("/test.json")
    @ResponseBody
    public List<String> getList() {
        List<String> names = new ArrayList<>();
        names.add("Fer");
        names.add("Dorian");
        names.add("Ryan");
        return names;
    }
}


