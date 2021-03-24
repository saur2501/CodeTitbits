/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;

/**
 *
 * @author Saurabh
 */
public class FilesReaderSimple {

    /**
	 * writes all files' content in directory into single file (ignoring empty newlines and lines beginning with a digit);
	 * different from SentencesInDifferentLines.java is sense that sentences are not put in different lines but left as is.
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        File file;
        String str;
        BufferedWriter bw = null;
        BufferedReader br = null;
        File dir = new File("C:\\Users\\Saurabh\\Desktop\\Hadoop\\Lesson 1_ Big Data");
        String[] paths = dir.list();
        System.out.println(Arrays.toString(paths));
        try {
            bw= new BufferedWriter(new FileWriter("C:\\Users\\Saurabh\\Desktop\\Hadoop\\L1.txt"));
            for(String filename : paths){
                file = new File(dir.getAbsolutePath() + "\\" + filename);
                System.out.println("File : " + file.getName());
                br = new BufferedReader(new FileReader(file));
                bw.write("\nFile : " + file.getName() + "\n======================\n");                    
                while((str = br.readLine()) != null){
                    System.out.println("Line is: " + str);
                    if(!str.equals("") && !Character.isDigit(str.charAt(0)))
                        bw.write(str + "\n");
                }
                br.close();
            }
        } catch(Exception e){e.printStackTrace();}
        finally {bw.close();}
    }
    
}
