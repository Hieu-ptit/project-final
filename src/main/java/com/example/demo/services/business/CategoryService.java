package com.example.demo.services.business;

import com.example.demo.exceptions.ResponseDetail;
import com.example.demo.models.ins.CategoryRequest;
import com.example.demo.models.outs.CategoryDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CategoryService {
    ResponseEntity<ResponseDetail<List<CategoryDto>>> readCategory();
    ResponseEntity<ResponseDetail<CategoryDto>> getCategoryByID(int id);
    ResponseEntity<ResponseDetail<CategoryDto>> createCategory(CategoryRequest categoryRequest);
    ResponseEntity<ResponseDetail<CategoryDto>> editCategory(CategoryRequest categoryRequest, int id);
    ResponseEntity<ResponseDetail<CategoryDto>> deleteCategory(int id);
}
