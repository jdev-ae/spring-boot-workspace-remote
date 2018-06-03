package com.surendra.atm.configuration;

import com.surendra.atm.configuration.annotations.EnableAccountsApiSwaggerFilter;
import com.surendra.atm.configuration.annotations.EnableTransactionsApiSwaggerFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.BasicAuth;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityScheme;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.DocExpansion;
import springfox.documentation.swagger.web.ModelRendering;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger.web.UiConfigurationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    List<SecurityScheme> schemeList;

    public SwaggerConfig() {
        schemeList = new ArrayList<>();
        schemeList.add(new BasicAuth("basicAuth"));
    }

    @Bean
    public Docket accountsApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(EnableAccountsApiSwaggerFilter.class))
                .build()
                .securitySchemes(schemeList)
                .enableUrlTemplating(true)
                .apiInfo(apiInfo())
                .tags(new Tag("Accounts", "All endpoints related to Accounts"))
                .groupName("1. Accounts API");

    }

    @Bean
    public Docket transactionsApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(EnableTransactionsApiSwaggerFilter.class))
                .build()
                .securitySchemes(schemeList)
                .enableUrlTemplating(true)
                .apiInfo(apiInfo())
                .tags(new Tag("Transactions", "All endpoints related to Transactions"))
                .groupName("2. Transactions API");

    }

    private final ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("ATM REST API")
                .description("Simple API for ATM implementation")
                .contact(new Contact("Venkata Surendra Reddy Polam", "https://github.com/jdev-ae", "suren.jdev@gmail.com"))
                .version("1.0.0")
                .build();
    }

    @Bean
    public UiConfiguration swaggerUiConfig() {
        return UiConfigurationBuilder.builder()
                .defaultModelsExpandDepth(-1)
                .defaultModelExpandDepth(Integer.MAX_VALUE)
                .defaultModelRendering(ModelRendering.EXAMPLE)
                .docExpansion(DocExpansion.LIST)
                .displayRequestDuration(true)
                .build();
    }
}
