package Utilities;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author tkalr
 */
import java.io.File;
import javax.swing.filechooser.FileFilter;


public class ImageFileFilter extends FileFilter {

    @Override
    public boolean accept(File f) {
        if (f.isDirectory()) {
            return true;
        }
        String name = f.getName();
        return isImage(name);
    }

    @Override
    public String getDescription() {
        return "Images Only";
    }

    public boolean isImage(String name) {
        String extension = name.substring(name.lastIndexOf('.') + 1);
        extension = extension.toLowerCase();
        if (extension.equals("png") || extension.equals("gif")
                || extension.equals("jpeg") || extension.equals("jpg")
                || extension.equals("bmp") || extension.equals("tif")
                || extension.equals("tiff")) {
            return true;
        }
        return false;
    }
    
    public boolean isPNGOrBMPImage(String name) {
        String extension = name.substring(name.lastIndexOf('.') + 1);
        extension = extension.toLowerCase();
        if (extension.equals("png") || extension.equals("bmp")) {
            return true;
        }
        return false;
    }

}
