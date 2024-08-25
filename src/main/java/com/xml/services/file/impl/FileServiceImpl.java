package com.xml.services.file.impl;

import com.xml.services.file.FileRequest;
import com.xml.services.file.FileService;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class FileServiceImpl implements FileService {
    @Override
    public void createFile(FileRequest fileRequest) throws IOException {
        Path path = Paths.get(".");
        Path filePath = path.resolve(fileRequest.filePath());

        Files.deleteIfExists(filePath);
        InputStream inputStream = new ByteArrayInputStream(fileRequest.fileContent().getBytes());
        Files.createFile(filePath);
        Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
        inputStream.close();
    }
}
