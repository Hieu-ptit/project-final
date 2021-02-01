package com.example.demo.controllers;

import com.example.demo.exceptions.ResponseDetail;
import com.example.demo.models.outs.DiaryDto;
import com.example.demo.services.business.DiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/diaries")
public class DiaryController {
    @Autowired
    private DiaryService diaryService;

    @PatchMapping("/{id}/favorite-diaries")
    public ResponseEntity<ResponseDetail<DiaryDto>> addToFavorite
            (@PathVariable int id) {
        return diaryService.favorite(id, true);
    }

    @PatchMapping("/{id}/unfavorite-diaries")
    public ResponseEntity<ResponseDetail<DiaryDto>> removeFromFavorite
            (@PathVariable int id) {
        return diaryService.favorite(id, false);
    }

}
