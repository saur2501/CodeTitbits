/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filesreader;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import static java.lang.System.exit;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Saurabh
 */
public class FilesReaderSimple_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        try{
            File dir = new File("C:\\dev\\FilesToRead");
            String[] paths = dir.list();
            System.out.println(Arrays.toString(paths));
            File file;
            String str;
            BufferedWriter bw = null;
            BufferedReader br = null;
            try {
                bw= new BufferedWriter(new FileWriter("C:\\dev\\FilesToWrite\\fileOutput.txt"));
                bw.write("Krishna\n");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            for(String filename : paths){
                file = new File("C:\\dev\\FilesToRead\\" + filename);
                System.out.println("File under test: " + file.getName());
                try{
                    bw.write("\nFile under test: " + file.getName() + "\n======================\n");
                    br = new BufferedReader(new FileReader(file));
                    while((str = br.readLine()) != null){
                        System.out.println("Line is: " + str);
                        if(!str.equals("") && !Character.isDigit(str.charAt(0)))
                            bw.write(str + "\n");
                    }
                    //System.out.println("Hi Baby");
                } catch(Exception e){e.printStackTrace();}
            }
            try {
                br.close();
                bw.close();
            } catch (IOException ex) {
                Logger.getLogger(FilesReader.class.getName()).log(Level.SEVERE, null, ex);
            }
        }catch(Exception e){
            BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\dev\\FilesToWrite\\logs.txt"));
            bw.write("Error happened, Man!!");
            bw.close();
        }
    }
    
}
