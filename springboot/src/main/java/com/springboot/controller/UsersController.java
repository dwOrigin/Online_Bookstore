package com.springboot.controller;


import com.springboot.common.Result;
import com.springboot.entity.Users;
import com.springboot.service.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author book_store
 * @since 2022-12-08
 */
@RestController
@RequestMapping("/users")
public class UsersController {
@Autowired
    private IUsersService usersService;
    @PostMapping("/register")
    public Result register(@RequestBody Users user){
        System.out.println("注册");
        return usersService.addUsers(user);
    }
    @PostMapping("/login")
    public Result login(@RequestBody Users user){
        System.out.println("登录");
        System.out.println(user.getUserEmail());
        Result tmp=usersService.allUsers(user);
        System.out.println(tmp);
       return tmp;
    }
}

