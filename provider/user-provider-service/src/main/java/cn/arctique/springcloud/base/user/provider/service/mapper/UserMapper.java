package cn.arctique.springcloud.base.user.provider.service.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import cn.arctique.springcloud.base.user.provider.api.pojo.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author arctique
 * @date 2020/9/18 9:24
 **/
@Mapper
public interface UserMapper extends BaseMapper<User> {
}