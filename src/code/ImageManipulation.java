package code;

import image.APImage;
import image.Pixel;

public class ImageManipulation {

    /** CHALLENGE 0: Display Image
     *  Write a statement that will display the image in a window
     */
    public static void main(String[] args) {
        String a = "cyberpunk2077.jpg";
        grayScale(a);
        blackAndWhite(a);
        edgeDetection(a, 16);
        APImage i = new APImage("cyberpunk2077.jpg");
        i.draw();
    }

    /** CHALLENGE ONE: Grayscale
     *
     * INPUT: the complete path file name of the image
     * OUTPUT: a grayscale copy of the image
     *
     * To convert a colour image to grayscale, we need to visit every pixel in the image ...
     * Calculate the average of the red, green, and blue components of the pixel.
     * Set the red, green, and blue components to this average value. */
    public static void grayScale(String pathOfFile) {
        APImage i = new APImage(pathOfFile);
        int y = i.getHeight();
        int x = i.getWidth();
        for (int a = 0; a<x-1; a++){
            for (int b = 0; b<y-1; b++) {
                Pixel xyz = i.getPixel(a,b);
                int r = xyz.getRed();
                int bl = xyz.getBlue();
                int g = xyz.getGreen();
                int avg = (r+bl+g)/3;
                xyz.setBlue(avg);
                xyz.setRed(avg);
                xyz.setGreen(avg);
            }
        }
        i.draw();
    }

    /** A helper method that can be used to assist you in each challenge.
     * This method simply calculates the average of the RGB values of a single pixel.
     * @param pixel
     * @return the average RGB value
     */
    private static int getAverageColour(Pixel pixel) {
        int r = pixel.getRed();
        int b = pixel.getBlue();
        int g = pixel.getGreen();
        return (r+b+g)/3;
    }

    /** CHALLENGE TWO: Black and White
     *
     * INPUT: the complete path file name of the image
     * OUTPUT: a black and white copy of the image
     *
     * To convert a colour image to black and white, we need to visit every pixel in the image ...
     * Calculate the average of the red, green, and blue components of the pixel.
     * If the average is less than 128, set the pixel to black
     * If the average is equal to or greater than 128, set the pixel to white */
    public static void blackAndWhite(String pathOfFile) {
        APImage i = new APImage(pathOfFile);
        for (int a = 0; a<i.getWidth()-1; a++){
            for (int b = 0; b<i.getHeight()-1; b++){
                Pixel p = i.getPixel(a,b);
                int avg = getAverageColour(p);
                if (avg >=128){
                    p.setBlue(360);
                    p.setGreen(360);
                    p.setRed(360);
                }
                else {
                    p.setBlue(0);
                    p.setGreen(0);
                    p.setRed(0);
                }
            }
        }
        i.draw();
    }

    /** CHALLENGE Three: Edge Detection
     *
     * INPUT: the complete path file name of the image
     * OUTPUT: an outline of the image. The amount of information will correspond to the threshold.
     *
     * Edge detection is an image processing technique for finding the boundaries of objects within images.
     * It works by detecting discontinuities in brightness. Edge detection is used for image segmentation
     * and data extraction in areas such as image processing, computer vision, and machine vision.
     *
     * There are many different edge detection algorithms. We will use a basic edge detection technique
     * For each pixel, we will calculate ...
     * 1. The average colour value of the current pixel
     * 2. The average colour value of the pixel to the left of the current pixel
     * 3. The average colour value of the pixel below the current pixel
     * If the difference between 1. and 2. OR if the difference between 1. and 3. is greater than some threshold value,
     * we will set the current pixel to black. This is because an absolute difference that is greater than our threshold
     * value should indicate an edge and thus, we colour the pixel black.
     * Otherwise, we will set the current pixel to white
     * NOTE: We want to be able to apply edge detection using various thresholds
     * For example, we could apply edge detection to an image using a threshold of 20 OR we could apply
     * edge detection to an image using a threshold of 35
     *  */
    public static void edgeDetection(String pathToFile, int threshold) {
        APImage i = new APImage(pathToFile);
        for (int a = 1; a<i.getWidth()-1; a++){
            for (int b = 0; b<i.getHeight()-2; b++){
                Pixel p = i.getPixel(a,b);
                int c = Math.abs(getAverageColour(p)-getAverageColour(i.getPixel(a-1,b)));
                int k = Math.abs(getAverageColour(p)-getAverageColour(i.getPixel(a,b+1)));
                if (c > threshold){
                    p.setBlue(0);
                    p.setGreen(0);
                    p.setRed(0);
                }
                else{
                    p.setBlue(360);
                    p.setGreen(360);
                    p.setRed(360);
                }
                if (k > threshold){
                    p.setBlue(0);
                    p.setGreen(0);
                    p.setRed(0);
                }
                else{
                    p.setBlue(360);
                    p.setGreen(360);
                    p.setRed(360);
                }
            }
            i.draw();
        }
    }

    /** CHALLENGE Four: Reflect Image
     *
     * INPUT: the complete path file name of the image
     * OUTPUT: the image reflected about the y-axis
     *
     */
    public static void reflectImage(String pathToFile) {

    }

    /** CHALLENGE Five: Rotate Image
     *
     * INPUT: the complete path file name of the image
     * OUTPUT: the image rotated 90 degrees CLOCKWISE
     *
     *  */
    public static void rotateImage(String pathToFile) {

    }

}
