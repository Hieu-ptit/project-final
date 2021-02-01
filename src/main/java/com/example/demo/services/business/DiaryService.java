package com.example.demo.services.business;

import com.example.demo.exceptions.ResponseDetail;
import com.example.demo.models.outs.DiaryDto;
import org.springframework.http.ResponseEntity;

public interface DiaryService {
    ResponseEntity<ResponseDetail<DiaryDto>> favorite(Integer id, boolean isFavorite);

}
