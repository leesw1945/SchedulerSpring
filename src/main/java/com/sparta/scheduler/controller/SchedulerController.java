package com.sparta.scheduler.controller;

import com.sparta.scheduler.dto.SchedulerRequestDto;
import com.sparta.scheduler.dto.SchedulerResponseDto;
import com.sparta.scheduler.service.SchedulerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SchedulerController {

    private final SchedulerService schedulerService;

    public SchedulerController(SchedulerService schedulerService){
        this.schedulerService = schedulerService;
    }

    // 생성 일정 등록
    @PostMapping("/scheduler")
    public SchedulerResponseDto createScheduler(@RequestBody SchedulerRequestDto requestDto){
        return schedulerService.createScheduler(requestDto);
    }

    // 선택 일정 조회
    @GetMapping("/scheduler/{schedulerId}")
    public Integer getSelectScheduler(@PathVariable Integer schedulerId){
        return schedulerService.getSelectScheduler(schedulerId);
    }

    // 전체 조회
    @GetMapping("/scheduler")
    public List<SchedulerResponseDto> getScheduler(){
        return schedulerService.getScheduler();
    }

    // 선택 일정 수정
    @PutMapping("/scheduler/{schedulerId}")
    public Integer updateScheduler(@PathVariable Integer schedulerId, @RequestBody SchedulerRequestDto requestDto){
        return schedulerService.updateScheduler(schedulerId, requestDto);
    }

    // 선택 일정 삭제
    @DeleteMapping("/scheduler/{schedulerId}")
    public Integer deleteScheduler(@PathVariable Integer schedulerId){
        return schedulerService.deleteScheduler(schedulerId);
    }


}
