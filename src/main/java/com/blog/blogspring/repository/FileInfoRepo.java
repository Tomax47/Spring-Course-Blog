package com.blog.blogspring.repository;

import com.blog.blogspring.model.FileInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileInfoRepo extends JpaRepository<FileInfo, Long> {
    FileInfo findByFileStorageName(String fileName);
}
