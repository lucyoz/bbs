package com.example.bbs.controller;

import com.example.bbs.domain.dto.ArticleAddRequest;
import com.example.bbs.domain.dto.ArticleAddResponse;
import com.example.bbs.domain.dto.ArticleDto;
import com.example.bbs.service.ArticleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/articles")
public class ArticleRestController {

    private final ArticleService articleService;

    public ArticleRestController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArticleDto> getArticleDto(@PathVariable Long id){
        ArticleDto articleDto = articleService.getArticleById(id);
        return ResponseEntity.ok().body(articleDto);
    }

    @PostMapping("")
    public ResponseEntity<ArticleAddResponse> addArticle(@RequestBody ArticleAddRequest dto){
        ArticleAddResponse response = articleService.add(dto);
        return ResponseEntity.ok().body(response);
    }
}
