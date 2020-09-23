package cn.arctique.springcloud.base.share.provider.service;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author arctique
 * @date 2020/9/16 9:26
 */
@SpringBootApplication
@MapperScan(basePackages = "cn.arctique.springcloud.base.share.provider.service.mapper")
public class ShareProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShareProviderApplication.class, args);
    }
}
