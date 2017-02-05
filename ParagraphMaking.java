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

/**
 *
 * @author ic071166
 */
public class ParagraphMaking {

    public static void main(String args[]) throws Exception{
        File dir = new File("C:\\Users\\ic071166\\Desktop\\TPCDS\\geetha_tpcds\\DrillQueries_v1");
        File[] files = dir.listFiles();
        BufferedReader br = null;
        BufferedWriter bw = null;
        String str = "";
        String s1,s2,s3,s4;
        StringBuilder sb;
        for (File file : files){
            if(file.isDirectory())
                continue;
            sb = new StringBuilder();
            System.out.println(file.getPath());
            br = new BufferedReader(new FileReader(file));
            bw = new BufferedWriter(new FileWriter(dir + "\\Updated\\" + file.getName()));
            while((str = br.readLine()) != null){
                System.out.println("Str = " + str);
                s1 = str.replace("\n"," ");
                System.out.println("S1 = " + s1);
                s2 = s1.replace(" +", " ");
                System.out.println("S2 = " + s2);
                s3 = s2.replace("\t", " ");
                System.out.println("S3 = " + s3);
                s4 = s3.trim();
                System.out.println("S4 = " + s4);
                sb.append(" ").append(s4);
                System.out.println("SB Status = " + sb.toString());
            }
            System.out.println("File is written as " + sb.toString());
            bw.write(sb.toString());
            br.close();
            bw.close();
        }
    }
    
}
