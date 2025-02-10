package com.example.practice.practice1.repository;

import com.example.practice.practice1.entity.Memo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemoRepository extends JpaRepository<Memo,Long> {
}
