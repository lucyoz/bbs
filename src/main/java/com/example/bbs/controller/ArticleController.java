package com.example.bbs.controller;

import com.example.bbs.domain.dto.ArticleDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/articles")
@Slf4j
public class ArticleController {

    @GetMapping("/new")
    public String createPage(){
        return "new";
    }

    @PostMapping("")
    public String articles(ArticleDto articleDto){
        log.info(articleDto.getTitle());
        return "";
    }
}
