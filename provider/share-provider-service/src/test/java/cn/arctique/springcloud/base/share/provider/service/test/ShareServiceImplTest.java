package cn.arctique.springcloud.base.share.provider.service.test;

import cn.arctique.springcloud.base.share.provider.api.pojo.Share;
import cn.arctique.springcloud.base.share.provider.service.mapper.ShareMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author arctique
 * @date 2020/9/16 9:56
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ShareServiceImplTest {

    @Resource
    private ShareMapper shareMapper;

    /**
     * 测试框架环境
     */
    @Test
    public void testFindAll() {
        List<Share> shares = shareMapper.selectList(null);
        shares.forEach(System.out::println);
    }

    @Test
    public void test() {

    }
}
