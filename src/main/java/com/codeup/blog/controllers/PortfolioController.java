package com.codeup.blog.controllers;

import com.codeup.blog.PortfolioRepository;
import com.codeup.blog.models.Portfolio;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

@Controller
public class PortfolioController {

    private final PortfolioRepository portfolioDao;

    public PortfolioController(PortfolioRepository portfolioDao){
        this.portfolioDao = portfolioDao;
    }

    @GetMapping("/portfolio")
    public String allPortfolio(Model model){
        model.addAttribute("portfolio", portfolioDao.findAll());
        return "portfolio-grid";
    }

    @GetMapping("/portfolio/{id}")
    public String viewPortfolio(@PathVariable("id") int id, Model model){
        Portfolio postView = portfolioDao.findById(id);
        model.addAttribute("postView", postView);
        return "portfolio-single";
    }

    @GetMapping("/portfolio/create")
    public String viewPortfolioForm(Model model){
        model.addAttribute("portfolio", new Portfolio());
        return "create-portfolio-single";
    }
@Value("${file-upload-port}")
private String uploadPort;

    @PostMapping("/portfolio/create")
    public String createPortfolio(@ModelAttribute Portfolio portfolio, @RequestParam(name="file") MultipartFile uploadedFile, Model model) {
        String filename = uploadedFile.getOriginalFilename();
        String filepath = Paths.get(uploadPort, filename).toString();
        File destinationFile = new File(filepath);

        try {
            uploadedFile.transferTo(destinationFile);
            model.addAttribute("message", "File successfully uploaded!");
        } catch (IOException e) {
            e.printStackTrace();
            model.addAttribute("message", "Oops! Something went wrong! " + e);
        }
        portfolio.setImage(filename);
        portfolioDao.save(portfolio);
        return "redirect:/portfolio";
    }

    @GetMapping("/portfolio/edit/{id}")
    public String editPostForm(@PathVariable("id") int id, Model model){
        Portfolio portfolio = portfolioDao.findOne(id);
        model.addAttribute("portfolio", portfolio);
        return "edit-portfolio-single";
    }

    @PostMapping("/portfolio/edit/{id}")
    public String editPost(@PathVariable("id") int id, @ModelAttribute Portfolio portfolio, @RequestParam(name="file") MultipartFile uploadedFile, Model model) {
//        Util.upperCasedTitle(post.getTitle());
        String filename = uploadedFile.getOriginalFilename();
        String filepath = Paths.get(uploadPort, filename).toString();
        File destinationFile = new File(filepath);

        try {
            uploadedFile.transferTo(destinationFile);
            model.addAttribute("message", "File successfully uploaded!");
        } catch (IOException e) {
            e.printStackTrace();
            model.addAttribute("message", "Oops! Something went wrong! " + e);
        }
        portfolio.setImage(filename);
        portfolioDao.save(portfolio);
        return "redirect:/portfolio/" + id;
    }

    @PostMapping("/portfolio/delete")
    public String deletePortfolio(@RequestParam int deleteId) {
        portfolioDao.delete(deleteId);
        return "redirect:/portfolio";
    }
}
