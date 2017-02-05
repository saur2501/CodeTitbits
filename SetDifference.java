
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Iterator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author IC071166
 */
public class SetDifference {
    public static void main(String[] args) throws Exception{
        BufferedReader br1 = new BufferedReader(new FileReader("C:\\Users\\ic071166\\Desktop\\temp\\file3.txt"));
        BufferedReader br2 = new BufferedReader(new FileReader("C:\\Users\\ic071166\\Desktop\\temp\\file4.txt"));
        String str1 = null, str2 = null;
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        HashSet hs1 = new HashSet();
        HashSet hs2 = new HashSet();
        while((str1 = br1.readLine()) != null){
            sb1.append(str1);
        }
        while((str2 = br2.readLine()) != null){
            sb2.append(str2);
        }
        str1 = sb1.toString();
        str2 = sb2.toString();
        String[] str1Array = str1.split("\\,");
        String[] str2Array = str2.split("\\,");
        for(String s : str1Array){
            hs1.add(s);
        }
        for(String s : str2Array){
            hs2.add(s);
        }
        Iterator itr = hs1.iterator();
        System.out.println("\nHS1 is - ");
        while(itr.hasNext()){
            System.out.print(", " + itr.next());
        }
        System.out.println("\nHS2 is - ");
        itr = hs2.iterator();
        while(itr.hasNext()){
            System.out.print(", " + itr.next());
        }
        hs1.removeAll(hs2);
        System.out.println("\nHS1 after removal is - ");
        itr = hs1.iterator();
        while(itr.hasNext()){
            System.out.print("," + itr.next());
        }
    }
}
