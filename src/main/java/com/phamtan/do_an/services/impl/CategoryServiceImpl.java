package com.phamtan.do_an.services.impl;



import com.phamtan.do_an.dao.entities.Category;
import com.phamtan.do_an.dao.repositories.CategoryRepository;
import com.phamtan.do_an.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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
        List<Category> categories = categoryRepository.findAllCategoryInBook(idBook);
        if(categories.size()>0) return categories;
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
