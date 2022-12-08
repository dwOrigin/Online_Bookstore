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
@ApiModel(value = "Shoppings对象", description = "")
public class Shoppings implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("订单号")
      private Integer shoppingId;

    @ApiModelProperty("书籍ISBN")
    private Integer shoppingBookIsbn;

    @ApiModelProperty("购书人")
    private Integer shoppingBookUserId;

    @ApiModelProperty("购买数量")
    private Integer shoppingBookQuantities;

    @ApiModelProperty("付款状态")
    private Boolean shoppingStatus;


}
