package com.sparta.scheduler.controller;

import com.sparta.scheduler.dto.CommentCreateRequestDto;
import com.sparta.scheduler.dto.CommentResponseDto;
import com.sparta.scheduler.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/scheduler/{schedulerId}/comment")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping
    public ResponseEntity<CommentResponseDto> create(
            @PathVariable(name = "schedulerId") long schedulerId,
            @RequestBody CommentCreateRequestDto commentRequestDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(
                commentService.save(schedulerId, commentRequestDto)
        );
    }

}
