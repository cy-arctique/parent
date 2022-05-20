package cn.arctique.springcloud.base.business.oauth2.controller;

import cn.arctique.springcloud.base.business.oauth2.service.SsoService;
import cn.arctique.springcloud.base.business.oauth2.dto.LoginParam;
import cn.arctique.springcloud.base.common.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

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

    @Resource
    private SsoService ssoService;

    /**
     * 登录
     *
     * @param loginParam
     * @return {@link Result}
     */
    @ApiOperation("登录")
    @PostMapping("/login")
    public Result login(@RequestBody LoginParam loginParam) {
        return ssoService.login(loginParam);
    }

    /**
     * 登录完成 获取用户信息
     *
     * @return {@link Result}
     */
    @ApiOperation("获取用户信息")
    @GetMapping("/info")
    public Result getInfo() {
        return ssoService.getInfo();
    }

    /**
     * 登出
     *
     * @param request
     * @return {@link Result}
     */
    @ApiOperation("登出")
    @PostMapping("/logout")
    public Result logout(HttpServletRequest request) {
        return ssoService.logout(request);
    }
}
