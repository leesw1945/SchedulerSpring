package com.sparta.scheduler.entity;

import com.sparta.scheduler.dto.SchedulerRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Table(name = "scheduler")
@NoArgsConstructor
public class Scheduler extends  Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title",nullable = false, length = 500)
    private String title;

    @Column(name = "contents",nullable = false)
    private String contents;

    @Column(name = "manager",nullable = false)
    private String manager;

    @Column(name = "password",nullable = false)
    private String password;

    @Column(name = "date")
    private LocalDate date;

    public Scheduler(SchedulerRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.contents = requestDto.getContents();
        this.manager = requestDto.getManager();
        this.password = requestDto.getPassword();
    }

    public void update(SchedulerRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.contents = requestDto.getContents();
        this.manager = requestDto.getManager();
    }

    @OneToMany(mappedBy = "scheduler")
    private List<Comment> comments;

}
