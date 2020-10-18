package com.example.demo.services;

import com.example.demo.entities.Book;
import com.example.demo.entities.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {
    //get all category we had
    public List<Category> getCategory();

    //get all category of a book
    public List<Category> getCategoryByBook(Long idBook);

    //get all book of a category
    public List<Book> getBooksByCategory(Long idCategory);

    //add a category
    public long addCategory(Category category);

    //update a category
    public long updateCategory(Category category);

    //delete a category
    public long deleteCategory(Category category);
}
