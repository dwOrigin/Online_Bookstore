package com.springboot.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.springboot.common.Result;
import com.springboot.entity.Books;
import com.springboot.mapper.BooksMapper;
import com.springboot.service.IBooksService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author book_store
 * @since 2022-12-08
 */
@Service
public class BooksServiceImpl extends ServiceImpl<BooksMapper, Books> implements IBooksService {

    @Resource
    private BooksMapper booksMapper;
    @Override
    public Result addBook(Books books) {

        int insert = booksMapper.insert(books);
        if (insert>=1)
            return Result.success();
        else
            return Result.error();
    }

    @Override
    public Result bookDetail(int ISBN) {
        Books books = booksMapper.selectById(ISBN);
        if (books!=null)
            return Result.success(books);
        else
            return Result.error();
    }

    @Override
    public Result deleteBook(int ISBN) {
        int delete = booksMapper.deleteById(ISBN);
        if (delete>=1)
            return Result.success();
        else
            return Result.error();
    }

    @Override
    public Result searchByAuthor(String authorName) {
        QueryWrapper<Books> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("book_author",authorName);
        List<Books> books = booksMapper.selectList(queryWrapper);
        if (books!=null)
            return Result.success(books);
        else
            return Result.error();
    }

    @Override
    public Result searchByISBN(int ISBN) {
        /*QueryWrapper<Books> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("isbn",ISBN);
        booksMapper.selectById(queryWrapper);
       这种语句使用起来是不正确的，会导致查询的结果出现奇怪的问题
        */
        Books books = booksMapper.selectById(ISBN);
        if (books!=null)
            return Result.success(books);
        else
            return Result.error();
    }

    @Override
    public Result searchByName(String name) {
        QueryWrapper<Books> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("book_name",name);
        Books books = booksMapper.selectOne(queryWrapper);
        if (books!=null)
            return Result.success(books);
        else
            return Result.error();
    }

    @Override
    public Result allBooks() {
        Wrapper<Books> queryWrapper = new QueryWrapper<>();
        List<Books> books = booksMapper.selectList(queryWrapper);
        if (books!=null)
            return Result.success(books);
        else
            return Result.error();
    }

    @Override
    public Result updateBookByISBN(Books book) {
        int update = booksMapper.updateById(book);
        if (update>=1)
            return Result.success();
        else
            return Result.error();
    }
}
