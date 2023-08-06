package com.zerobase.stock.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                //.apis(RequestHandlerSelectors.any()) // basic-error-controller 꺄지 나옴.
                .apis(RequestHandlerSelectors.basePackage("com.zerobase.stock")) // 내 컨트롤러만 보이게끔. src>main>java>zerobase.weather 패키지네임기재
                .paths(PathSelectors.any())
               // .paths(PathSelectors.ant("/read/**")) //특정 패턴의 컨트롤러만 보이게끔.
                .build().apiInfo(apiInfo());
    }
    private ApiInfo apiInfo() {
        String description = "배당금관련 스크래핑 API 입니다!";
        return new ApiInfoBuilder()
                .title("배당금 알아보기 ;) ")
                .description(description)
                .version("1.0")
                .build();
    }

}

// http://localhost:8080/swagger-ui/index.html#/
