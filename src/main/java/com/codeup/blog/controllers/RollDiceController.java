package com.codeup.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.ArrayList;
import java.util.List;

@Controller
public class RollDiceController {
    @GetMapping("/roll-dice/{n}")
    public String getNumber(@PathVariable int n, Model model) {
        int random = (int) Math.ceil(Math.random() * 6);
        List<Integer> randomNumbers = new ArrayList<>();
        int numberOfMatches = 0;

            model.addAttribute("n", n);
        for (int i = 1; i < n; i++) {
            int newRoll = (int) Math.ceil(Math.random() * 6);
            model.addAttribute("random", random);
            randomNumbers.add(newRoll);
        }
//            model.addAttribute("i", i);
            model.addAttribute("randomNumbers", randomNumbers);

        for(int randomNumber: randomNumbers) {
            if (randomNumber == n) {
                model.addAttribute("matchingNumber", true);
                 numberOfMatches ++;
            }
            model.addAttribute("numberOfMatches", numberOfMatches);
        }

        return "roll-dice";
    }
}
