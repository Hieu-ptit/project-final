package com.example.demo.controllers;

import com.example.demo.exceptions.ResponseDetail;
import com.example.demo.models.ins.CategoryRequest;
import com.example.demo.models.outs.CategoryDto;
import com.example.demo.services.business.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<ResponseDetail<List<CategoryDto>>> read() {
        return categoryService.readCategory();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDetail<CategoryDto>> findCategoryById(@PathVariable int id) {
        return categoryService.getCategoryByID(id);
    }

    @PostMapping
    public ResponseEntity<ResponseDetail<CategoryDto>> postCategory(@RequestBody CategoryRequest categoryRequest) {
        return categoryService.createCategory(categoryRequest);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ResponseDetail<CategoryDto>> updateCategoryById(@RequestBody CategoryRequest categoryRequest, @PathVariable("id") int id) {
        return categoryService.editCategory(categoryRequest, id);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<ResponseDetail<CategoryDto>> deleteCategoryById(@PathVariable(value = "id") int id) {
        return categoryService.deleteCategory(id);
    }

}
