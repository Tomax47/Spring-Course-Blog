package com.blog.blogspring.service;

import com.blog.blogspring.dto.ArticleDto;
import com.blog.blogspring.dto.ArticleForm;
import com.blog.blogspring.model.Article;
import com.blog.blogspring.model.User;
import com.blog.blogspring.repository.ArticleRepo;
import com.blog.blogspring.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Component
public class ArticleServiceImpl implements ArticleService{

    @Autowired
    private UserRepo usersRepository;

    @Autowired
    private ArticleRepo articleRepository;

    @Autowired
    private FileStorageService fileStorageService;

    @Override
    public List<ArticleDto> getByUser(Long userId) {
        User user = usersRepository.getOne(userId);
        List<Article> articlesOfUser = user.getCreatedArticles();

        for (Article article : articlesOfUser) {

            article.setImage(fileStorageService.findById(article.getImage().getId()));
            System.out.println(article.getImage().getFileName());
        }

        return ArticleDto.articleList(articlesOfUser);
    }

    @Override
    public ArticleDto addArticle(Long userId, ArticleForm articleForm) throws Exception {
        User author = usersRepository.getOne(userId);

        if (author != null) {

            try {
               String imageStorageName =  fileStorageService.saveFile((MultipartFile) articleForm.getImage());

                Article newArticle = Article.builder()
                        .author(author)
                        .name(articleForm.getName())
                        .type(articleForm.getType())
                        .text(articleForm.getText())
                        .image(fileStorageService.findByStorageName(imageStorageName))
                        .build();

                articleRepository.save(newArticle);
                return ArticleDto.from(newArticle);
            } catch (Exception e) {
                throw new Exception(e);
            }
        }

        // TODO : HANDLE THE NULL AUTHOR EXCEPTION!
        return null;
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

    @Override
    public ArticleDto getById(Long articleId) {

        Article article = articleRepository.findById(articleId).get();
        return ArticleDto.from(article);
    }

    @Override
    public List<ArticleDto> getAllArticles() {

        List<Article> articles = articleRepository.findAll();

        return ArticleDto.articleList(articles);
    }
}
