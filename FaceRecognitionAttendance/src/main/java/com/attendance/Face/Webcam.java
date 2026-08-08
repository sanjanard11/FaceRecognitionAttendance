package com.attendance.face;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.highgui.HighGui;
import org.opencv.videoio.VideoCapture;

public class Webcam {

    static {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    }

    public void openCamera() {

        VideoCapture camera = new VideoCapture(0);

        if (!camera.isOpened()) {
            System.out.println("Camera not detected");
            return;
        }

        System.out.println("Camera opened successfully");

        Mat frame = new Mat();

        while (true) {

            camera.read(frame);

            if (!frame.empty()) {
                HighGui.imshow("Face Registration Camera", frame);
            }

            if (HighGui.waitKey(30) == 27) {
                break;
            }
        }

        camera.release();
        HighGui.destroyAllWindows();
    }


    public static void main(String[] args) {

        Webcam webcam = new Webcam();
        webcam.openCamera();

    }
}