package com.eric.entity.sys;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.eric.entity.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Eric
 * @since 2021/1/12 3:09 下午
 */
@ApiModel(value = "用户表")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "sys_user")
public class SysUser extends BaseEntity {

    @TableField(value = "user_name")
    @ApiModelProperty(value = "用户名")
    private String userName;

    @TableField(value = "nick_name")
    @ApiModelProperty(value = "用户昵称")
    private String nickName;

    @TableField(value = "`password`")
    @ApiModelProperty(value = "密码")
    private String password;

    @TableField(value = "email")
    @ApiModelProperty(value = "用户邮箱")
    private String email;

    @TableField(value = "`status`")
    @ApiModelProperty(value = "帐号状态（0正常 1停用）")
    private Integer status;

    @TableField(value = "del_flag")
    @ApiModelProperty(value = "删除标志（0正常 1删除）")
    private Integer delFlag;

    @TableField(value = "remark")
    @ApiModelProperty(value = "备注")
    private String remark;
}