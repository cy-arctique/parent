package cn.arctique.springcloud.base.common.util;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author arctique
 * @date 2020/9/16 10:31
 */
@Setter
@Getter
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private int code;

    private String msg;

    private T date;

    public static <T> Result<T> success(int code) {
        return result(code, null, null);
    }
    public static <T> Result<T> success(int code, T date) {
        return result(code, null, date);
    }
    public static <T> Result<T> success(int code, String msg, T date) {
        return result(code, msg, date);
    }

    public static <T> Result<T> failure(int code) {
        return result(code, null, null);
    }
    public static <T> Result<T> failure(int code, String msg) {
        return result(code, msg, null);
    }

    private static <T> Result<T> result(int code, String msg, T date) {
        Result<T> result = new Result<>();
        result.setCode(code);
        result.setMsg(msg);
        result.setDate(date);
        return result;
    }
}
