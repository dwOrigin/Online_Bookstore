package com.springboot.service;

import com.springboot.common.Result;
import com.springboot.entity.Search;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author book_store
 * @since 2022-12-08
 */
public interface ISearchService extends IService<Search> {
//    按照书籍名称搜索
    public Result searchByName(String bookName);
//    按照书籍ISBN搜索
    public Result searchByISBN(int ISBN);
//    按照书籍作者搜索
    public Result searchByAuthor(String bookAuthor);
//    用户的搜索记录
    public Result userSearchHistory(int user_id);
//    添加搜索记录
    public Result addHistory(Search search);
}
