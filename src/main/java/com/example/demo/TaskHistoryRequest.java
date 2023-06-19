package com.example.demo;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
public class TaskHistoryRequest {
    private String startDate;
    private String endDate;

    // 생성자, 게터, 세터, 기타 메서드 생략
}
