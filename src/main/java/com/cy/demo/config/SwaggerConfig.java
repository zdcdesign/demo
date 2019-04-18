package com.cy.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.async.DeferredResult;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 整合swagger
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2) //
                .genericModelSubstitutes(DeferredResult.class) //
                .useDefaultResponseMessages(false) //
                .forCodeGeneration(true) //
                .apiInfo(apiInfo()) //
                .pathMapping("/")// base，最终调用接口后会和paths拼接在一起
                .select() //
                .apis(RequestHandlerSelectors.basePackage("com.cy.demo.ctrl")) //扫描ctrolloer
                .paths(PathSelectors.any()) //
                .build(); //
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder() //
                .title("Swagger测试项目 RESTful APIs")
                .version("1.0")
                .build();
    }

}
