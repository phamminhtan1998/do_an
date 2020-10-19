package com.phamtan.do_an.dao.repositories;

import com.phamtan.do_an.dao.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository  extends JpaRepository<Book,Long> {
//    GET ALL BOOK BY AUTHOR ;
    List<Book> findByAuthor(String author);
//    GET BOOK WITH LIMIT BY PAGE
    @Query(value = "select * from book order by id desc  limit ?,?" ,nativeQuery = true)
    List<Book> findAllBookWithLimit(int start, int size);
//     GET BOOK IS SALED OFF
    @Query(value = "select * from book where sale !=0 order by id desc limit ?,?",nativeQuery = true)
    List<Book> findAllBookSale(int start, int size);
//    GET BOOK BY NAME
    Book findByName(String name );
//    GET BOOK YEAR PUBLISHED
    List<Book> findByyearPublish(int year);
//    GET BOOK BY LANGUAGE
    List<Book> findByLanguage(String language);
//    GET BOOK IN A RANGE OF PRICE
    @Query(value="select * from book where price > ? and price < ?",nativeQuery = true)
    List<Book> findAllBookInRangePrice(int lowerPrice,int higherPrice);
//  GET BOOK IN A NUMBERPAGE
    @Query(value="select * from book where number_page > ? and number_page < ?",nativeQuery = true)
    List<Book> findAllBookByNumberPage(int pageLow, int pageHigh);
//   GET ALL BOOK IN A CATEGORY
    @Query(value = "select distinct b.* from book b ,book_category,category where b.id=book_category.id_book and book_category.id_category and book_category.id_category =? limit ?,?",nativeQuery = true)
    List<Book> findAllBookInCategory(long id,int start, int size);

}
