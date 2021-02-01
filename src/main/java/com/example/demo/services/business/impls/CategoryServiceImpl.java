package com.example.demo.services.business.impls;

import com.example.demo.exceptions.Response;
import com.example.demo.exceptions.ResponseDetail;
import com.example.demo.models.entities.CategoryEntity;
import com.example.demo.models.ins.CategoryRequest;
import com.example.demo.models.outs.CategoryDto;
import com.example.demo.repositories.CategoryRepository;
import com.example.demo.services.business.CategoryService;
import com.example.demo.services.mappers.CategoryMapper;
import com.example.demo.services.validators.CategoryValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryValidator categoryValidator;

    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private CategoryRepository categoryRepository;


    @Override
    public ResponseEntity<ResponseDetail<List<CategoryDto>>> readCategory() {
        List<CategoryEntity> categoryEntities = categoryRepository.findAll();
        List<CategoryDto> categoryDtos = categoryMapper.mapToListCategoryDto(categoryEntities);
        return Response.ok(categoryDtos);
    }

    @Override
    public ResponseEntity<ResponseDetail<CategoryDto>> getCategoryByID(int id) {
        CategoryEntity categoryEntity = categoryRepository.findById(id).orElse(null);
        if (categoryEntity == null)
            return Response.badRequest();
        CategoryDto categoryDto = categoryMapper.mapToCategoryDto(categoryEntity);
        return Response.ok(categoryDto);
    }


    @Override
    public ResponseEntity<ResponseDetail<CategoryDto>> createCategory(CategoryRequest categoryRequest) {
        ResponseEntity<ResponseDetail<CategoryDto>> validate = categoryValidator.validateCategory(categoryRequest);
        if (!validate.getStatusCode().is2xxSuccessful())
            return validate;
        CategoryEntity categoryEntity = categoryMapper.mapToCategoryEntity(categoryRequest);
        categoryEntity = categoryRepository.save(categoryEntity);
        CategoryDto categoryDto = categoryMapper.mapToCategoryDto(categoryEntity);
        return Response.ok(categoryDto);
    }

    @Override
    public ResponseEntity<ResponseDetail<CategoryDto>> editCategory(CategoryRequest categoryRequest, int id) {
        CategoryEntity categoryEntity = categoryRepository.findById(id).orElse(null);
        if (categoryEntity == null)
            return Response.badRequest();
        ResponseEntity<ResponseDetail<CategoryDto>> validate = categoryValidator.validateCategory(categoryRequest);
        if (!validate.getStatusCode().is2xxSuccessful())
            return validate;
        categoryEntity = categoryMapper.mapToCategoryEntity(categoryRequest, id);
        categoryEntity = categoryRepository.save(categoryEntity);
        CategoryDto categoryDto = categoryMapper.mapToCategoryDto(categoryEntity);
        return Response.ok(categoryDto);
    }

    @Override
    public ResponseEntity<ResponseDetail<CategoryDto>> deleteCategory(int id) {
        CategoryEntity categoryEntity = categoryRepository.findById(id).orElse(null);
        if(categoryEntity == null) {
            return Response.badRequest();
        }
        categoryRepository.delete(categoryEntity);
        return Response.ok();
    }

}
