package com.github.blogproject.dto;

import com.github.blogproject.domain.Article;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class ArticleListViewResponse {

    private final Long id;
    private final String title;
    private final String content;
    private final LocalDateTime createAt;

    public ArticleListViewResponse(Article article) {
        this.id = article.getId();
        this.title = article.getTitle();
        this.content = article.getContent();
        this.createAt = article.getCreateAt();
    }
}