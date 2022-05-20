package cn.arctique.springcloud.base.share.provider.api.service;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import cn.arctique.springcloud.base.share.provider.api.pojo.Share;

/**
 * share服务
 *
 * @author arctique
 * @date 2020/9/16 9:18
 */
public interface ShareService {

    /**
     * 测试
     *
     * @param string
     * @return {@link String}
     */
    String getString(String string);

    /**
     * 测试
     *
     * @param page
     * @return {@link Page<Share>}
     */
    Page<Share> findAll(Page page);

}
