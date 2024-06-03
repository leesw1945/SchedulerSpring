package com.sparta.scheduler.service;

import com.sparta.scheduler.dto.SchedulerRequestDto;
import com.sparta.scheduler.dto.SchedulerResponseDto;
import com.sparta.scheduler.entity.Scheduler;
import com.sparta.scheduler.repository.SchedulerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SchedulerService {

    private final SchedulerRepository schedulerRepository;

    public SchedulerService(SchedulerRepository schedulerRepository){
        this.schedulerRepository = schedulerRepository;
    }

    public SchedulerResponseDto createScheduler(SchedulerRequestDto requestDto){
        // RequestDto -> Entity
        Scheduler scheduler = new Scheduler(requestDto);

        // DB 저장
        Scheduler saveScheduler = schedulerRepository.save(scheduler);

        // Entity -> ResponseDto
        SchedulerResponseDto schedulerResponseDto = new SchedulerResponseDto(saveScheduler);

        return schedulerResponseDto;
    }

    public SchedulerResponseDto getScheduler(Long id) {

        Scheduler scheduler = findScheduler(id);
        return new SchedulerResponseDto(scheduler);
    }

    public List<SchedulerResponseDto> getAllScheduler(){
        // DB 조회
        return schedulerRepository.findAllByOrderByDateDesc().stream().map(SchedulerResponseDto::new).toList();
    }

    @Transactional
    public SchedulerResponseDto updateScheduler(long id, SchedulerRequestDto requestDto, String password){
        Scheduler scheduler = findScheduler(id);
        if (scheduler.getPassword().equals(password)){
            scheduler.update(requestDto);
        }
        else{
            throw new IllegalArgumentException("비밀번호를 틀렸습니다.");
        }
        return new SchedulerResponseDto(scheduler);
    }

    public Long deleteScheduler(Long id, String password){
        Scheduler scheduler = findScheduler(id);
        if (scheduler.getPassword().equals(password)){
            schedulerRepository.delete(scheduler);
        } else {
            throw new IllegalArgumentException("비밀번호를 틀렸습니다.");
        }
        return id;
    }

    protected Scheduler findScheduler(Long id){
        return schedulerRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("선택한 일정은 존재하지 않습니다.")
        );
    }
}
