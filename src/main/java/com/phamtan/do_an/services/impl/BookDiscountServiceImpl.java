package com.phamtan.do_an.services.impl;

import com.phamtan.do_an.dao.entities.Book_Discount;
import com.phamtan.do_an.dao.entities.Order;
import com.phamtan.do_an.dao.repositories.BookDiscountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookDiscountServiceImpl {

    @Autowired
    private BookDiscountRepository bookDiscountRepository;

    public List<Book_Discount> getAll(){
        List<Book_Discount> book_discounts  =  bookDiscountRepository.findAll();
        if(book_discounts.size()>0&&book_discounts!=null){
            return book_discounts;
        }
        return null;
    }

    public Book_Discount getById(long id ){
        Book_Discount book_discount = bookDiscountRepository.findById(id).get();
        if(book_discount!=null){
            return book_discount;
        }
        return null ;
    }
    public long save(Book_Discount book_discount ){
        Book_Discount book_discount1 = bookDiscountRepository.save(book_discount);
        if(book_discount1!=null){
            return book_discount1.getId();
        }
        return 0 ;
    }
    public long update(Book_Discount book_discount ){
        Book_Discount book_discount1 = bookDiscountRepository.save(book_discount);
        if(book_discount1!=null){
            return book_discount1.getId();
        }
        return 0 ;
    }
    public long delete(long id){
        bookDiscountRepository.deleteById(id);
        return  id;
    }
}
