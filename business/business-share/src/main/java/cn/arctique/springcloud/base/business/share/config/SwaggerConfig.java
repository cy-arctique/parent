package cn.arctique.springcloud.base.business.share.config;

import cn.arctique.springcloud.base.common.config.SwaggerBaseConfig;
import io.swagger.annotations.Api;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

/**
 * @author arctique
 * @date 2020/9/16 15:25
 */
@EnableSwagger2
@Configuration
public class SwaggerConfig {

    /**
     * share module
     *
     * @return {@link Docket}
     */
    @Bean
    public Docket createRest() {
        return new Docket(DocumentationType.SWAGGER_2)
                .enable(true)
                .apiInfo(info())
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                .build()
                //整合oauth2
                .securitySchemes(Collections.singletonList(SwaggerBaseConfig.apiKey()))
                .securityContexts(Collections.singletonList(SwaggerBaseConfig.securityContext()));
    }

    private ApiInfo info() {
        return new ApiInfoBuilder()
                .title("接口文档")
                .contact(new Contact("arctique", "http://arctique.cn", "cy.arctique@gmail.com"))
                .description("share module")
                .version("1.0.0")
                .build();
    }
}
