package com.example.demo.services.mappers;

import com.example.demo.models.entities.DiaryEntity;
import com.example.demo.models.outs.DiaryDto;
import org.springframework.stereotype.Component;

@Component
public class DiaryMapper {
    public DiaryDto mapToDiaryDto(DiaryEntity diaryEntity){
        DiaryDto diaryDto = new DiaryDto();
        diaryDto.setId(diaryEntity.getId());
        diaryDto.setTitle(diaryEntity.getTitle());
        diaryDto.setContent(diaryEntity.getContent());
        diaryDto.setStatus(diaryEntity.isStatus());
        diaryDto.setStatusFavorite(diaryEntity.isStatusFavorite());
        diaryDto.setModifiedAt(diaryEntity.getModifiedAt());
        diaryDto.setCreateAt(diaryEntity.getCreateAt());
        diaryDto.setIdUser(diaryEntity.getIdUser());
        return diaryDto;
    }
}
