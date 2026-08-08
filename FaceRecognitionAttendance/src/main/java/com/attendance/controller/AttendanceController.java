package com.attendance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.attendance.entity.Attendance;
import com.attendance.service.AttendanceService;

@RestController
@RequestMapping("/attendance")
@CrossOrigin("*")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;


    // Mark Attendance
    @PostMapping("/mark")
    public Attendance markAttendance(@RequestBody Attendance attendance) {

        return attendanceService.markAttendance(attendance);

    }


    // View All Attendance
    @GetMapping
    public List<Attendance> getAllAttendance() {

        return attendanceService.getAllAttendance();

    }


    // Count Attendance
    @GetMapping("/count")
    public long countAttendance() {

        return attendanceService.countAttendance();

    }


    // Delete Attendance
    @DeleteMapping("/delete/{id}")
    public String deleteAttendance(@PathVariable int id) {

        attendanceService.deleteAttendance(id);

        return "Attendance Deleted Successfully";

    }

}