/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.babichev.mp3player.units;

import java.io.File;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author Inkvizitor
 */
public class Mp3FileFilter extends FileFilter {
    
    private String fileExtension;
    private String fileDescription;

    public Mp3FileFilter(String fileExtension, String fileDescription) {
        this.fileExtension = fileExtension;
        this.fileDescription = fileDescription;
    }

    @Override
    public boolean accept(File file) {
        return file.isDirectory()||file.getAbsolutePath().endsWith(fileExtension);
    }

    @Override
    public String getDescription() {
        return fileDescription+"(*."+fileExtension+")";
    }
    
}
