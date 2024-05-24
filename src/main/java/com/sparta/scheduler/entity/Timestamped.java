package com.sparta.scheduler.entity;

import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
// jpa 엔티티 클래스들이 해당 추상 클래스(Timestamped)를 상속할 경우
// 추상 클래스에 선언한 멤버 변수들을 컬럼으로 인식하게 해준다.
// createdAt, modifiedAt
// (추상 클래스가 아니어도 상관은 없지만 이 클래스 자체를 객체로 생성할 일 없어서 추상 클래스를 쓴다.)
@MappedSuperclass
// 해당 클래스에 Auditing 기능을 포함 시켜준다.
@EntityListeners(AuditingEntityListener.class)
public class Timestamped {

    // 엔티티 객체가 생성되어서 저장될 때 시간 값이 자동 저장된다.
    @CreatedDate
    // 최초 시간만 저장되고 수정되면 안 되기 때문에 updatable 옵션을 false로 둔다.
    @Column(updatable = false)
    @jakarta.persistence.Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime createdAt;

    // 조회한 엔티티 객체 값을 변경할 때 변경된 시간이 자동 저장된다.
    @LastModifiedDate
    @Column
    // 자바의 Date, Calendar 타입같이 날짜 데이터를 매핑할 때 사용한다.
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime modifiedAt;
}
