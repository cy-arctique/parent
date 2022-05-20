package cn.arctique.springcloud.base.business.index.test;

import cn.arctique.springcloud.base.common.util.JsonUtil;
import cn.arctique.springcloud.base.share.provider.api.pojo.Share;
import cn.arctique.springcloud.base.share.provider.api.service.ShareService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.dubbo.config.annotation.Reference;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author arctique
 * @date 2020/9/16 14:27
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class BusinessShareControllerTest {

    @Reference(version = "1.0.0")
    private ShareService shareService;

    @Test
    public void test() {
    }

    @Test
    public void shareServiceTest() {
        String string = shareService.getString("");
        System.out.println(string);

        System.out.println();

        Page page = new Page();
        Page<Share> all = shareService.findAll(page);
        System.out.println(JsonUtil.toJson(all));
    }
}
