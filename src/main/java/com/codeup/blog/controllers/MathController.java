package com.codeup.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MathController {
    @GetMapping("/{math}/{num1}/{num2}")
    @ResponseBody
    public int arithmetic(@PathVariable String math, @PathVariable int num1, @PathVariable int num2) {
        int total = 0;
        if (math.equalsIgnoreCase("add")) {
            total = num1 + num2;
           return total;
        }else if (math.equalsIgnoreCase("subtract")){
             total = num1 - num2;
            return total;
        }else if (math.equalsIgnoreCase("multiply")){
             total = num1 * num2;
            return total;
        }else if (math.equalsIgnoreCase("divide")){
             total = num1 / num2;
            return total;
        }else {return 0;}
    }
}
