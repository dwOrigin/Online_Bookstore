package com.springboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.springboot.entity.Books;
import org.mapstruct.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author book_store
 * @since 2022-12-08
 */
@Mapper
public interface BooksMapper extends BaseMapper<Books> {

}
