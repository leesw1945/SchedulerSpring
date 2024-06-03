package com.sparta.scheduler.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sparta.scheduler.entity.Comment;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CommentResponseDto {

    private Long id;
    private String commentcontent;
    private String userid;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;
    private Long schedulerId;

    public CommentResponseDto(Long id, String commentcontent, String userid, Long schedulerId, LocalDateTime createdAt) {
        this.id = id;
        this.commentcontent = commentcontent;
        this.userid = userid;
        this.schedulerId = schedulerId;
        this.createdAt = createdAt;
    }

    public static CommentResponseDto toDto(Comment comment) {
        return new CommentResponseDto(
                comment.getId(),
                comment.getCommentcontent(),
                comment.getUserid(),
                comment.getScheduler().getId(),
                comment.getCreatedAt()
        );
    }

}
