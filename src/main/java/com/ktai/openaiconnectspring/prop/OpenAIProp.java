package com.ktai.openaiconnectspring.prop;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "openai")
public class OpenAIProp {
    String token;
    String model;
    String maxTokens;
    String temperature;
}
