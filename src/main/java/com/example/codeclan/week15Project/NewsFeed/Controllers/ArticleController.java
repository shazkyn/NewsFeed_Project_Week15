package com.example.codeclan.week15Project.NewsFeed.Controllers;

import com.example.codeclan.week15Project.NewsFeed.Models.Article;
import com.example.codeclan.week15Project.NewsFeed.Repositories.ArticleRepository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/articles")
public class ArticleController {

    @Autowired
    ArticleRepository articleRepository;

    @GetMapping(value = "/")
    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }

    @GetMapping(value = "/date/{date}")
    public List<Article> getAllArticlesForDate(@PathVariable String date){
        return articleRepository.getAllArticlesForDate(date);
    }

}
