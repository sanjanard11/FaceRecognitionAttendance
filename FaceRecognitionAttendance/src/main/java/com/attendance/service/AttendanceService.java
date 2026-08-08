package com.attendance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attendance.entity.Attendance;
import com.attendance.repository.AttendanceRepository;

@Service
public class AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;


    // Mark Attendance
    public Attendance markAttendance(Attendance attendance) {

        return attendanceRepository.save(attendance);

    }


    // Get All Attendance
    public List<Attendance> getAllAttendance() {

        return attendanceRepository.findAll();

    }


    // Delete Attendance
    public void deleteAttendance(int id) {

        attendanceRepository.deleteById(id);

    }


    // Today's Attendance Count
    public long countAttendance() {

        String today = java.time.LocalDate.now().toString();

        return attendanceRepository.countByDate(today);

    }

}