package com.codeup.blog;

import com.codeup.blog.models.Portfolio;
import org.springframework.data.repository.CrudRepository;


public interface PortfolioRepository extends CrudRepository <Portfolio, Integer> {
    Portfolio save(Portfolio portfolio);
    Portfolio findByPortId(int portId);
    void delete(int portId);
}

