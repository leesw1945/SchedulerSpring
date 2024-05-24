package com.sparta.scheduler.dto;

import lombok.Getter;

@Getter
public class SchedulerRequestDto {
    private String title;
    private String contents;
    private String manager;
    private String password;
}
