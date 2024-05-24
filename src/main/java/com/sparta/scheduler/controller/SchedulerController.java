package com.sparta.scheduler.controller;

import com.sparta.scheduler.dto.SchedulerRequestDto;
import com.sparta.scheduler.dto.SchedulerResponseDto;
import com.sparta.scheduler.service.SchedulerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class SchedulerController {

    private final SchedulerService schedulerService;


    // 생성 일정 등록
    @PostMapping("/scheduler")
    public SchedulerResponseDto createScheduler(@RequestBody SchedulerRequestDto requestDto){
        return schedulerService.createScheduler(requestDto);
    }

    // 선택 일정 조회
    @GetMapping("/scheduler/{schedulerId}")
    public SchedulerResponseDto getScheduler(@PathVariable long schedulerId){
        return schedulerService.getScheduler(schedulerId);
    }

    // 전체 조회
    @GetMapping("/scheduler")
    public List<SchedulerResponseDto> getScheduler(){
        return schedulerService.getAllScheduler();
    }

    // 선택 일정 수정
    @PutMapping("/scheduler/{schedulerId}")
    public SchedulerResponseDto updateScheduler(@PathVariable Long schedulerId, @RequestBody SchedulerRequestDto requestDto){
        return schedulerService.updateScheduler(schedulerId, requestDto, requestDto.getPassword());
    }

    // 선택 일정 삭제
    @DeleteMapping("/scheduler/{schedulerId}")
    public Long deleteScheduler(@PathVariable Long schedulerId, @RequestBody SchedulerRequestDto requestDto){
        return schedulerService.deleteScheduler(schedulerId, requestDto.getPassword());
    }


}
