package cn.arctique.springcloud.base.user.provider.service.service;


import cn.arctique.springcloud.base.user.provider.api.pojo.User;
import cn.arctique.springcloud.base.user.provider.api.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author arctique
 * @date 2020/9/18 9:30
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceImplTest {

    @Resource
    private UserService userService;

    /**
     * 测试 通过用户名查找用户信息
     */
    @Test
    public void findOneTest() {
        User admin = userService.findOne("admin");
        System.out.println(admin);
    }

}