package cn.arctique.springcloud.base.user.provider.service.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.arctique.springcloud.base.user.provider.api.pojo.User;
import cn.arctique.springcloud.base.user.provider.api.service.UserService;
import cn.arctique.springcloud.base.user.provider.service.mapper.UserMapper;
import org.apache.dubbo.config.annotation.Service;

import javax.annotation.Resource;

/**
 * @author arctique
 * @date 2020/9/18 9:28
 */
@Service(version = "1.0.0")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Resource
    private UserMapper userMapper;

    /**
     * 通过用户名查找用户信息
     *
     * @param username
     * @return {@link User}
     */
    @Override
    public User findOne(String username) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("status", "1");
        queryWrapper.eq("username", username);
        return userMapper.selectOne(queryWrapper);
    }
}
