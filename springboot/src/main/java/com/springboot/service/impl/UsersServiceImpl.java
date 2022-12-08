package com.springboot.service.impl;

import com.springboot.entity.Users;
import com.springboot.mapper.UsersMapper;
import com.springboot.service.IUsersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author book_store
 * @since 2022-12-08
 */
@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements IUsersService {

}
