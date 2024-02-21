package com.github.blogproject.controller;

import com.github.blogproject.domain.Article;
import com.github.blogproject.dto.AddArticleRequest;
import com.github.blogproject.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
@RequestMapping("/api")
public class BlogApiController {

    private final BlogService blogService;

    @PostMapping("/articles")
    public ResponseEntity<Article> addArticle(@RequestBody AddArticleRequest addArticleRequest) {
        Article saveArticle = blogService.save(addArticleRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(saveArticle);
    }
}
