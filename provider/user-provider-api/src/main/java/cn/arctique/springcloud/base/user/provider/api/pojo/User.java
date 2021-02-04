package cn.arctique.springcloud.base.user.provider.api.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @author arctique
 * @date 2020/9/16 10:17
 **/
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@TableName("user")
@ApiModel("用户表")
public class User implements Serializable {
    /**
     * id
     */
    @TableId(type = IdType.AUTO)
    @ApiModelProperty(value = "序号", required = true)
    private Integer id;

    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名", required = true)
    private String username;

    /**
     * 密码
     */
    @ApiModelProperty(value = "密码", required = true)
    private String password;

    /**
     * 昵称
     */
    @ApiModelProperty(value = "昵称", required = true)
    private String nickname;

    /**
     * 操作时间
     */
    @ApiModelProperty(value = "操作时间", required = true)
    private Date operateTime;

    /**
     * 盐
     */
//    @ApiModelProperty(value = "盐", required = true)
//    private String salt;

    /**
     * 状态
     */
    @ApiModelProperty(value = "状态", required = true)
    private String status;

    private static final long serialVersionUID = 1L;
}