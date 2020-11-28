package com.ddona.news.services;

import com.ddona.news.entites.News;
import com.ddona.news.reporitory.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsService {

    @Autowired
    private NewsRepository newsRepository;

    public News getOneNews(int id) {
        return newsRepository.findById(id).get();
    }

    public List<News> getAllNews() {
        return (List<News>) newsRepository.findAll();
    }

    public void deleteOneNews(int id) {
        newsRepository.deleteById(id);
    }

    public void deleteAllNews() {
        newsRepository.deleteAll();
    }

    public News insertOrSave(News news) {
        return newsRepository.save(news);
    }

    public long count() {
        return newsRepository.count();
    }
}
