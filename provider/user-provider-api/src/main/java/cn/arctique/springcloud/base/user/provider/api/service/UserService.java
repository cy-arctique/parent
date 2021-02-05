package cn.arctique.springcloud.base.user.provider.api.service;

import cn.arctique.springcloud.base.user.provider.api.pojo.User;

/**
 * user服务
 *
 * @author arctique
 * @date 2020/9/18 9:16
 */
public interface UserService {

    /**
     * 通过用户名查找用户信息
     *
     * @param username
     * @return {@link User}
     */
    User findOne(String username);
}
