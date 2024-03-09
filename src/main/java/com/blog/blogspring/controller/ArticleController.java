package com.blog.blogspring.controller;

import com.blog.blogspring.dto.ArticleDto;
import com.blog.blogspring.dto.ArticleForm;
import com.blog.blogspring.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ArticleController {

    @Autowired
    private ArticleService articleService;


    @PostMapping("/users/{user-id}/articles")
    @ResponseBody
    public ArticleDto addArticle(@PathVariable("user-id") Long userId,
                                 @ModelAttribute ArticleForm articleForm) {
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
}
