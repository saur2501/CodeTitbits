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
public class RemoveWhiteSpacesFromFiles {

    public static void main(String args[]) throws Exception{
        File dir = new File("C:\\Users\\ic071166\\Downloads\\HadoopTranscripts\\Lesson 1_BigData");
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
            /*if(!file.getName().equalsIgnoreCase("file1.txt"))
                continue;*/
            System.out.println(file.getPath());
            br = new BufferedReader(new FileReader(file));
            bw = new BufferedWriter(new FileWriter(dir + "\\Updated\\" + file.getName()));
            while((str = br.readLine()) != null){
                /*System.out.println("Str = " + str);
                s1 = str.replaceAll("\n"," ");
                System.out.println("S1 = " + s1);
                s2 = s1.replaceAll("\t", " ");
                System.out.println("S2 = " + s2);
                s3 = s2.replaceAll("( )+", " ");
                System.out.println("S3 = " + s3);
                s4 = s3.trim();
                System.out.println("S4 = " + s4);*/
                sb.append(", ").append(str);
                System.out.println("SB Status = " + sb.toString());
            }
            str = sb.toString();
            s1 = str.replaceAll("\n"," ");
            s2 = s1.replaceAll("\t", " ");
            s3 = s2.replaceAll("( )+", " ");
            s4 = s3.trim();
            System.out.println("File is written as " + s4.toString());
            bw.write(s4.toString());
            br.close();
            bw.close();
        }
    }
    
}
