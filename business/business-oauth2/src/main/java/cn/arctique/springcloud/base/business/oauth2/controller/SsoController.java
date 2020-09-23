package cn.arctique.springcloud.base.business.oauth2.controller;

import cn.arctique.springcloud.base.business.oauth2.dto.LoginInfo;
import cn.arctique.springcloud.base.common.util.CommonConstants;
import cn.arctique.springcloud.base.common.util.JsonUtil;
import cn.arctique.springcloud.base.common.util.OkHttpUtil;
import cn.arctique.springcloud.base.common.util.Result;
import cn.arctique.springcloud.base.business.oauth2.dto.LoginParam;
import com.google.common.collect.Maps;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 单点登录
 *
 * @author arctique
 * @date 2020/9/17 14:34
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/user")
@Slf4j
@Api(value = "单点登录")
public class SsoController {

    private final String PORT = "8888";

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
     * @return ${@link Result}
     */
    @ApiOperation("登录")
    @PostMapping("/login")
    public Result login(@RequestBody LoginParam loginParam) {
        Map<String, String> token = Maps.newHashMap();

        // 先验证账号密码
        UserDetails userDetails = userDetailsService.loadUserByUsername(loginParam.getUsername());
        if (userDetails != null && bCryptPasswordEncoder.matches(loginParam.getPassword(), userDetails.getPassword())) {
            // 获取token
            token.put("access_token", getToken(loginParam));
        }
        return userDetails != null
                ? Result.success(HttpStatus.OK.value(), "登录成功", token)
                : Result.failure(CommonConstants.REST_FAIL, "账号/密码错误");
    }

    /**
     * 登录完成 获取用户信息
     *
     * @return ${@link Result}
     */
    @ApiOperation("获取用户信息")
    @GetMapping("/info")
    public Result getInfo() {
        // 获取认证信息
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        LoginInfo loginInfo = new LoginInfo();
        loginInfo.setUsername(authentication.getName());

        return Result.success(HttpStatus.OK.value(), "获取用户信息", loginInfo);
    }

    /**
     * 登出
     *
     * @param request
     * @return ${@link Result}
     */
    @ApiOperation("登出")
    @PostMapping("/logout")
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
     * @return ${@link String}
     */
    private String getToken(LoginParam loginParam) {
        final String URL = String.format("http://localhost:%s%s%s", PORT, name ,"/oauth/token");

        log.info("[url] : {}", URL);

        Map<String, String> params = Maps.newHashMap();
        params.put("username", loginParam.getUsername());
        params.put("password", loginParam.getPassword());
        params.put("grant_type", grantType);
        params.put("client_id", clientId);
        params.put("client_secret", clientSecret);
        String post = OkHttpUtil.post(URL, params);

        log.info("[post] : {}", JsonUtil.toJson(post));

        return JsonUtil.toMap(post).get("access_token").toString();
    }
}
