package cn.arctique.springcloud.base.gateway.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import springfox.documentation.swagger.web.*;

/**
 * @author arctique
 * @date 2020/9/19 11:24
 */
@Configuration
public class SwaggerConfig {

    @Bean
    public SecurityConfiguration securityConfiguration() {
        return SecurityConfigurationBuilder.builder().build();
    }

    @Bean
    public UiConfiguration uiConfiguration() {
        return UiConfigurationBuilder.builder().build();
    }
}
