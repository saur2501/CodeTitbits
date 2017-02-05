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
public class FilesReader {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        try{
            File dir = new File("C:\\dev\\FilesToRead");
            String[] paths = dir.list();
            String[] dotStrings;
            System.out.println(Arrays.toString(paths));
            File file;
            String str;
            BufferedWriter bw = null;
            BufferedReader br = null;
            try {
                bw= new BufferedWriter(new FileWriter("C:\\dev\\FilesToWrite\\fileOutput.txt"));
                //bw.write("Krishna\n");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            boolean specialCase = false;
            for(String filename : paths){
                file = new File("C:\\dev\\FilesToRead\\" + filename);
                System.out.println("File : " + file.getName());
                try{
                    bw.write("\nFile : " + file.getName() + "\n======================\n");
                    br = new BufferedReader(new FileReader(file));
                    while((str = br.readLine()) != null){
                        System.out.println("Line is: " + str);
                        if(!str.equals("") && !Character.isDigit(str.charAt(0))){
                            if(str.endsWith(".")){
                                specialCase = true;
                                System.out.println("I was here, Misa!");
                            }
                            dotStrings = str.split("[\\.\\?]");
                            //for(String s : dotStrings){
                                /*if(s.charAt(s.length()-1) == '\n'){
                                    System.out.println("I was here some time.");
                                    s = s.trim();
                                    bw.write(s + " ");
                                }
                                else*/
                                    //bw.write(s + "\n");
                            //}
                            for(int i = 0; i < dotStrings.length; i++){
                                if(i == dotStrings.length - 1) {
                                    bw.write(dotStrings[i].trim());
                                    if(specialCase){
                                        //flag = false;
                                        bw.write("\n");
                                        specialCase = false;
                                    } else {
                                        //flag = true;
                                        bw.write(" ");
                                    }
                                }
                                else bw.write(dotStrings[i].trim() + "\n");
                            }
                        }
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
