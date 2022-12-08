package com.springboot.service.impl;

import com.springboot.entity.Shoppings;
import com.springboot.mapper.ShoppingsMapper;
import com.springboot.service.IShoppingsService;
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
public class ShoppingsServiceImpl extends ServiceImpl<ShoppingsMapper, Shoppings> implements IShoppingsService {

}
