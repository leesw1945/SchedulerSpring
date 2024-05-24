package com.sparta.scheduler.entity;

import com.sparta.scheduler.dto.SchedulerRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Table(name = "scheduler")
@NoArgsConstructor
public class Scheduler extends  Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title",nullable = true, length = 500)
    private String title;

    @Column(name = "contents",nullable = true)
    private String contents;

    @Column(name = "manager",nullable = true)
    private String manager;

    @Column(name = "password",nullable = true)
    private String password;

    @Column(name = "date", nullable = true)
    private LocalDate date;

    public Scheduler(SchedulerRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.contents = requestDto.getContents();
        this.manager = requestDto.getManager();
        this.password = requestDto.getPassword();
        this.date = LocalDate.now();
    }

    public void update(SchedulerRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.contents = requestDto.getContents();
        this.manager = requestDto.getManager();
    }

}
