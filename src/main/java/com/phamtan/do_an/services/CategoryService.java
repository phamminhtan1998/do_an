package com.phamtan.do_an.services;

import com.phamtan.do_an.dao.entities.Book;
import com.phamtan.do_an.dao.entities.Category;

import java.util.List;

public interface CategoryService {

    /*
    *
    * ALL API METHO
    *
    * */

    //get all category we had
    public List<Category> getCategory();

    //get all category of a book
    public List<Category> getCategoryByBook(Long idBook);

    //add a category
    public long addCategory(Category category);

    //update a category
    public long updateCategory(Category category);

    //delete a category
    public long deleteCategory(Category category);
}
