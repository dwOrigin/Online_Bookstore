package com.springboot.service;

import com.springboot.common.Result;
import com.springboot.entity.Users;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author book_store
 * @since 2022-12-08
 */
public interface IUsersService extends IService<Users> {
//  全部用户信息
    public Result allUsers();
//    添加用户
    public Result addUsers(Users user);
//    更新用户信息
    public Result updateUsers(Users user);
//    删除用户
    public Result deleteUsers(int user_id);
//    退出时，自动删除没有注册的用户
    public Result deleteUnRegisterUser();
//    用户详情页不知道是否需要做
}
