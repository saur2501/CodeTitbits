

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;
/**
 * Reads all files in a folder and makes a common file- containing file names, followed by sentences in separate lines (ignoring lines that start with digit or newline)
 * @author Saurabh
 */
public class SentencesInDifferentLines {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        File dir = new File("C:\\Users\\I341365\\Desktop\\PIES\\I\\Curiosities\\Experimentation\\e");											//C:\\Users\\Saurabh\\Desktop\\Hadoop\\Lesson 4_ MapReduce Design Patterns
        String[] paths = dir.list();
        System.out.println(Arrays.toString(paths));
        File file;
        String str;
        String[] dotStrings;
        boolean specialCase = false;
        BufferedReader br = null;
        BufferedWriter bw = null;
        try{
            bw= new BufferedWriter(new FileWriter("C:\\Users\\I341365\\Desktop\\output.txt"));							//dir.getAbsolutePath() + "\\..\\L4.txt"
            for(String filename : paths){
                file = new File(dir.getAbsolutePath() + "\\" + filename);
                System.out.println("File : " + file.getName());
                br = new BufferedReader(new FileReader(file));
                bw.write("\nFile : " + file.getName() + "\n======================\n");
                while((str = br.readLine()) != null){
                    System.out.println("Line is: " + str);
                    if(str.equals("") || Character.isDigit(str.charAt(0))){
                        continue;
                    }
                    if(str.endsWith(".")){
                        specialCase = true;
                    }
                    dotStrings = str.split("[\\.\\?]");
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
                br.close();
            }
        } catch(Exception e){
            System.out.println("Some Error occurred.");
            BufferedWriter bw1 = new BufferedWriter(new FileWriter("output/logs.txt"));					//C:\\dev\\FilesToWrite\\logs.txt
            bw1.write("Error happened, Man!!");
            bw1.close();
        }
        finally{bw.close();}
    }
    
}