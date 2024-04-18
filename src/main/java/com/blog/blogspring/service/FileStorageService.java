package com.blog.blogspring.service;

import com.blog.blogspring.model.FileInfo;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

public interface FileStorageService {
    String saveFile(MultipartFile file);
    void writeFileToResponse(String fileStorageName, HttpServletResponse response);
    FileInfo findByStorageName(String storageName);
    FileInfo findById(Long id);
}
