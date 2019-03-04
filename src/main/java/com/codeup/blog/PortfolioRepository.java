package com.codeup.blog;

import com.codeup.blog.models.Portfolio;
import org.springframework.data.repository.CrudRepository;


public interface PortfolioRepository extends CrudRepository <Portfolio, Integer> {
    Portfolio save(Portfolio portfolio);
    Portfolio findById(int id);
    void delete(int id);
}

