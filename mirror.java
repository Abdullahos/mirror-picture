
/**
 * Write a description of mirror here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.io.*;
public class mirror {
     public ImageResource mirrorImage(ImageResource image){
        ImageResource mirroredImage = new ImageResource(image.getWidth(),image.getHeight());
        //iterate over all image pixels
        for(Pixel outPixel : mirroredImage.pixels()){
            //linking inImage with outImage
        Pixel inPixel = image.getPixel(image.getWidth()-(outPixel.getX()+1),outPixel.getY());
        outPixel.setRed(inPixel.getRed());
        outPixel.setGreen(inPixel.getGreen());
        outPixel.setBlue(inPixel.getBlue());
        //outPixel = mirroredImage.getPixel(image.getWidth()-inPixel.getX(),inPixel.getY());
    }//for
    return mirroredImage;
    }//meth   
    public void displayImage(){
        DirectoryResource dr = new DirectoryResource();
        for(File file : dr.selectedFiles()){
            FileResource fr = new FileResource(file);
            ImageResource image = new ImageResource(file);
            String fileName = image.getFileName();
            String newName = "mirrored-"+fileName;
            ImageResource mirroredImage = mirrorImage(image);
            mirroredImage.setFileName(newName);
            mirroredImage.draw();
            mirroredImage.save();
        }//end for
    }
}//class
