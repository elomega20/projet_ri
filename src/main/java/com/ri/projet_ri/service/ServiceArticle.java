package com.ri.projet_ri.service;

import com.ri.projet_ri.models.Article;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceArticle {
    public Optional<List<Article>> getArticles(String motCle){
        return Optional.empty();
    }
}
