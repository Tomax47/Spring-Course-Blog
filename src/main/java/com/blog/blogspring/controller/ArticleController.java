package com.blog.blogspring.controller;

import com.blog.blogspring.dto.ArticleDto;
import com.blog.blogspring.dto.ArticleForm;
import com.blog.blogspring.security.details.UserDetailsImpl;
import com.blog.blogspring.service.ArticleService;
import com.blog.blogspring.service.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class ArticleController {

    @Autowired
    private ArticleService articleService;
    @Autowired
    private FileStorageService fileStorageService;


    @PostMapping("/users/{user-id}/articles")
    @ResponseBody
    public ArticleDto addArticle(@PathVariable("user-id") Long userId,
                                 @ModelAttribute ArticleForm articleForm,
                                 @RequestParam("file") MultipartFile file) throws Exception {

        articleForm.setImage(file);
        return articleService.addArticle(userId, articleForm);
    }
    @GetMapping("/users/{user-id}/articles")
    public String getArticlesOfUser(@PathVariable("user-id") Long userId, Model model) {
        model.addAttribute("articles", articleService.getByUser(userId));
        return "articles_page";
    }

    @PostMapping("/users/{user-id}/articles/{article-id}/like")
    @ResponseBody
    public Object like(@PathVariable ("user-id") Long userId,
                       @PathVariable ("article-id") Long articleId) {
        return articleService.like(userId, articleId);
    }

    @GetMapping("/users/articles")
    public String getAllArticles(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        model.addAttribute("articles", articleService.getAllArticles());
        model.addAttribute("userId", userDetails.getUserId());

        return "all_articles_page";
    }

    @GetMapping("/users/{user-id}/articles/{article-id}")
    public String getArticle(@PathVariable("user-id") Long userId,
                             @PathVariable("article-id") Long articleId,
                             Model model) {
        model.addAttribute("article", articleService.getById(articleId));
        model.addAttribute("userId", userId);
        return "article_page"
;    }
}
