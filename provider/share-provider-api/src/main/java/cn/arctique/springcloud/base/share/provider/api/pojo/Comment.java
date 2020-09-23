package cn.arctique.springcloud.base.share.provider.api.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author arctique
 * @date 2020/9/16 10:16
 **/
@Data
public class Comment implements Serializable {
    /**
     * id
     */
    private Integer id;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 所属父级id
     */
    private Integer parentId;

    /**
     * 状态值（1：删除/0：非删除）
     */
    private Byte status;

    /**
     * 分享id
     */
    private Integer shareId;

    /**
     * 评论内容
     */
    private String content;

    /**
     * 操作时间
     */
    private Date operateTime;

    private static final long serialVersionUID = 1L;
}