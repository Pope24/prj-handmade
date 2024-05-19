package com.configuration.opencv;

import org.opencv.core.*;
import org.opencv.features2d.BFMatcher;
import org.opencv.features2d.ORB;
import org.opencv.imgcodecs.Imgcodecs;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import javax.servlet.http.Part;
import java.util.ArrayList;
import java.util.List;

public class AlgCompareImage {
    static {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    }
    private static Mat bufferedImageToMat(BufferedImage bi) {
        Mat mat = new Mat(bi.getHeight(), bi.getWidth(), CvType.CV_8UC3);
        byte[] data = ((DataBufferByte) bi.getRaster().getDataBuffer()).getData();
        mat.put(0, 0, data);
        return mat;
    }

    private static Mat loadImage(String pathOrUrl) throws IOException {
        if (pathOrUrl.startsWith("http://") || pathOrUrl.startsWith("https://")) {
            URL url = new URL(pathOrUrl);
            BufferedImage img = ImageIO.read(url);
            return bufferedImageToMat(img);
        } else {
            return Imgcodecs.imread(pathOrUrl, Imgcodecs.IMREAD_GRAYSCALE);
        }
    }

    public static boolean compareTwoImage(String imageUpload, String link2) throws IOException {
        Mat image1 = loadImage(imageUpload);
        Mat image2 = loadImage(link2);

        // Phát hiện các điểm đặc trưng bằng ORB
        ORB orb = ORB.create();
        MatOfKeyPoint keypoints1 = new MatOfKeyPoint();
        MatOfKeyPoint keypoints2 = new MatOfKeyPoint();
        Mat descriptors1 = new Mat();
        Mat descriptors2 = new Mat();

        orb.detectAndCompute(image1, new Mat(), keypoints1, descriptors1);
        orb.detectAndCompute(image2, new Mat(), keypoints2, descriptors2);

        // Sử dụng BFMatcher với NORM_HAMMING
        BFMatcher bfMatcher = BFMatcher.create(BFMatcher.BRUTEFORCE_HAMMING, true);
        MatOfDMatch matches = new MatOfDMatch();
        bfMatcher.match(descriptors1, descriptors2, matches);

        // Lọc các điểm đặc trưng tốt
        List<DMatch> matchList = matches.toList();
        double maxDist = 0;
        double minDist = 100;

        for (DMatch match : matchList) {
            double dist = match.distance;
            if (dist < minDist) minDist = dist;
            if (dist > maxDist) maxDist = dist;
        }

        List<DMatch> goodMatches = new ArrayList<>();
        for (DMatch match : matchList) {
            if (match.distance <= Math.max(2 * minDist, 30.0)) {
                goodMatches.add(match);
            }
        }
        double similarityScore = goodMatches.size() / (double) matchList.size();
        if (similarityScore > 0.1) {
            return true;
        }
        return false;
    }
}
