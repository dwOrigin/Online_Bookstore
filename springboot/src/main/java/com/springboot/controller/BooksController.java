package com.springboot.controller;


import com.springboot.common.Result;
import com.springboot.service.IBooksService;
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
/*@GetMapping
    public String hello(){
    return "hello, this store begins to business today";
}*/
@GetMapping("/ISBN")
    public Result searchByISBN(@RequestParam("ISBN") int ISBN){
    return booksService.searchByISBN(ISBN);
}
    @GetMapping("/bookName")
    public Result searchByName(@RequestParam("bookName") String name){
        return booksService.searchByName(name);
    }
}

