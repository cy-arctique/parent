package cn.arctique.springcloud.base.business.oauth2.service.impl;

import cn.arctique.springcloud.base.business.oauth2.dto.LoginInfo;
import cn.arctique.springcloud.base.business.oauth2.dto.LoginParam;
import cn.arctique.springcloud.base.business.oauth2.service.SsoService;
import cn.arctique.springcloud.base.common.util.constant.CommonConstants;
import cn.arctique.springcloud.base.common.util.JsonUtil;
import cn.arctique.springcloud.base.common.util.OkHttpUtil;
import cn.arctique.springcloud.base.common.util.Result;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author arctique
 * @date 2020/9/25 9:08
 */
@Service
public class SsoServiceImpl implements SsoService {

    private final String PORT = "9999";

    @Value("${server.servlet.context-path}")
    private String name;

    private final String grantType = "password";

    @Value("${security.oauth2.client.client-id}")
    private String clientId;

    @Value("${security.oauth2.client.client-secret}")
    private String clientSecret;

    @Resource(name = "userDetailsServiceBean")
    private UserDetailsService userDetailsService;

    @Resource
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Resource
    private TokenStore tokenStore;

    /**
     * 登录
     *
     * @param loginParam
     * @return {@link Result}
     */
    @Override
    public Result login(LoginParam loginParam) {
        Map<String, String> token = Maps.newHashMap();

        // 先验证账号密码
        UserDetails userDetails = userDetailsService.loadUserByUsername(loginParam.getUsername());
        if (userDetails != null && bCryptPasswordEncoder.matches(loginParam.getPassword(), userDetails.getPassword())) {
            // 获取token
            token.put("access_token", getToken(loginParam));
        }
        return userDetails != null && bCryptPasswordEncoder.matches(loginParam.getPassword(), userDetails.getPassword())
                ? Result.success(HttpStatus.OK.value(), "登录成功", token)
                : Result.failure(CommonConstants.REST_FAIL, "账号/密码错误", null);
    }

    /**
     * 获取登录用户信息
     *
     * @return {@link Result}
     */
    @Override
    public Result getInfo() {
        // 获取认证信息
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        System.out.println(authentication);

        LoginInfo loginInfo = new LoginInfo();
        loginInfo.setUsername(authentication.getName());

        return Result.success(HttpStatus.OK.value(), "获取用户信息", loginInfo);
    }

    /**
     * 登出
     *
     * @param request
     * @return {@link Result}
     */
    @Override
    public Result logout(HttpServletRequest request) {
        String token = request.getParameter("access_token");
        OAuth2AccessToken oAuth2AccessToken = tokenStore.readAccessToken(token);

        // 删除token
        tokenStore.removeAccessToken(oAuth2AccessToken);
        return Result.success(HttpStatus.OK.value(), "用户注销");
    }

    /**
     * 获取token
     *
     * @param loginParam
     * @return {@link String}
     */
    private String getToken(LoginParam loginParam) {
        final String URL = String.format("http://localhost:%s%s%s", PORT, name ,"/oauth/token");

        Map<String, String> params = Maps.newHashMap();
        params.put("username", loginParam.getUsername());
        params.put("password", loginParam.getPassword());
        params.put("grant_type", grantType);
        params.put("client_id", clientId);
        params.put("client_secret", clientSecret);
        String post = OkHttpUtil.post(URL, params);

        return JsonUtil.toMap(post).get("access_token").toString();
    }
}
