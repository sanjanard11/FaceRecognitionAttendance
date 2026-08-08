package com.attendance.Face;

import org.opencv.core.Core;
import org.springframework.stereotype.Service;

@Service
public class FaceRecognitionService {

    static {
        try {
            System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
            System.out.println("OpenCV Loaded Successfully");
        } catch (UnsatisfiedLinkError e) {
            System.out.println("OpenCV already loaded");
        }
    }


    public boolean compareFaces(String registeredPath, String capturedPath) {

        CompareFace compareFace = new CompareFace();

        return compareFace.compare(
                registeredPath,
                capturedPath
        );
    }
}