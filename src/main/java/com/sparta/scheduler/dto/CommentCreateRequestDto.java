package com.sparta.scheduler.dto;

import lombok.Getter;

@Getter
public class CommentCreateRequestDto {
    private String commentcontent;
    private String userid;

    public CommentCreateRequestDto(String comment, String username) {
        this.commentcontent = commentcontent;
        this.userid = userid;
    }
}
