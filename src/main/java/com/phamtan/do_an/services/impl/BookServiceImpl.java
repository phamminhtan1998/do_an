package com.phamtan.do_an.services.impl;

import com.phamtan.do_an.dao.entities.Book;
import com.phamtan.do_an.dao.repositories.BookRepository;
import com.phamtan.do_an.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl  implements BookService {
    @Autowired
    private BookRepository bookRepository ;

    @Override
    public List<Book> getByAuthor(String name) {
        List<Book> books = bookRepository.findByAuthor(name);
        if(books.size()>0&& books!=null) return books ;
        return null;
    }

    @Override
    public List<Book> getByPage(int start, int size) {
        List<Book> books = bookRepository.findAllBookWithLimit(start,size);
        if(books.size()>0&& books!=null) return books ;
        return null;
    }
    @Override
    public List<Book> getBookByCategory(long category_id ,int start ,int size) {
        List<Book> books = bookRepository.findAllBookInCategory(category_id,start,size);
        return books ;
    }

    @Override
    public List<Book> getBySale(int start, int size) {
        List<Book> books = bookRepository.findAllBookSale(start, size);
        if(books.size()>0&& books!=null) return books ;
        return null;
    }

    @Override
    public Book getByName(String name) {
        Book book = bookRepository.findByName(name);
        if(book!=null) return book ;
        return null;
    }

    @Override
    public Book getById(long id) {
        Book book = bookRepository.findById(id).get();
        if(book!=null) return book ;
        return null;
    }

    @Override
    public List<Book> getByYearPublished(int year) {
        List<Book> books = bookRepository.findByyearPublish(year);
        if(books.size()>0&& books!=null) return books ;
        return null;
    }

    @Override
    public List<Book> getByLanguage(String language) {
        List<Book> books = bookRepository.findByLanguage(language);
        if(books.size()>0&& books!=null) return books ;
        return null;
    }

    @Override
    public List<Book> getByPrice(int lowerPrice, int higherPrice) {
        List<Book> books = bookRepository.findAllBookInRangePrice(lowerPrice,higherPrice);
        if(books.size()>0&& books!=null) return books ;
        return null;
    }

    @Override
    public List<Book> getByNumberPage(int pageLow, int pageHigh) {
        List<Book> books = bookRepository.findAllBookByNumberPage(pageLow,pageHigh);
        if(books.size()>0&& books!=null) return books ;
        return null;
    }

    @Override
    public long saveBook(Book book) {
       Book book1 =  bookRepository.save(book);
       return book1.getId();
    }

    @Override
    public long updateBook(Book book) {
        Book book1 =  bookRepository.save(book);
        return book1.getId();
    }

    @Override
    public long deleteBook(Book book) {
         bookRepository.delete(book);
        return book.getId();
    }
}
