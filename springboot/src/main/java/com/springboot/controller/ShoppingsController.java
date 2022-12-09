package com.springboot.controller;


import com.springboot.service.IShoppingsService;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/shoppings")
public class ShoppingsController {
    @Autowired
    private IShoppingsService shoppingsService;

}

