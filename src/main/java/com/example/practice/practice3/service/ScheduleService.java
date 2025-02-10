package com.example.practice.practice3.service;

import com.example.practice.practice1.repository.MemoRepository;
import com.example.practice.practice3.dto.ScheduleRequestDto;
import com.example.practice.practice3.dto.ScheduleResponseDto;
import com.example.practice.practice3.entity.Schedule;
import com.example.practice.practice3.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    @Transactional
    public ScheduleResponseDto save(ScheduleResponseDto dto) {
        Schedule schedule = new Schedule(dto.getContent());
        Schedule savedSchedule = scheduleRepository.save(schedule);
        return new ScheduleResponseDto(savedSchedule.getId(), savedSchedule.getContent());
    }

    @Transactional(readOnly = true)
    public List<ScheduleResponseDto> findAll() {
        List<Schedule> schedules = scheduleRepository.findAll();

        List<ScheduleResponseDto> dtos = new ArrayList<>();
        for (Schedule schedule : schedules) {
            dtos.add(new ScheduleResponseDto(schedule.getId(), schedule.getContent()));
        }
        return dtos;
    }

    @Transactional(readOnly = true)
    public ScheduleResponseDto findById(Long id) {
        Schedule schedule = scheduleRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Schedule not found")
        );
        return new ScheduleResponseDto(schedule.getId(), schedule.getContent());
    }

    @Transactional
    public ScheduleResponseDto update(Long id, ScheduleRequestDto dto) {
        Schedule schedule = scheduleRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Schedule not found")
        );
        schedule.update(dto.getContent());
        return new ScheduleResponseDto(schedule.getId(), schedule.getContent());
    }

    @Transactional
    public void deleteById(Long id) {
        if(!scheduleRepository.existsById(id)) {
            throw new IllegalArgumentException("Schedule not found");
        }
        scheduleRepository.deleteById(id);
    }
}
