package com.springboot.mapper;

import com.springboot.entity.Search;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.mapstruct.Mapper;

import javax.validation.constraints.Max;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author book_store
 * @since 2022-12-08
 */
@Mapper
public interface SearchMapper extends BaseMapper<Search> {

}
