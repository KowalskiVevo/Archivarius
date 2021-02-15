package ru.hostco.archivarius.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@ConfigurationProperties(prefix = "app")
public class ApplicationConfig {
    private String soapToken;
    private String url;
    private String soapUrl;
    
}
