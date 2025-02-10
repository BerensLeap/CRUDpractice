package com.example.practice.practice3.repository;

import com.example.practice.practice1.entity.Memo;
import com.example.practice.practice3.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule,Long> {
}
