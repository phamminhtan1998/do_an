package com.phamtan.do_an.services;

import com.phamtan.do_an.dao.entities.Book;

import java.util.List;

public interface BookService {
    /*
    *   ALL METHOD FOR INTERACT WITH BOOK
    *
    * */

    public List<Book> getByAuthor(String name );
    public List<Book> getByPage(int start , int size);
    public List<Book> getBySale(int start , int size);
    public Book getByName(String name);
    public Book getById(long id);
    public List<Book> getByYearPublished(int year);
    public List<Book> getByLanguage(String language);
    public List<Book> getByPrice(int lowerPrice,int higherPrice);
    public List<Book> getByNumberPage(int pageLow,int pageHigh);
    public List<Book> getBookByCategory(long category_id,int start,int size);
    public long saveBook(Book book);
    public long updateBook(Book book);
    public long deleteBook(Book book);



}
