package com.blog.blogspring.dto;

import com.blog.blogspring.model.FileInfo;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.Multipart;

@Data
public class ArticleForm {
    private String name;
    private String type;
    private String text;
    private MultipartFile image;
}
