package com.example.demo.services;

import com.example.demo.entities.Book;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public interface BookService {

    //get all books
   public List<Book> getAllBooks();

   //get all books with pageble
   public List<Book> getBookWithLimit(int start,int size);

   //get book by book id
   public Book getBookById( long id );

   //get book is sale
   public List<Book> getBookSale( int start,int size );

   //add new book to database
   public long addBook(Book book);

   // update properties of a book
   public long updateBook(Book book);

   //delete a book in database
   public long deleteBook(Book book);

   //get all book of a author
   public List<Book> getBookByAuthor(String authorName);


}
