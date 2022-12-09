package com.springboot.service;

import com.springboot.common.Result;
import com.springboot.entity.Books;
import com.baomidou.mybatisplus.extension.service.IService;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.awt.print.Book;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author book_store
 * @since 2022-12-08
 */
public interface IBooksService extends IService<Books> {
//    增加书籍
    public Result addBook(Books books);
//    书籍详情
    public Result bookDetail(int ISBN);
//    删除书籍
    public Result deleteBook(int ISBN);
//    根据作者名搜索书籍
    public Result searchByAuthor(String authorName);
//    根据ISBN搜索书籍
    public Result searchByISBN(int ISBN);
//    根据书籍名称搜索书籍
    public Result searchByName(String name);
//    所有书籍
    public Result allBooks();
//    按照主键更新书籍
    public Result updateBookByISBN(Books book);
/*----------------是否需要在关于书籍的简略情况中加入以下部分-----------------------------*/
//    书籍的销售数目
//    书籍的剩余数目
//    书籍价格

}
