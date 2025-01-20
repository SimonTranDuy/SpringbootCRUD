package com.spring.tutor.demo.services;

import org.springframework.web.multipart.MultipartFile;
import java.nio.file.Path;
import java.util.stream.Stream;

public interface iStorageService {
    public String storeFile(MultipartFile file);
    public Stream<Path> loadAll();  // Load all files inside a folder
    public byte[] readFileContent(String fileName);
    public void deleteAllFiles();
    
}
