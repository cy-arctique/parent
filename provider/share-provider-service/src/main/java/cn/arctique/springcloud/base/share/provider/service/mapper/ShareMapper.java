package cn.arctique.springcloud.base.share.provider.service.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import cn.arctique.springcloud.base.share.provider.api.pojo.Share;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author arctique
 * @date 2020/9/16 9:52
 **/
@Mapper
public interface ShareMapper extends BaseMapper<Share> {

    /**
     * 测试
     *
     * @param page
     * @return {@link Page<Share>}
     */
    Page<Share> findAll(Page page);
}