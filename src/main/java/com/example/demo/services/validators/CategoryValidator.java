package com.example.demo.services.validators;

import com.example.demo.exceptions.Response;
import com.example.demo.exceptions.ResponseDetail;
import com.example.demo.models.ins.CategoryRequest;
import com.example.demo.utils.StringResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class CategoryValidator {
    public <T> ResponseEntity<ResponseDetail<T>> validateCategory(CategoryRequest categoryRequest) {
        if (categoryRequest.getDescription() == null || categoryRequest.getDescription().isEmpty())
            return Response.badRequest(StringResponses.DESCRIPTION_IS_NULL);

        if (categoryRequest.getName() == null || categoryRequest.getName().isEmpty())
            return Response.badRequest(StringResponses.NAME_IS_NULL);
        return Response.ok();
    }
}
