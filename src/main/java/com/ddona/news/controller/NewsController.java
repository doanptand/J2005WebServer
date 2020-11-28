package com.ddona.news.controller;

import com.ddona.news.entites.News;
import com.ddona.news.services.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/news")
public class NewsController {

    @Autowired
    private NewsService newsService;

    @GetMapping("/all")
    public List<News> getAllNews() {
        return newsService.getAllNews();
    }

    @GetMapping("/get/{id}")
    public News getOneNews(@PathVariable(name = "id") int id) {
        return newsService.getOneNews(id);
    }

    @PostMapping("/add")
    public News insertOrUpdate(@RequestBody News news) {
        return newsService.insertOrSave(news);
    }

    @DeleteMapping("delete/all")
    public void deleteAll() {
        newsService.deleteAllNews();
    }

    @DeleteMapping("delete/{id}")
    public void deleteOneNews(@PathVariable int id) {
        newsService.deleteOneNews(id);
    }
}
