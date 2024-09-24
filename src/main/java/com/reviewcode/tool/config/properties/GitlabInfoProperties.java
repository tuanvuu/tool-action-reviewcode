package com.reviewcode.tool.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Data
@ConfigurationProperties(prefix = "spring.client.gitlab")
public class GitlabInfoProperties {
    private String baseUrl;
    private String apiToken;
}
