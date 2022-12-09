package com.springboot.service;

import com.springboot.common.Result;
import com.springboot.entity.Shoppings;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author book_store
 * @since 2022-12-08
 */
public interface IShoppingsService extends IService<Shoppings> {
//   添加订单
    public Result addShopping(Shoppings shoppings);
//   删除某位用户的订单
    public Result deleteUserShopping(int user_id);
//   显示某个用户的订单
    public Result showUserShopping(int user_id);
//   更新订单
    /*当用户需要修改订单的数据时
    * 1. 在用户需要修改订单的数量时
    * 2. 在系统需要修改订单的付款状态时
    * */
    public Result updateUserShopping(Shoppings shoppings);
//  更新书库中的对应参数信息：书籍的销售量、书籍的剩余数目
    public Result updateBookInfo();
}
