package com.phamtan.do_an.controller.book;

import com.phamtan.do_an.dao.entities.Book;
import com.phamtan.do_an.services.BookService;
import com.phamtan.do_an.services.impl.BookServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(value = "/books")
public class BookController {
    @Autowired
    private BookServiceImpl bookService ;
    int pageSize = 10 ;

    /*

    *   API FOR THE BOOK CONTROLLER
    *
    * */

    @GetMapping()
    public List<Book> getFirstPage(){
       List<Book> books =  bookService.getByPage(0,pageSize);
       return books;
    }

    @GetMapping(value = "{id}")
    public Book getBookById(@PathVariable(name = "id") long id){
        Book book =  bookService.getById(id);
        return book;
    }

    @GetMapping(value = "/{page}/{size}")
    public List<Book> getAllBookByPage(@PathVariable(name = "page") int page ,@PathVariable(name = "size") int size){
        List<Book> books =  bookService.getByPage(page*size,size);
        return books;
    }
    @GetMapping(value = "/sale/{page}/{size}")
    public List<Book> getBySale(@PathVariable(name = "page") int page ,@PathVariable(name = "size") int size){
        List<Book> books =  bookService.getBySale(page*size,size);
        return books;
    }
    @GetMapping(value = "/name-book/{name}")
    public Book getByName(@PathVariable(name = "name")String name ){
        Book book = bookService.getByName(name);
        return book ;
    }
    @GetMapping(value = "/author/{name}")
    public List<Book> getByAuthor(@PathVariable(name = "name")String name ){
        List<Book> books= bookService.getByAuthor(name);
        return books ;
    }
    @GetMapping(path = "/category/{id_cate}/{page}/{size}")
    public List<Book> getAllBooksInCategory(
            @PathVariable(name = "id_cate") long id_cate,
            @PathVariable(name = "page") int page,
            @PathVariable(name = "size") int size
    ){
        List<Book> books =  bookService.getBookByCategory(id_cate,page*size,size);
        return books ;
    }
    @GetMapping(value = "/year/{year}")
    public List<Book> getByYearPublished(@PathVariable(name = "year")int year ){
        List<Book> books= bookService.getByYearPublished(year);
        return books ;
    }
    @GetMapping(value = "/language/{language}")
    public List<Book> getByLanguage(@PathVariable(name = "language")String language ){
        List<Book> books= bookService.getByLanguage(language);
        return books ;
    }
    @GetMapping(value = "/number-page/{start}/{end}")
    public List<Book> getByNumberPage(@PathVariable(name = "start")int start, @PathVariable(name = "end")int end){
        List<Book> books= bookService.getByNumberPage(start,end);
        return books ;
    }
    @PostMapping()
    public long saveBook(@RequestBody(required = true) Book book){
       return  bookService.saveBook(book);
    }
    @PatchMapping()
    public long updateBook(@RequestBody(required = true) Book book){
        return  bookService.updateBook(book);
    }
    @DeleteMapping()
    public long deleteBook(@RequestBody(required = true) Book book){
        return  bookService.deleteBook(book);
    }
}
