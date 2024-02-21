package com.github.blogproject.service;

import com.github.blogproject.domain.Article;
import com.github.blogproject.dto.AddArticleRequest;
import com.github.blogproject.repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BlogService {

    private final BlogRepository blogRepository;

    public Article save (AddArticleRequest request) {
        return blogRepository.save(request.toEntity());
    }


    public List<Article> findAll() {
        return blogRepository.findAll();
    }

    public Article findById(Long id) {
        return blogRepository.findById(id).orElseThrow(() -> new RuntimeException());
    }
}
