package com.sparta.scheduler.service;

import com.sparta.scheduler.dto.CommentCreateRequestDto;
import com.sparta.scheduler.dto.CommentResponseDto;
import com.sparta.scheduler.entity.Comment;
import com.sparta.scheduler.entity.Scheduler;
import com.sparta.scheduler.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final SchedulerService schedulerService;

    @Transactional
    public CommentResponseDto save(long scheduleId, CommentCreateRequestDto request) {

        // DB에 일정이 존재하지 않는 경우
        Scheduler scheduler = schedulerService.findScheduler(scheduleId);
        Comment comment = commentRepository.save(new Comment(request.getCommentcontent(), request.getUserid(), scheduler));
        return CommentResponseDto.toDto(commentRepository.save(comment));
    }
}
