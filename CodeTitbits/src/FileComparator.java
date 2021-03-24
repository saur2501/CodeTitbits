import java.io.BufferedReader;
//import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Compares all files in 2 directories (ignoring white spaces)- 1st mismatch is informed. Eg- SQL's that didn't match TPCDS.
 * @author IC071166
 */
public class FileComparator {
    
    public static void main(String args[]) throws Exception{
        File dir1 = new File("D:\\Hadoop Code Related\\DB\\TPCDS\\geetha_tpcds\\DrillQueries\\Updated");
        File dir2 = new File("C:\\Users\\ic071166\\Desktop\\Queries\\Updated");
        File[] files1 = dir1.listFiles();
        //File[] files2 = dir1.listFiles();
        BufferedReader br1 = null;
        BufferedReader br2 = null;
        //BufferedWriter bw = null;
        int i = 0;
        String str = "";
        String s1,s2,s3,s41,s42;
        StringBuilder sb1, sb2;
        //System.out.println(Arrays.toString(files1));
        for (File file : files1){
            if(file.isDirectory())
                continue;
            /*if(!file.getName().equalsIgnoreCase("query90.sql"))
                continue;*/
            //System.out.println(file.getPath());
            br1 = new BufferedReader(new FileReader(file));
            br2 = new BufferedReader(new FileReader(dir2 + "\\" + file.getName()));
            
            //bw = new BufferedWriter(new FileWriter(dir + "\\Updated\\" + file.getName()));
            sb1 = new StringBuilder();
            sb2 = new StringBuilder();
            while((str = br1.readLine()) != null){
                /*System.out.println("Str = " + str);
                s1 = str.replaceAll("\n"," ");
                System.out.println("S1 = " + s1);
                s2 = s1.replaceAll("\t", " ");
                System.out.println("S2 = " + s2);
                s3 = s2.replaceAll("( )+", " ");
                System.out.println("S3 = " + s3);
                s4 = s3.trim();
                System.out.println("S4 = " + s4);*/
                sb1.append(" ").append(str);
                //System.out.println("SB Status = " + sb1.toString());
            }
            str = sb1.toString();
            s1 = str.replaceAll("\n"," ");
            s2 = s1.replaceAll("\t", " ");
            s3 = s2.replaceAll("( )+", " ");
            s41 = s3.trim();
            //System.out.println("File is written as " + s4.toString());
            //bw.write(s4.toString());
            while((str = br2.readLine()) != null){
                /*System.out.println("Str = " + str);
                s1 = str.replaceAll("\n"," ");
                System.out.println("S1 = " + s1);
                s2 = s1.replaceAll("\t", " ");
                System.out.println("S2 = " + s2);
                s3 = s2.replaceAll("( )+", " ");
                System.out.println("S3 = " + s3);
                s4 = s3.trim();
                System.out.println("S4 = " + s4);*/
                sb2.append(" ").append(str);
                //System.out.println("SB Status = " + sb1.toString());
            }
            str = sb2.toString();
            s1 = str.replaceAll("\n"," ");
            s2 = s1.replaceAll("\t", " ");
            s3 = s2.replaceAll("( )+", " ");
            s42 = s3.trim();
            if(!s41.equals(s42)){
                System.out.println(i + ". File " + file.getName() + " didn't match as is");
                System.out.println(s41);
                System.out.println(s42);
                i++;
            }
            br1.close();
            br2.close();
            //bw.close();
        }
    }
    
}
