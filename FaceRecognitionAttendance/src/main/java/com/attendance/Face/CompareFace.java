package com.attendance.Face;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class CompareFace {

    public boolean compare(String registeredPath, String capturedPath) {

        System.out.println("Comparing faces...");

        try {

            BufferedImage registeredImage =
                    ImageIO.read(new File(registeredPath));

            BufferedImage capturedImage =
                    ImageIO.read(new File(capturedPath));


            if (registeredImage == null || capturedImage == null) {
                System.out.println("Image not found");
                return false;
            }


            Mat registered = bufferedImageToMat(registeredImage);
            Mat captured = bufferedImageToMat(capturedImage);


            Imgproc.resize(
                    captured,
                    captured,
                    new Size(
                            registered.width(),
                            registered.height()
                    )
            );


            Mat difference = new Mat();

            Core.absdiff(
                    registered,
                    captured,
                    difference
            );


            Scalar mean = Core.mean(difference);


            double score =
                    mean.val[0] +
                            mean.val[1] +
                            mean.val[2];


            System.out.println("Difference Score: " + score);


            return score < 100;


        } catch (Exception e) {

            e.printStackTrace();
            return false;
        }
    }



    private Mat bufferedImageToMat(BufferedImage image) {

        Mat mat = new Mat(
                image.getHeight(),
                image.getWidth(),
                org.opencv.core.CvType.CV_8UC3
        );


        byte[] data =
                ((java.awt.image.DataBufferByte)
                        image.getRaster()
                                .getDataBuffer())
                        .getData();


        mat.put(
                0,
                0,
                data
        );


        return mat;
    }
}