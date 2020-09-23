package cn.arctique.springcloud.base.business.oauth2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author arctique
 * @date 2020/9/17 11:44
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableDiscoveryClient
public class BusinessOauth2Application {

    public static void main(String[] args) {
        SpringApplication.run(BusinessOauth2Application.class, args);
    }
}
