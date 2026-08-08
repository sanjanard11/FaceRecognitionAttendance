package com.attendance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.attendance.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}