package com.springboot.controller;


import com.springboot.common.Result;
import com.springboot.entity.Books;
import com.springboot.entity.Users;
import com.springboot.service.IBooksService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.websocket.server.PathParam;
import java.util.*;

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
@PostMapping("/search")
    public Result search(@RequestBody Books myBook) {
    System.out.println(myBook.getBookAuthor() + myBook.getISBN() + myBook.getBookName() + myBook.getBookQuantities());
    List<Books> tmp = new ArrayList<Books>();
    List<Books> tmp1 = booksService.searchByAuthor(myBook.getBookAuthor());
    Books tmp2 = booksService.searchByISBN(myBook.getBookQuantities());
    List<Books> tmp3 = booksService.searchByName(myBook.getBookName());
    if (tmp1 != null) {
        for (Books mybook : tmp1) {
            tmp.add(mybook);
        }
    }
    if (tmp2 != null) {
            tmp.add(tmp2);
    }
    if (tmp3 != null) {
        for (Books mybook : tmp3) {
            tmp.add(mybook);
        }
    }
    if(tmp!=null){
        return Result.success(tmp);
    }else
    {return Result.error();}
}
    @PostMapping("/allbook")
    public Result search(){
    return booksService.allBooks();
    }
}

