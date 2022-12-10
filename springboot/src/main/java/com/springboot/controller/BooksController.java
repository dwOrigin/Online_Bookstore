package com.springboot.controller;


import com.springboot.common.Result;
import com.springboot.service.IBooksService;
import com.springboot.service.IShoppingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
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
@RequestMapping("/books")
public class BooksController {
    @Autowired
    private IBooksService booksService;
    @Resource
    private IShoppingsService shoppingService;
    /**
     * 先更新所有书籍的信息，
     * 然后返回所有的书籍信息
    * */
@GetMapping
    public Result allBooks(){
    shoppingService.updateBookInfo();
    return booksService.allBooks();
}
/*
@GetMapping("/ISBN")
    public Result searchByISBN(@RequestParam("ISBN") int ISBN){
    return booksService.searchByISBN(ISBN);
}
    @GetMapping("/bookName")
    public Result searchByName(@RequestParam("bookName") String name){
        return booksService.searchByName(name);
    }
    @GetMapping("/author")
    public Result searchByAuthor(@RequestParam("author") String author){
    return booksService.searchByAuthor(author);
    }
*/
}

