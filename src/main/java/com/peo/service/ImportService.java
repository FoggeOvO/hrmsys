package com.peo.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ImportService {
    void ImportUser(MultipartFile file) throws IOException;
}
