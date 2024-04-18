package com.blog.blogspring.service;

import com.blog.blogspring.dto.ArticleDto;
import com.blog.blogspring.dto.ArticleForm;
import java.util.List;

public interface ArticleService {
    List<ArticleDto> getByUser(Long userId);
    List<ArticleDto> getAllArticles();

    ArticleDto addArticle(Long userId, ArticleForm articleForm) throws Exception;

    // We use the ArticleDto and not the Article cuz in the articleDto we combined the info we need from the User and the Article classes, so we won't have to realize the User object again and call the author's name fe
    ArticleDto like(Long userId, Long articleId);

    ArticleDto getById(Long articleId);
}
