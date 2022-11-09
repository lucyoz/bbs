package com.example.bbs.controller;

import com.example.bbs.Repository.ArticleRepository;
import com.example.bbs.domain.Article;
import com.example.bbs.domain.dto.ArticleDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/articles")
@Slf4j
public class ArticleController {

    private final ArticleRepository articleRepository;

    public ArticleController(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @GetMapping("/list")
    public String list(Model model){
        List<Article> articles = articleRepository.findAll();
        model.addAttribute("articles",articles);
        return "articles/list";
    }

    @GetMapping("")
    public String index(){
        return "redirect:/articles/list";
    }

    @GetMapping("/new")
    public String newArticleForm(){
        return "articles/new";
    }

    @PostMapping("/posts")
    public String createArticle(ArticleDto articleDto){
        log.info(articleDto.toString());
        Article article = articleDto.toEntity();
        Article savedArticle = articleRepository.save(article);
        return String.format("redirect:/articles/%d", savedArticle.getId());
    }

    @GetMapping("/{id}")
    public String selectSingle(@PathVariable Long id, Model model){
        Optional<Article> optArticle = articleRepository.findById(id);
        if(optArticle != null){
            model.addAttribute("article",optArticle.get());
            return "articles/show";
        }else {
            return "articles/error";
        }
    }

}
