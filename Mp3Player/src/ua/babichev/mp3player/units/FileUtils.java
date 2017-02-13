/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.babichev.mp3player.units;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author Inkvizitor
 */
public class FileUtils {
    
    public static String getFileNameWithoutExtension(String fileName){
        File file = new File(fileName);
        int index = file.getName().lastIndexOf(".");
        if(index>0&& index <= file.getName().length()-2){
            return file.getName().substring(0,index);
    }
        return "noname";
    }
    
    public static String getFileExtension(File f){
        String ext = null;
        String s = f.getName();
        int i = s.lastIndexOf(".");
        
        if(i>0 && i<s.length()-1){
            ext = s.substring(i+1).toLowerCase();
        }
        return ext;
    }
    //удалить текщий файл-фильтр и установить новый переданный
    private static void addFileFilter(JFileChooser jfc, FileFilter ff){
        jfc.removeChoosableFileFilter(jfc.getFileFilter());
        jfc.setFileFilter(ff);
        jfc.setSelectedFile(new File(""));// удаляем последнее имя
    }
    //сохранить объект
    private static void serialize(Object obj, String fileName){
        
        try {
            FileOutputStream fos = new FileOutputStream(fileName);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(obj);
            oos.flush();
            oos.close();
            fos.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileUtils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    //открыть объект
    public static Object deserialize(String fileName){
        try {
            FileInputStream fis = new FileInputStream(fileName);
            ObjectInputStream oin = new ObjectInputStream(fis);
            Object ts= (Object)oin.readObject();
            fis.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileUtils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
