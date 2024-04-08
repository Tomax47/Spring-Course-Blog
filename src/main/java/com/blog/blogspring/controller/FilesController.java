package com.blog.blogspring.controller;

import com.blog.blogspring.service.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FilesController {

    @Autowired
    FileStorageService fileStorageService;

    @GetMapping("/files")
    public String getFilesUploadPage() {
        return "upload_files_page";
    }

    @PostMapping("/files")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {

        String savedTo = fileStorageService.saveFile(file);

        return ResponseEntity.ok().body(savedTo);
    }
}
