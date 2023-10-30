package com.itvedant.petstore;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@Data
@ConfigurationProperties(prefix ="file")
public class FileStorageProperties {
    private String uploadDir;
}
