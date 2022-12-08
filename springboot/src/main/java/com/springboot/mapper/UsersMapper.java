package com.springboot.mapper;

import com.springboot.entity.Users;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
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
public interface UsersMapper extends BaseMapper<Users> {

}
