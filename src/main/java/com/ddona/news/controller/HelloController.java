package com.ddona.news.controller;

import com.ddona.news.entites.News;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello world";
    }

    @RequestMapping(value = "/hello2", method = RequestMethod.GET)
    public String hello2() {
        return "Hello world2";
    }

    @GetMapping("/test")
    public News getNews() {
        return new News(1, "ABC", "BCD", "GVH");
    }
}
