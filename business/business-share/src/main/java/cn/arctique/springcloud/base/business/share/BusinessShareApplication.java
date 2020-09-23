package cn.arctique.springcloud.base.business.share;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author arctique
 * @date 2020/9/16 13:59
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableDiscoveryClient
public class BusinessShareApplication {

    public static void main(String[] args) {
        SpringApplication.run(BusinessShareApplication.class, args);
    }
}
