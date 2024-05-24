package com.sparta.scheduler.dto;

import com.sparta.scheduler.entity.Scheduler;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class SchedulerResponseDto {

    private Long id;
    private String title;
    private String contents;
    private String manager;
    private LocalDateTime createAt;
    private LocalDateTime modifiedAt;

    public SchedulerResponseDto(Scheduler scheduler){
        this.id = scheduler.getId();
        this.title = scheduler.getTitle();
        this.contents = scheduler.getContents();
        this.manager = scheduler.getManager();
        this.createAt = scheduler.getCreatedAt();
        this.modifiedAt = scheduler.getModifiedAt();
    }
}
