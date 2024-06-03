package com.sparta.scheduler.dto;

import lombok.Getter;

@Getter
public class CommentUpdateRequestDto {

    private String userid;
    private String commentcontent;

    public CommentUpdateRequestDto(String userid, String commentcontent) {
        this.userid = userid;
        this.commentcontent = commentcontent;
    }
}
