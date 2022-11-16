package com.example.bbs.service;

import com.example.bbs.Repository.ArticleRepository;
import com.example.bbs.domain.Article;
import com.example.bbs.domain.dto.ArticleAddRequest;
import com.example.bbs.domain.dto.ArticleAddResponse;
import com.example.bbs.domain.dto.ArticleDto;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ArticleService {

    private final ArticleRepository articleRepository;

    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }


    public ArticleDto getArticleById(Long id) {
        Optional<Article> optArticle = articleRepository.findById(id);
        ArticleDto articleDto = Article.of(optArticle.get());
        return articleDto;

    }

    public ArticleAddResponse add(ArticleAddRequest dto) {
        Article article = dto.toEntity();
        Article savedArticle = articleRepository.save(article);

        return new ArticleAddResponse(savedArticle.getId(), savedArticle.getTitle(), savedArticle.getContent());
    }
}
