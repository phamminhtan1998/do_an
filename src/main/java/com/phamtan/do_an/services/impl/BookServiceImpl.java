package com.example.demo.services.impl;

import com.example.demo.entities.Book;
import com.example.demo.repositories.BookRepository;
import com.example.demo.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        if(books.size()>0) return books;
        return null;
    }

    @Override
    public List<Book> getBookWithLimit(int start,int size) {
        List<Book> books = bookRepository.findAllBookWithLimit(start,size);
        return books ;
    }

    @Override
    public Book getBookById(long id ) {
        try {
            Optional<Book> book =  bookRepository.findById(id);
            return book.get();
        }
        catch (Exception e){
            e.printStackTrace();
            return null ;
        }

    }

    @Override
    public List<Book> getBookSale(int start, int size) {
        List<Book> books = bookRepository.findAllBookSale(start,size);
        return books ;
    }

    @Override
    public long addBook(Book book) {
        try {
            bookRepository.save(book);
            return book.getId();
        }
        catch (Exception e){
            e.printStackTrace();
            return 0 ;
        }
    }

    @Override
    public long updateBook(Book book) {
        if (!bookRepository.existsById(book.getId())){
            return 0;
        }
        else {
            try {
                bookRepository.save(book);
                return book.getId();
            } catch (Exception e) {
                e.printStackTrace();
                return 0;
            }
        }
    }

    @Override
    public long deleteBook(Book book) {
        if (!bookRepository.existsById(book.getId()))
            return 0;
        else{
            bookRepository.delete(book);
            return book.getId();
        }
    }

    @Override
    public List<Book> getBookByAuthor(String authorName) {
        try {
            List<Book> books = bookRepository.findByAuthor(authorName);
            return books;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
