import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NotepadGroupBy {

	public static void main(String[] args) throws IOException {
		int secondsGap = -9;
        File file;
        String str;
        BufferedWriter bw = null;
        BufferedReader br = null;
//        File dir = new File("C:\\Users\\I341365\\Desktop\\PIES\\I\\Curiosities\\Experimentation\\f");
//        String[] paths = dir.list();
//        System.out.println(Arrays.toString(paths));
        try {
            //bw= new BufferedWriter(new FileWriter("C:\\Users\\I341365\\Desktop\\PIES\\I\\Curiosities\\f1.txt"));
            file = new File("/Users/I341365/Desktop/f.txt");
            System.out.println("File : " + file.getName());
            br = new BufferedReader(new FileReader(file));
            //bw.write("\nFile : " + file.getName() + "\n======================\n");
            String para = "";
            Map<String, List<String>> map = new HashMap<>();
            String previous_header = "";
            while((str = br.readLine()) != null){
                //System.out.println("Line is: " + str);
                String[] split_string = str.split(" ", 2);
                String header = split_string[0];
                if(!header.equals("") && !header.startsWith("\t") && !header.startsWith(" ") && !header.startsWith("\r") && !header.startsWith("/n")) {
                	if(map.get(header) == null) {
                		List<String> list = new ArrayList<>();
                		map.put(header, list);
                	}
                	if(!previous_header.equals(""))
                		map.get(previous_header).add(para);
            		//System.out.println(header);
	            	//bw.write(header);
	            	//bw.write("\n");
	            	para = "";
	            	previous_header = header;
                }
                para = para.concat(str + "\r\n");
            }
            map.get(previous_header).add(para);
            br.close();
            
            bw = new BufferedWriter(new FileWriter("/Users/I341365/Desktop/f1.txt"));
            Set headerSet = map.entrySet();
            Iterator iterator = headerSet.iterator();
            while (iterator.hasNext()) { 
                Map.Entry headerEntry = (Map.Entry) iterator.next(); 
      
                System.out.println(headerEntry.getKey()); 
                List<String> headerValuesList = (List<String>) headerEntry.getValue(); 

                for(int i = 0; i < headerValuesList.size(); i++) {   
                	//if(headerValuesList.size() > 2) {
                		//System.out.println(headerValuesList.get(i));
                        bw.write(headerValuesList.get(i));
                        //break;
                	//}
                    //System.out.println(headerValuesList.get(i));
                    //bw.write(headerValuesList.get(i));
                    //bw.write("\n");
                }
            }
        } catch(Exception e){e.printStackTrace();}
        finally {bw.close();
        System.out.println("Hi");
        }
    
	}

}
