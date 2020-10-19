package com.phamtan.do_an.controller.category;

import com.phamtan.do_an.dao.entities.Category;
import com.phamtan.do_an.services.impl.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/categories")
public class CategoryController {
    @Autowired
    private CategoryServiceImpl categoryService;

    /*
     *
     *  ALL THE METHOD TO INTERACT WITH THE CATEGORY
     *
     * */
    @GetMapping
    public List<Category> getAllCategory(){
        List<Category>categories =  categoryService.getCategory();
        return categories ;
    }
    @GetMapping(value = "book-id/{id}")
    public List<Category> getCategoryByBook(@PathVariable(name = "id") Long id){
        List<Category>categories =  categoryService.getCategoryByBook(id);
        return categories ;
    }
    @PostMapping
    public long addCategory(Category category){
        return  categoryService.addCategory(category);
    }
    @PatchMapping
    public long updateCategory(Category category){
        return  categoryService.updateCategory(category);
    }
    @DeleteMapping
    public long deleteCategory(Category category){
        return categoryService.deleteCategory(category);
    }


}
