package cn.arctique.springcloud.base.business.index;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author arctique
 * @date 2020/9/16 13:59
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableDiscoveryClient
public class BusinessIndexApplication {

    public static void main(String[] args) {
        SpringApplication.run(BusinessIndexApplication.class, args);
    }
}
