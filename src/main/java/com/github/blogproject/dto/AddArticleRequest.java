package com.github.blogproject.dto;

import com.github.blogproject.domain.Article;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class AddArticleRequest {

    private String title;
    private String content;

    public Article toEntity () {
        return Article.builder()
                .title(title)
                .content(content)
                .build();
    }
}
