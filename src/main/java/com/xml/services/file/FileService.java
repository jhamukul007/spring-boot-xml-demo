package com.xml.services.file;

import java.io.IOException;

public interface FileService {
    void createFile(FileRequest fileRequest) throws IOException;
}
