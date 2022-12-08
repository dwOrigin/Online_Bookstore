package com.springboot.service.impl;

import com.springboot.entity.Books;
import com.springboot.mapper.BooksMapper;
import com.springboot.service.IBooksService;
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
public class BooksServiceImpl extends ServiceImpl<BooksMapper, Books> implements IBooksService {

}
