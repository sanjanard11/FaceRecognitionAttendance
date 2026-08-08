package com.attendance.controller;

import com.attendance.entity.Student;
import com.attendance.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
@CrossOrigin("*")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/add")
    public Student addStudent(@RequestBody Student student) {

        System.out.println("Name = " + student.getName());
        System.out.println("USN = " + student.getUsn());
        System.out.println("Semester = " + student.getSemester());
        System.out.println("Email = " + student.getEmail());
        System.out.println("Department = " + student.getDepartment());

        return studentService.addStudent(student);
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/id/{id}")
    public Student getStudentById(@PathVariable int id) {
        return studentService.getStudentById(id);
    }

    @GetMapping("/count")
    public long getStudentCount() {
        return studentService.getStudentCount();
    }

    @PutMapping("/update")
    public Student updateStudent(@RequestBody Student student) {
        return studentService.updateStudent(student);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteStudent(@PathVariable int id) {
        studentService.deleteStudent(id);
        return "Student Deleted Successfully";
    }
    @GetMapping("/add-test")
    public String addTestStudent(){

        Student student = new Student();

        student.setName("Test Student");
        student.setUsn("4AD24CS999");
        student.setSemester(5);
        student.setEmail("test@gmail.com");
        student.setDepartment("CSE");

        studentService.addStudent(student);

        return "Student Added Successfully";
    }
    @GetMapping("/test")
    public String test(){

        return "Student Controller Working";
    }
}