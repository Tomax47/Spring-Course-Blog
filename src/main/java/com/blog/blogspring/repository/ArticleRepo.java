package com.blog.blogspring.repository;

import com.blog.blogspring.model.Article;
import com.blog.blogspring.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepo extends JpaRepository<Article, Long> {
    boolean existsByArticleIdAndLikesContaining(Long articleId, User user);
}
