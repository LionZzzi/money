package com.eric.base.config.swagger;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @author Eric
 * @date 2019/5/19 11:27
 */
@Configuration
public class Swagger3Config {

    @Bean
    public Docket sys(Environment environment) {
        // 设置要显示swagger的环境
        Profiles of = Profiles.of("dw", "home", "outside");
        return new Docket(DocumentationType.OAS_30)
                .groupName("sys")
                .apiInfo(apiInfo())
                .enable(environment.acceptsProfiles(of))
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.ant("/sys/**"))
                .build();
    }

    @Bean
    public Docket fit(Environment environment) {
        // 设置要显示swagger的环境
        Profiles of = Profiles.of("dw", "home", "outside");
        return new Docket(DocumentationType.OAS_30)
                .groupName("fit")
                .apiInfo(apiInfo())
                .enable(environment.acceptsProfiles(of))
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.ant("/fit/**"))
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("spring boot 模板")
                .contact(new Contact("Eric", "#", "380652070@qq.com"))
                .description("Template")
                .version("1.0")
                .build();
    }
}
