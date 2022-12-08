package com.springboot.mapper;

import com.springboot.entity.Shoppings;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.mapstruct.Mapper;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author book_store
 * @since 2022-12-08
 */
@Mapper
public interface ShoppingsMapper extends BaseMapper<Shoppings> {

}
