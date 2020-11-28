package com.ddona.news.reporitory;

import com.ddona.news.entites.News;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsRepository extends CrudRepository<News, Integer> {
    News findNewsByTitle(String title);
}
