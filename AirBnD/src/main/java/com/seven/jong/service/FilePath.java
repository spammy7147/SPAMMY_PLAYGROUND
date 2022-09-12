package com.seven.jong.service;

import lombok.Getter;
import org.springframework.stereotype.Service;

@Service
public class FilePath {

    public String getPath() {
        String path = "C:\\upload/";
        return path;
    }
}
