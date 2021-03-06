package br.com.vinirib.pact.consumer.client.config;

import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.json.Json;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class ApiConfig {

    @Value("${info.build.version}")
    private String buildVersion;

    /**
     * To add more features visit
     * https://www.baeldung.com/swagger-2-documentation-for-spring-rest-api
     */
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Client API",
                "Client detail from Account of an bank API Made by Vinicius Ribeiro.",
                buildVersion,
                "Terms of service",
                new Contact("Vinícius Ribeiro", "https://github.com/vinirib",
                        "viniciusribeirosp@gmail.com"),
                "License of API", "API license URL", Collections.emptyList());
    }

}
