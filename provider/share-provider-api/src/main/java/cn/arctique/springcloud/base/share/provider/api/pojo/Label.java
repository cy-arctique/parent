package cn.arctique.springcloud.base.share.provider.api.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author arctique
 * @date 2020/9/16 10:16
 **/
@Data
public class Label implements Serializable {
    /**
     * id
     */
    private Integer id;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 标签名
     */
    private String labelName;

    /**
     * 操作时间
     */
    private Date operateTime;

    private static final long serialVersionUID = 1L;
}