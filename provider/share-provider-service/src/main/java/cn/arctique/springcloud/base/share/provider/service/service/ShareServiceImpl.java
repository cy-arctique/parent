package cn.arctique.springcloud.base.share.provider.service.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.arctique.springcloud.base.share.provider.api.service.ShareService;
import cn.arctique.springcloud.base.share.provider.api.pojo.Share;
import cn.arctique.springcloud.base.share.provider.service.mapper.ShareMapper;
import org.apache.dubbo.config.annotation.Service;

import javax.annotation.Resource;

/**
 * @author arctique
 * @date 2020/9/16 9:27
 */
@Service(version = "1.0.0")
public class ShareServiceImpl extends ServiceImpl<ShareMapper, Share> implements ShareService {

    @Resource
    private ShareMapper shareMapper;

    @Override
    public String getString(String string) {
        return "测试成功 " + string;
    }

    @Override
    public Page<Share> findAll(Page page) {
        return shareMapper.findAll(page);
    }
}
