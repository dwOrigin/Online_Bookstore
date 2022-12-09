package com.springboot.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.springboot.common.Result;
import com.springboot.entity.Books;
import com.springboot.entity.Shoppings;
import com.springboot.mapper.BooksMapper;
import com.springboot.mapper.ShoppingsMapper;
import com.springboot.service.IShoppingsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import static com.springboot.common.Constants.CODE_400;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author book_store
 * @since 2022-12-08
 */
@Service
public class ShoppingsServiceImpl extends ServiceImpl<ShoppingsMapper, Shoppings> implements IShoppingsService {
    @Resource
    private ShoppingsMapper shoppingsMapper;
    @Resource
    private BooksMapper booksMapper;
    @Override
    public Result addShopping(Shoppings shoppings) {
/* 需要用户购买的书籍数量必须要小于书库中的订单数量才能完成购买 */
        QueryWrapper<Books> booksQueryWrapper = new QueryWrapper<>();
        booksQueryWrapper.eq("book_quantities",shoppings.getShoppingBookQuantities());
        List<Books> booksList = booksMapper.selectList(booksQueryWrapper);
        if(shoppings.getShoppingBookQuantities()<=booksList.size())
        {
        int insert = shoppingsMapper.insert(shoppings);
        if (insert>=1)
            return Result.success();
        else
            return Result.error();}
        else
            return Result.error( CODE_400,"数量超过剩余书目");
    }

    @Override
    public Result deleteUserShopping(int user_id) {
        QueryWrapper<Shoppings> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("shopping_book_user_id",user_id);
        int delete = shoppingsMapper.delete(queryWrapper);
        if (delete>=1)
            return Result.success();
        else
            return Result.error();
    }

    @Override
    public Result showUserShopping(int user_id) {
        QueryWrapper<Shoppings> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("shopping_book_user_id",user_id);
        List<Shoppings> shoppingList = shoppingsMapper.selectList(queryWrapper);
        if (shoppingList!=null)
            return Result.success(shoppingList);
        else
            return Result.error();
    }

    @Override
    public Result updateUserShopping(Shoppings shoppings) {
        int update = shoppingsMapper.updateById(shoppings);
        if (update>=1)
            return Result.success();
        else
            return Result.error();
    }

    @Override
    public Result updateBookInfo() {
        int updateBookNumbers=0;
        QueryWrapper<Shoppings> shoppingQueryWrapper = new QueryWrapper<>();
        shoppingQueryWrapper.eq("shopping_status",true);
        List<Shoppings> shoppingsList = shoppingsMapper.selectList(shoppingQueryWrapper);
        for (int i=0;i<shoppingsList.size();i++){
            Books selectById = booksMapper.selectById(shoppingsList.get(i).getShoppingBookIsbn());
            selectById.setBookQuantities(selectById.getBookQuantities()-shoppingsList.get(i).getShoppingBookQuantities());
            selectById.setBookSaleNumbers(selectById.getBookSaleNumbers()+shoppingsList.get(i).getShoppingBookQuantities());
            booksMapper.updateById(selectById);//把更新后的书籍信息导入数据库中
            updateBookNumbers+=1;
        }
        if (updateBookNumbers==shoppingsList.size())
            return Result.success();
        else
            return Result.error();
    }
}
