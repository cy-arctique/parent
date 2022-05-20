package cn.arctique.springcloud.base.common.util.constant.oauth;

import lombok.Getter;

/**
 * @author arctique
 * @date 2020/10/27 16:10
 */
@Getter
public enum Oauth2Enum {

    INVALID_TOKEN(4700, "无效token"),

    OAUTH_EXCEPTION(4701, "oauth未知错误"),

    LOGOUT_EXCEPTION(4702, "登出失败，token空")

    ;

    private Integer code;
    private String msg;

    Oauth2Enum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
