package com.blog.blogspring.service;

import com.blog.blogspring.model.FileInfo;
import com.blog.blogspring.repository.FileInfoRepo;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

@Component
public class FileStorageServiceImpl implements FileStorageService {

    @Autowired
    private FileInfoRepo fileInfoRepo;

    // To get the storage path from the Application.properties
    @Value("${storage.path}")
    private String storagePath;

    @Override
    public String saveFile(MultipartFile file) {

        // Formulating the file's storage name
        String storageName = UUID.randomUUID().toString() + "." +
        FilenameUtils.getExtension(file.getOriginalFilename());

        //Building the FileInfo object
        FileInfo fileInfo = FileInfo.builder()
                .fileName(file.getOriginalFilename())
                .fileStorageName(storageName)
                .type(file.getContentType())
                .size(file.getSize())
                .url(storagePath + "\\" + storageName)
                .build();

        // Saving the file into the storage path directory
        try {
            Files.copy(file.getInputStream(), Paths.get(storagePath, storageName));
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }

        // Saving the file into the DB
        fileInfoRepo.save(fileInfo);
        return fileInfo.getFileStorageName();
    }

    @Override
    public void writeFileToResponse(String fileName, HttpServletResponse response) {
        // TODO: IMPLEMENT THE LOGIC
    }
}
