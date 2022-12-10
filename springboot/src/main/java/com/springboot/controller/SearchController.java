package com.springboot.controller;


import com.springboot.common.Result;
import com.springboot.entity.Search;
import com.springboot.service.IBooksService;
import com.springboot.service.ISearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author book_store
 * @since 2022-12-08
 */
@RestController
@RequestMapping("/search")
public class SearchController {
@Autowired
    private ISearchService searchService;
@Autowired
    private IBooksService booksService;
//初始化的时候直接显示出对应的搜索历史记录
    @PostMapping
    public Result showHistory(@RequestBody int user_id){
        return searchService.userSearchHistory(user_id);
    }
    @GetMapping("/ISBN")
    public Result searchByISBN(@RequestParam("ISBN") int ISBN,@RequestParam("user_id") int user_id){
        Result result = booksService.searchByISBN(ISBN);
        searchService.addHistory(new Search(ISBN,user_id));
        return result;
    }
    @GetMapping("/bookName")
    public Result searchByName(@RequestParam("bookName") String name,@RequestParam("user_id") int user_id){
        Result result = booksService.searchByName(name);
        searchService.addHistory(new Search(user_id,name));
        return result;
    }
    @GetMapping("/author")
    public Result searchByAuthor(@RequestParam("author") String author,@RequestParam("user_id") int user_id){
        Result result = booksService.searchByAuthor(author);
        searchService.addHistory(new Search(author,user_id));
        return result;
    }

}

