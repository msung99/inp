package com.example.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/daily")
public class DailyController {
    private final DailyService dailyService;

    public DailyController(DailyService dailyService) {
        this.dailyService = dailyService;
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadDaily(@RequestBody List<DailyRequest> dailyRequests) {
        dailyService.uploadDaily(dailyRequests);
        return ResponseEntity.ok("Daily들의 업로드에 성공했습니다!");
    }

    @GetMapping
    public ResponseEntity<List<DailyEntity>>getDailyList(){
        return ResponseEntity.ok(dailyService.getDailyList());
    }

}