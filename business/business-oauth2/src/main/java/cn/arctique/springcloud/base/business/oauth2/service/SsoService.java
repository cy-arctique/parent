package cn.arctique.springcloud.base.business.oauth2.service;

import cn.arctique.springcloud.base.business.oauth2.dto.LoginParam;
import cn.arctique.springcloud.base.common.util.Result;

import javax.servlet.http.HttpServletRequest;

/**
 * @author arctique
 * @date 2020/9/25 9:00
 */
public interface SsoService {

    /**
     * 登录
     *
     * @param loginParam
     * @return {@link Result}
     */
    Result login(LoginParam loginParam);

    /**
     * 获取登录用户信息
     *
     * @return {@link Result}
     */
    Result getInfo();

    /**
     * 登出
     *
     * @param request
     * @return {@link Result}
     */
    Result logout(HttpServletRequest request);
}
