package com.attendance.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.attendance.entity.Student;
import com.attendance.repository.StudentRepository;

@RestController
@RequestMapping("/face")
@CrossOrigin(origins = "*")
public class FaceController {

    @Autowired
    private StudentRepository studentRepository;


    @PostMapping("/registerFace")
    public String registerFace(
            @RequestParam("studentId") int studentId,
            @RequestParam("image") MultipartFile image) {

        try {

            // Find student
            Student student = studentRepository.findById(studentId)
                    .orElse(null);

            if (student == null) {
                return "Student not found";
            }

            // Create faces folder
            String folderPath = System.getProperty("user.dir")
                    + "/src/main/resources/static/faces/";

            File folder = new File(folderPath);

            if (!folder.exists()) {
                folder.mkdirs();
            }

            // File name
            String fileName = studentId + ".png";

            // Full file path
            File file = new File(folder, fileName);

            // Save image
            image.transferTo(file);

            // Save path in database
            student.setImagePath("/faces/" + fileName);

            studentRepository.save(student);

            System.out.println("Face saved for student: " + student.getName());
            System.out.println("Image path: " + student.getImagePath());

            return "Face Registered Successfully";

        } catch (IOException e) {

            e.printStackTrace();

            return "Error saving face";
        }
    }


    @GetMapping("/count")
    public long getFaceCount() {

        File folder = new File(
                System.getProperty("user.dir")
                        + "/src/main/resources/static/faces/"
        );

        if (!folder.exists()) {
            return 0;
        }

        File[] files = folder.listFiles(
                (dir, name) -> name.toLowerCase().endsWith(".png")
        );

        return files == null ? 0 : files.length;
    }
}