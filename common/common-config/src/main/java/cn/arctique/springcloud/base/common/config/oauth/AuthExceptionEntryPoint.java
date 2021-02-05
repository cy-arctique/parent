package cn.arctique.springcloud.base.common.config.oauth;

import cn.arctique.springcloud.base.common.util.JsonUtil;
import cn.arctique.springcloud.base.common.util.Result;
import cn.arctique.springcloud.base.common.util.constant.oauth.Oauth2Enum;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.common.exceptions.InvalidTokenException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author arctique
 * @date 2020/10/28 11:21
 */
@Component
public class AuthExceptionEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException a) throws IOException, ServletException {
        Map<String, Object> map = new HashMap<>(100);
        Throwable cause = a.getCause();

        httpServletResponse.setStatus(HttpStatus.OK.value());
        httpServletResponse.setHeader("Content-Type", "application/json;charset=UTF-8");
        try {
            if (cause instanceof InvalidTokenException) {
                httpServletResponse.getWriter().write(JsonUtil.toJson(Result.failure(Oauth2Enum.INVALID_TOKEN.getCode(),
                        Oauth2Enum.INVALID_TOKEN.getMsg(), "")));
            } else {
                httpServletResponse.getWriter().write(JsonUtil.toJson(Result.failure(Oauth2Enum.INVALID_TOKEN.getCode(),
                        Oauth2Enum.INVALID_TOKEN.getMsg(), "")));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
