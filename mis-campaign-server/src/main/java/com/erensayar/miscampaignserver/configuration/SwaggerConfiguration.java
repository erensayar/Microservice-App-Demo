package com.erensayar.miscampaignserver.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.erensayar.mis-campaign-server"))
                .paths(PathSelectors.regex("/api.*"))
                .build().apiInfo(todoAppApiInfo());
    }

    private ApiInfo todoAppApiInfo() {
        return new ApiInfoBuilder()
                .title("Campaign Service")
                .description("API Doc")
                .contact(new Contact("Eren Sayar", "github.com/erensayar", "erensayar@yandex.com"))
                .version("1.0.0")
                .build();
    }

}
