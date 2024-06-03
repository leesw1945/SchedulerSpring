package com.sparta.scheduler.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.time.LocalDate;

@Entity
@Getter
@Table(name = "comments")
@NoArgsConstructor
public class Comment extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String commentcontent;

    private String userid;

    @ManyToOne
    @JoinColumn(name = "scheduler_id")
    private Scheduler scheduler;

    public Comment(String comment, String username, Scheduler scheduler) {
        this.commentcontent = commentcontent;
        this.userid = userid;
        this.scheduler = scheduler;
    }

    public void update(String commentcontent) {
        this.commentcontent = commentcontent;
    }
}
