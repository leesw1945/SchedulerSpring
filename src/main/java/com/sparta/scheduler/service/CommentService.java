package com.sparta.scheduler.service;

import com.sparta.scheduler.dto.CommentCreateRequestDto;
import com.sparta.scheduler.dto.CommentResponseDto;
import com.sparta.scheduler.dto.CommentUpdateRequestDto;
import com.sparta.scheduler.entity.Comment;
import com.sparta.scheduler.entity.Scheduler;
import com.sparta.scheduler.exception.DataNotFoundException;
import com.sparta.scheduler.repository.CommentRepository;
import com.sparta.scheduler.repository.SchedulerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final SchedulerService schedulerService;
    private final SchedulerRepository schedulerRepository;

    @Transactional
    public CommentResponseDto save(Long scheduleId, CommentCreateRequestDto request) {

        // DB에 일정이 존재하지 않는 경우
        Scheduler scheduler = schedulerService.findScheduler(scheduleId);
        Comment comment = commentRepository.save(new Comment(request.getCommentcontent(), request.getUserid(), scheduler));
        return CommentResponseDto.toDto(commentRepository.save(comment));
    }

    @Transactional
    public CommentResponseDto update(Long schedulerId, Long commentId, CommentUpdateRequestDto commentUpdateRequestDto) {

        // DB에 일정이 존재하지 않는 경우
        schedulerRepository.findById(schedulerId)
                .orElseThrow(() -> new IllegalArgumentException("해당 id에 맞는 일정 데이터가 없습니다. 아이디 : " + schedulerId));

        // 해당 댓글이 DB에 존재하지 않는 경우
        Comment comment = commentRepository.findById(BigInteger.valueOf(commentId))
                .orElseThrow(() -> new DataNotFoundException("해당 댓글이 DB에 존재하지 않습니다."));

        // 사용자가 일치하지 않는 경우
        if (!Objects.equals(comment.getUserid(), commentUpdateRequestDto.getUserid())) {
            throw new IllegalArgumentException("작성자만 수정할 수 있습니다.");
        }

        comment.update(commentUpdateRequestDto.getCommentcontent());
        return CommentResponseDto.toDto(comment);
    }

}
