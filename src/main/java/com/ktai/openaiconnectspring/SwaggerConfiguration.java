package com.ktai.openaiconnectspring;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author k-taichi
 */
@Configuration
public class SwaggerConfiguration {
    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("public")
                .pathsToMatch("/**")
                .build();
    }

    @Bean
    public OpenAPI SigningSolutionsOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("OpenAI API")
                        .description("こちらはサンプルAPI一覧画面です")
                        .version("v0.0.1-SNAPSHOT")
                        .contact(new Contact().name("k-taichi").url("https://github.com/k-taichi/openai-connect-spring").email(""))
                        .license(new License().name("k-taichi").url("https://github.com/k-taichi/openai-connect-spring")))
                        ;
    }
}
