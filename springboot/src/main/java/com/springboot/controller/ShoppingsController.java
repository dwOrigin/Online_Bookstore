package com.springboot.controller;


import com.springboot.common.Result;
import com.springboot.entity.Shoppings;
import com.springboot.service.IShoppingsService;
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
@RequestMapping("/shoppings")
public class ShoppingsController {
    @Autowired
    private IShoppingsService shoppingsService;
    @PostMapping("/{user_id}")
    public Result showAllShopping(@PathVariable int user_id){
       return shoppingsService.showUserShopping(user_id);
    }
    @GetMapping("/{user_id}/delete")
    public Result deleteUserShopping(@PathVariable("user_id") int user_id){
       return shoppingsService.deleteUserShopping(user_id);
    }

    @PostMapping("/addShopping")
    public Result addUserShopping(@RequestBody Shoppings shoppings)
    {
//        如果一件商品没有被购买过，那就是添加，如果购买过了，就予以更新操作
//
        if (shoppingsService.getById(shoppings.getShoppingId())==null) {
            return shoppingsService.addShopping(shoppings);
        }else
        {
            return shoppingsService.updateUserShopping(shoppings);
        }
    }

}

