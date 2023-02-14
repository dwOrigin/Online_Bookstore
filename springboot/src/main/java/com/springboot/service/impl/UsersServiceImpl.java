package com.springboot.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.springboot.common.Result;
import com.springboot.entity.Users;
import com.springboot.mapper.UsersMapper;
import com.springboot.service.IUsersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Wrapper;
import java.util.List;

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
    @Resource
    private UsersMapper usersMapper;
    @Override
    public Result allUsers(Users tmp) {
        QueryWrapper<Users> queryWrapper = new QueryWrapper<>();
        List<Users> users = usersMapper.selectList(queryWrapper);
        for(Users userInDB : users) {
            if (userInDB.getUserEmail().equalsIgnoreCase(tmp.getUserEmail())
                    &&userInDB.getuserPassword().equalsIgnoreCase(tmp.getuserPassword()))
                return Result.success("success");
        }
        return Result.error();
    }

    @Override
    public Result addUsers(Users user) {
        Users users =user;
        users.setUserOrRegister(false);
        int insert = usersMapper.insert(users);
        if (insert>=1)
            return Result.success();
        else
            return Result.error();
    }

    @Override
    public Result updateUsers(Users user) {
        int update = usersMapper.updateById(user);
        if (update>=1)
            return Result.success();
        else
            return Result.error();
    }

    @Override
    public Result deleteUsers(int user_id) {
        int delete = usersMapper.deleteById(user_id);
        if (delete>=1)
            return Result.success();
        else
            return Result.error();
    }

    @Override
    public Result deleteUnRegisterUser() {
        QueryWrapper<Users> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_or_register",false);
        int delete = usersMapper.delete(queryWrapper);
        if (delete>=0)
            return Result.success();
        else
            return Result.error();
    }
}
