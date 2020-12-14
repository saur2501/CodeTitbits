
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdjustSubtitles {

	public static void main(String[] args) throws IOException {
		int secondsGap = -9;
        File file;
        String str;
        BufferedWriter bw = null;
        BufferedReader br = null;
        File dir = new File("C:\\Users\\I341365\\Desktop\\PIES\\I\\Curiosities\\Experimentation\\f");
        String[] paths = dir.list();
        System.out.println(Arrays.toString(paths));
        try {
            bw= new BufferedWriter(new FileWriter("C:\\Users\\I341365\\Desktop\\PIES\\I\\Curiosities\\Experimentation\\f.txt"));
            for(String filename : paths){
                file = new File(dir.getAbsolutePath() + "\\" + filename);
                System.out.println("File : " + file.getName());
                br = new BufferedReader(new FileReader(file));
                //bw.write("\nFile : " + file.getName() + "\n======================\n");                    
                while((str = br.readLine()) != null){
                    //System.out.println("Line is: " + str);
                    if(!str.equals("") && Character.isDigit(str.charAt(0)) && str.length() > 2 && str.charAt(2) == ':') {
                    	Pattern pattern = Pattern.compile("(\\d{2})\\:(\\d{2})\\:(\\d{2})");
                    	Matcher matcher = pattern.matcher(str);
                    	String str2 = "";
                    	System.out.println("str is " + str);
                    	while (matcher.find()) {
                    		System.out.println(matcher + "is matcher with start being " + matcher.start() + " and end being " +  matcher.end());
                    		//matcher.r
                    		str2 = matcher.group();
                    		System.out.println("str2 is " + str2);
                    		String[] str3 = str2.split("\\:");
                    		int thirdNum = Integer.parseInt(str3[2]) + secondsGap;
                    		int secondNum = Integer.parseInt(str3[1]);
                    		int firstNum = Integer.parseInt(str3[0]);
                    		
                    		if(thirdNum >= 60) {
                    			thirdNum = thirdNum - 60;
                    			secondNum ++;
                    			if(secondNum >= 60) {
                    				secondNum = secondNum - 60;
                    				firstNum++;
                    			}
                    			else if (secondNum <= 0) {
                    				secondNum += 60;
                    				firstNum --;
                    			}
                    		}
                    		else if (thirdNum <= 0) {
                    			thirdNum += 60;
                    			secondNum--;
                    		}
                    		str3[0] = Integer.toString(firstNum);
                    		str3[1] = Integer.toString(secondNum);
                    		str3[2] = Integer.toString(thirdNum);
                    		if(str3[0].length() == 1) str3[0] = "0" + str3[0];
                    		if(str3[1].length() == 1) str3[1] = "0" + str3[1];
                    		if(str3[2].length() == 1) str3[2] = "0" + str3[2];
                            //System.out.println("I found the text "+matcher.group()+" starting at index "+    matcher.start()+" and ending at index "+matcher.end());
                    		str = str.substring(0, matcher.start()) + str3[0] + ":" + str3[1] + ":" + str3[2] + str.substring(matcher.end());
                            /*String strB4 = "", strNow = "", strAfter = "";
                            if(matcher.start() == 0)
                            	strB4 = "";
                            else strB4 = str.substring(0,matcher.start());
                            strNow = str3[0] + ":" + str3[1] + ":" + str3[2];
                            if(matcher.end() == str.length())
                            	strAfter = "";
                            else strAfter = str.substring(matcher.end());
                            str = strB4 + strNow + strAfter;*/
                            System.out.println("str after replacement is " + str);
                        }
                    	bw.write(str);
                    	bw.write("\n");
                    }
                    else 
                    	bw.write(str + "\n");
                }
                br.close();
            }
        } catch(Exception e){e.printStackTrace();}
        finally {bw.close();}
    
	}

}
