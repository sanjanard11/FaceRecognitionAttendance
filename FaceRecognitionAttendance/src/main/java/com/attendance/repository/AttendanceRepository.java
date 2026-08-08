package com.attendance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.attendance.entity.Attendance;

public interface AttendanceRepository extends JpaRepository<Attendance, Integer> {

    long countByDate(String date);

}