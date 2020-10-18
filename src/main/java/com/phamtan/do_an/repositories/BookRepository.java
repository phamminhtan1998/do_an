package com.example.demo.repositories;

import com.example.demo.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository

public interface BookRepository  extends JpaRepository<Book, Long> {
    //get all book by author
    List<Book> findByAuthor(String author);
    //get books with limit and start
    @Query(value = "select * from book order by id desc  limit ?,?" ,nativeQuery = true)
    List<Book> findAllBookWithLimit(int start, int size);
    //get all book is sale off
    @Query(value = "select * from book where sale !=0 order by id desc limit ?,?",nativeQuery = true)
    List<Book> findAllBookSale(int start, int size);
}
