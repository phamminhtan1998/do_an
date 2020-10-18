package com.example.demo.services.impl;

import com.example.demo.entities.Book;
import com.example.demo.entities.Category;
import com.example.demo.repositories.CategoryRepository;
import com.example.demo.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository ;
    @Override
    public List<Category> getCategory() {
        List<Category> categories = categoryRepository.findAll();
        if(categories.size()>0) return categories;
        return null;
    }

    @Override
    public List<Category> getCategoryByBook(Long idBook) {
        return null;
    }

    @Override
    public List<Book> getBooksByCategory(Long idCategory) {
        return null;
    }

    @Override
    public long addCategory(Category category) {
        try {
            categoryRepository.save(category);
            return category.getId();
        }
        catch (Exception e){
            e.printStackTrace();
            return 0 ;
        }
    }

    @Override
    public long updateCategory(Category category) {
        if (!categoryRepository.existsById(category.getId())){
            return 0;
        }
        else {
            try {
                categoryRepository.save(category);
                return category.getId();
            } catch (Exception e) {
                e.printStackTrace();
                return 0;
            }
        }
    }

    @Override
    public long deleteCategory(Category category) {
        if (!categoryRepository.existsById(category.getId()))
            return 0;
        else{
            categoryRepository.delete(category);
            return category.getId();
        }
    }
}
