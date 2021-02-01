package com.example.demo.services.business.impls;

import com.example.demo.exceptions.Response;
import com.example.demo.exceptions.ResponseDetail;
import com.example.demo.models.entities.DiaryEntity;
import com.example.demo.models.outs.DiaryDto;
import com.example.demo.repositories.DiaryRepository;
import com.example.demo.repositories.UserRepository;
import com.example.demo.services.business.DiaryService;
import com.example.demo.services.mappers.DiaryMapper;
import com.example.demo.services.validators.DiaryValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DiaryServiceImpl implements DiaryService {
    @Autowired
    private DiaryMapper diaryMapper;

    @Autowired
    private DiaryRepository diaryRepository;

    @Override
    public ResponseEntity<ResponseDetail<DiaryDto>> favorite(Integer id, boolean isFavorite) {
        DiaryEntity diaryEntity = diaryRepository.findById(id).orElse(null);
        if(diaryEntity == null) {
            return Response.badRequest();
        }
        diaryEntity.setStatusFavorite(isFavorite);
        diaryRepository.save(diaryEntity);
        DiaryDto diaryDto = diaryMapper.mapToDiaryDto(diaryEntity);
        return Response.ok(diaryDto);
    }
}
