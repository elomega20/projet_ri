package com.ri.projet_ri.controller;

import com.ri.projet_ri.models.Article;
import com.ri.projet_ri.service.ServiceArticle;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
@RestController
@RequestMapping("/api/v1/")
@RequiredArgsConstructor
public class ControllerArticle {
    private final ServiceArticle serviceArticle;
    @GetMapping("articles/{mot_cle}")
    public ResponseEntity<List<Article>> getArticles(@PathVariable("mot_cle") String motCle) throws IOException {
        return serviceArticle.getArticles(motCle)
                .map(articles -> new ResponseEntity<>(articles, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
   /* @GetMapping("test-python")
    public ResponseEntity<ModelTest> getExecPython(){
        return new  ResponseEntity<>(serviceArticle.getExecPython(),HttpStatus.OK);
    }*/
}
