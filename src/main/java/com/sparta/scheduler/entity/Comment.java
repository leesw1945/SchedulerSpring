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
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;

    @Column(name = "commentcontent", nullable = false)
    private String commentcontent;

    @Column(name = "userid", nullable = false)
    private String userid;

    @Column(name = "dateid", nullable = false)
    private BigInteger dateid;

    @Column(name = "date")
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "scheduler_id")
    private Scheduler scheduler;
}
