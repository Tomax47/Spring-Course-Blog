package com.blog.blogspring.service;

import com.blog.blogspring.dto.ArticleDto;
import com.blog.blogspring.dto.ArticleForm;
import com.blog.blogspring.model.Article;
import com.blog.blogspring.model.User;
import com.blog.blogspring.repository.ArticleRepo;
import com.blog.blogspring.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class ArticleServiceImpl implements ArticleService{

    @Autowired
    private UserRepo usersRepository;


    @Autowired
    private ArticleRepo articleRepository;
    @Override
    public List<ArticleDto> getByUser(Long userId) {
        User user = usersRepository.getOne(userId);
        List<Article> articlesOfUser = user.getCreatedArticles();
        return ArticleDto.articleList(articlesOfUser);
    }

    @Override
    public ArticleDto addArticle(Long userId, ArticleForm articleForm) {
        User author = usersRepository.getOne(userId);

        Article newArticle = Article.builder()
                .author(author)
                .name(articleForm.getName())
                .type(articleForm.getType())
                .text(articleForm.getText())
                .build();

        articleRepository.save(newArticle);
        return ArticleDto.from(newArticle);
    }

    @Override
    public ArticleDto like(Long userId, Long articleId){
        User user = usersRepository.getOne(userId);
        Article article = articleRepository.getOne(articleId);
        if (articleRepository.existsByArticleIdAndLikesContaining(articleId, user)) {
            article.getLikes().remove(user);
        }
        else {
            article.getLikes().add(user);
        }
        System.out.println("**********************");
        articleRepository.save(article);
        return ArticleDto.from(article);
    }
}
