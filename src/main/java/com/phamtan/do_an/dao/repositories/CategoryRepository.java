package com.phamtan.do_an.dao.repositories;

import com.phamtan.do_an.dao.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository  extends JpaRepository<Category,Long> {
    //GET ALL THE CATEGORY OF A BOOK
    @Query(value = "select district c.* from book b ,book_category,category c where b.id=book_category.id_book and book_category.id_category and book_category.id_book =? ",nativeQuery = true)
    List<Category> findAllCategoryInBook(long id);
}
