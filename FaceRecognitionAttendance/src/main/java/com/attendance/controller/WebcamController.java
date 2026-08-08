package com.attendance.controller;

import com.attendance.face.Webcam;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/webcam")
@CrossOrigin("*")
public class WebcamController {

    @GetMapping("/open")
    public String openCamera() {

        Webcam webcam = new Webcam();

        webcam.openCamera();

        return "Camera Closed";
    }

}