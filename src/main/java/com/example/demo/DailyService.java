package com.example.demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DailyService {
    private final DailyRepository dailyRepository;

    public DailyService(DailyRepository dailyRepository) {
        this.dailyRepository = dailyRepository;
    }

    public void uploadDaily(List<DailyRequest> dailyRequests) {
        List<DailyEntity> dailies = dailyRequests.stream()
                .map(this::convertToDailyEntity)
                .collect(Collectors.toList());
        dailyRepository.saveAll(dailies);
    }

    private DailyEntity convertToDailyEntity(DailyRequest dailyRequest) {
        DailyEntity daily = new DailyEntity();
        daily.setMaxTime(dailyRequest.getMaxTime());
        daily.setStatus(dailyRequest.getStatus());
        daily.setTasks(convertToJson(dailyRequest.getTasks()));
        daily.setDay(dailyRequest.getDay());
        daily.setTaskHistorys(convertToJson(dailyRequest.getTaskHistorys()));
        daily.setTimeline(convertToJson(dailyRequest.getTimeline()));
        return daily;
    }

    private String convertToJson(Object object) {
        try {
            return new ObjectMapper().writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error converting object to JSON: " + e.getMessage(), e);
        }
    }

    @Transactional(readOnly = true)
    public List<DailyEntity> getDailyList(){
        List<DailyEntity> dailyEntityList = dailyRepository.findAll();
        return dailyEntityList;
    }
}
