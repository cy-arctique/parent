package cn.arctique.springcloud.base.user.provider.service;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author arctique
 * @date 2020/9/18 9:19
 */
@SpringBootApplication
@MapperScan(basePackages = "com.cts.learning.library.user.provider.service.mapper")
public class UserProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserProviderApplication.class, args);
    }
}
