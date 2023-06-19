package com.example.demo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Table(name = "Daily")
public class DailyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer maxTime;
    private String status;

    @Column(columnDefinition = "JSON")
    private String tasks;

    private String day;

    @Column(columnDefinition = "JSON")
    private String taskHistorys;

    @Column(columnDefinition = "JSON")
    private String timeline;

    // 생성자, 게터, 세터, 기타 메서드 생략
}

