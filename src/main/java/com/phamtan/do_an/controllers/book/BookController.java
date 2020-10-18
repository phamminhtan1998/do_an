package com.example.demo.web.book;

import com.example.demo.entities.Book;
import com.example.demo.contants.ResponseCode;
import com.example.demo.services.BookService;
import com.example.demo.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path ="books/")
public class BookController {
    //=============================== BOOKS CONTROLLER ===============================//

    @Autowired
    private BookService bookService ;

    @Autowired
    private CategoryService categoryService ;

    @GetMapping()
    public List<Book> getAllBooks(){
        List<Book> books =  bookService.getBookWithLimit(0,10);
        return books ;
    }

    @GetMapping(path = "{start}/{size}")
    public List<Book> getAllBooks(@PathVariable(name = "start") int start, @PathVariable(name = "size") int size){
       List<Book> books =  bookService.getBookWithLimit(start,size);
       return books ;
    }
    @GetMapping(path = "{authorName}")
    public List<Book> getAllBooks(@PathVariable(name = "authorName") String authorName){
        List<Book> books =  bookService.getBookByAuthor(authorName);
        return books ;
    }
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> addBook(@RequestBody Book book ){
         long id =  bookService.addBook(book);
         if(id !=0) return new ResponseEntity<String>(ResponseCode.ADD_SUCCESSFUL.getMessage(),HttpStatus.CREATED);
         else return new ResponseEntity<String>(ResponseCode.ADD_FAIL.getMessage(),HttpStatus.NOT_ACCEPTABLE);
    }
    @PatchMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateBook(@RequestBody Book book ){
        long id =  bookService.addBook(book);
        if(id !=0) return new ResponseEntity<String>(ResponseCode.UPDATE_SUCCESSFUL.getMessage(),HttpStatus.CREATED);
        else return new ResponseEntity<String>(ResponseCode.UPDATE_FAIL.getMessage(),HttpStatus.NOT_ACCEPTABLE);
    }
    @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> deleteBooks(@RequestBody Book book){
        long id = bookService.deleteBook(book);
        if(id !=0) return new ResponseEntity<String>(ResponseCode.DELETE_SUCCESSFUL.getMessage(),HttpStatus.CREATED);
        else return new ResponseEntity<String>(ResponseCode.DELETE_FAIL.getMessage(),HttpStatus.NOT_ACCEPTABLE);
    }


    //=============================== END OF BOOKS CONTROLLER ===============================//
}
