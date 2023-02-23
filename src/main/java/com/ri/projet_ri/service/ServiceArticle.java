package com.ri.projet_ri.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ri.projet_ri.models.Article;
import com.ri.projet_ri.models.ModelTest;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceArticle {
    ObjectMapper objectMapper = new ObjectMapper();

    public Optional<List<Article>> getArticles(String motCle) throws IOException {
        List<Article> articles = objectMapper.readValue(new File("json-folder/doc-pertinent.json"), new TypeReference<List<Article>>(){});

        return Optional.of(articles);
    }

    public ModelTest getExecPython(){
        String concat = null;

        try {
            ProcessBuilder builder = new ProcessBuilder("python", "python-scripts/script.py", "1", "4");
            Process process = builder.start();

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            BufferedReader readers = new BufferedReader(new InputStreamReader(process.getErrorStream()));

            String lines = null;
            while ((lines=reader.readLine()) != null){
                concat += lines+"\n";
                System.out.println("lines "+lines);
            }

            while ((lines=readers.readLine()) != null){
                System.out.println("Error lines"+lines);
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        ModelTest modelTest = new ModelTest();
        modelTest.setChaine(concat);

        return modelTest;
    }

}
