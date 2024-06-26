package com.Ecomence.Ecommece.Services;

import com.Ecomence.Ecommece.DTO.CategoryDTO;
import com.Ecomence.Ecommece.Entities.Category;
import com.Ecomence.Ecommece.Repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;
    public Category createCategory(CategoryDTO categoryDTO){
        Category category = new Category();
        category.setName(categoryDTO.getName());
        category.setDescription(categoryDTO.getDescription());
        categoryRepository.save(category);
        return category;
    }
    public List<Category> categoryList(){
        return this.categoryRepository.findAll();
    }

}
