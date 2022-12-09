package com.springboot.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.Value;
import org.jetbrains.annotations.NotNull;

import java.io.Serializable;

/*@Data
public class Books implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(value="ISBN")
    private int Isbn;
    private String bookName;
    private String bookAuthor;
    private Double bookPrice;
    private Integer bookQuantities;
    private Integer bookSaleNumbers;
    private String bookIntroduction;
    private String bookImage;

}*/
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
@ApiModel(value = "Books对象", description = "")
public class Books implements Serializable {

    private static final long serialVersionUID = 1L;
    @TableId(value = "ISBN", type = IdType.AUTO)
    private Integer ISBN;

    @ApiModelProperty("书籍名称")
    private String bookName;

    @ApiModelProperty("书籍作者")
    private String bookAuthor;

    @ApiModelProperty("书籍价格")
    private Double bookPrice;

    @ApiModelProperty("书籍剩余数目")
    private Integer bookQuantities;

    @ApiModelProperty("书籍销售数目")
    private Integer bookSaleNumbers;

    @ApiModelProperty("书籍简介")
    private String bookIntroduction;

    @ApiModelProperty("书籍封面")
    private String bookImage;


}
