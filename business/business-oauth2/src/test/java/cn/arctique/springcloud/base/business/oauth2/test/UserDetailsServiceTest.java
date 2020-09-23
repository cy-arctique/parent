package cn.arctique.springcloud.base.business.oauth2.test;

import cn.arctique.springcloud.base.business.oauth2.config.WebSecurityConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author arctique
 * @date 2020/9/17 13:09
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = WebSecurityConfiguration.class)
public class UserDetailsServiceTest {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Test
    public void getPassword() {
        String encode = bCryptPasswordEncoder.encode("123456");

        // $2a$10$wxLKAc97Clzq7FsTeAU2FOApC4gc6MANXJB3U19mJWXdAicDMBhfG
        System.out.println(encode);
    }


}
