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
@ApiModel(value = "Search对象", description = "")
public class Search implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键")
      private Integer searchId;

    @ApiModelProperty("搜索用户id")
    private Integer searchUserId;

    @ApiModelProperty("书籍ISBN")
    private Integer searchBookIsbn;

    @ApiModelProperty("书籍名称")
    private String searchBookName;

    @ApiModelProperty("书籍作者")
    private String searchBookAuthor;


}
