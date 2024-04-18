package com.blog.blogspring.dto;

import com.blog.blogspring.model.Article;
import lombok.*;
import java.util.List;
import java.util.stream.Collectors;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ArticleDto {
    private Long id;
    private String text;
    private String authorName;
    private Integer likesCount;
    private String imageUrl;

    public static ArticleDto from(Article article) {
        Integer count = 0;
        if (article.getLikes() != null) {
            count = article.getLikes().size();
        }

        String imageUrl = "http://localhost:8080/files/"+article.getImage().getFileStorageName();

        return ArticleDto.builder()
                .id(article.getArticleId())
                .text(article.getText())
                .authorName(article.getAuthor().getEmail())
                .likesCount(count)
                .imageUrl(imageUrl)
                .build();
    }

    public static List<ArticleDto> articleList(List<Article> articles) {
        return articles.stream()
                .map(ArticleDto::from)
                .collect(Collectors.toList());
    }
}
