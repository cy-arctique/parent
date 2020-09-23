package cn.arctique.springcloud.base.share.provider.api.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author arctique
 * @date 2020/9/16 10:16
 **/
@Data
public class Classify implements Serializable {
    /**
     * id
     */
    private Integer id;

    /**
     * 分类名
     */
    private String classifyName;

    /**
     * 操作时间
     */
    private Date operateTime;

    private static final long serialVersionUID = 1L;
}