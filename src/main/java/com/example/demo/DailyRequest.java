package com.example.demo;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Getter @Setter
public class DailyRequest {
    private Long id;
    private Integer maxTime;
    private String status;
    private Map<String, Integer> tasks;
    private String day;
    private Map<String, List<TaskHistoryRequest>> taskHistorys;
    private List<Integer> timeline;

    // 생성자, 게터, 세터, 기타 메서드 생략
}
