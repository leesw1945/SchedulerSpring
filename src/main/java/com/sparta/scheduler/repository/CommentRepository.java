package com.sparta.scheduler.repository;

import com.sparta.scheduler.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface CommentRepository extends JpaRepository<Comment, BigInteger> {
}
