package com.springboot.controller;


import com.springboot.common.Result;
import com.springboot.entity.Users;
import com.springboot.service.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping
    public Result registerUser(@RequestBody Users user){
    usersService.deleteUnRegisterUser();
    Users users = user;
    users.setUserOrRegister(true);
    return usersService.addUsers(users);
}
    @PostMapping("/{user_id}")
    public Result userDetail(@PathVariable("user_id") int user_id){
    return usersService.userDetail(user_id);
}
    @PostMapping("/{user_id}/delete")
    public Result deleteUser(@PathVariable("user_id") int user_id){
    return usersService.deleteUsers(user_id);
    }
    @PostMapping("/{user_id}/update")
    public Result UpdateUser(@PathVariable int user_id,@RequestBody Users users){
    usersService.userDetail(user_id);
    return usersService.updateUsers(users);
    }

}

