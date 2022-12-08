package com.springboot.entity;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author book_store
 * @since 2022-12-08
 */
@Getter
@Setter
@ApiModel(value = "Users对象", description = "")
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键")
      private Integer userId;

    @ApiModelProperty("用户邮箱")
    private String userEmail;

    @ApiModelProperty("用户名")
    private String userName;

    @ApiModelProperty("用户密码")
    private String userPassword;

    @ApiModelProperty("收货地址")
    private String userAddress;

    @ApiModelProperty("是否为注册用户")
    private Boolean userOrRegister;


}
