package com.phamtan.do_an.dao.repositories;

import com.phamtan.do_an.dao.entities.Book_Discount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookDiscountRepository  extends JpaRepository<Book_Discount,Long> {
}
