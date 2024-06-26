package com.Ecomence.Ecommece.Controllers;

import com.Ecomence.Ecommece.DTO.CategoryDTO;
import com.Ecomence.Ecommece.Entities.Category;
import com.Ecomence.Ecommece.Services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    private final CategoryService categoryService;

    @PostMapping("/addCategory")
    public ResponseEntity<Category> createCategory(@RequestBody CategoryDTO categoryDTO) {
        Category category = this.categoryService.createCategory(categoryDTO);
        return new ResponseEntity<>(category, HttpStatus.CREATED);
    }
    @GetMapping("/allCategories")
    public ResponseEntity<List<Category>> categoryList(){
        return new ResponseEntity<>(this.categoryService.categoryList(), HttpStatus.OK);
    }
}
