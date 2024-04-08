package com.blog.blogspring.controller;

import com.blog.blogspring.service.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

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

    @GetMapping("/files/{file-name:.+}")
    public void getFile(@PathVariable("file-name") String fileStorageName, HttpServletResponse response) {
        fileStorageService.writeFileToResponse(fileStorageName, response);
    }
    /**
     We wrote "/files/{file-name:.+}" instead of "/files/file-name" in the URL mapping
     in order to capture the entire file name, including its extension, as a path variable.

     In the URL pattern "/files/{file-name:.+}" :
     1- the curly braces {} indicate a path variable named file-name.
     2- The :.+ part after the colon : is a regular expression that matches one or more characters of any type.
     This allows the path variable to capture the complete file name, including any dots or special characters that might be part of the file name or extension.
     */
}
