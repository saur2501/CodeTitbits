import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class SetOps {

    @SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) throws Exception{
        BufferedReader br1 = new BufferedReader(new FileReader("C:\\Users\\I341365\\Desktop\\Experimentation\\newa.txt"));
        BufferedReader br2 = new BufferedReader(new FileReader("C:\\Users\\I341365\\Desktop\\Experimentation\\newb.txt"));
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
        str1 = sb1.toString().toUpperCase();
        str2 = sb2.toString().toUpperCase();
        String[] str1Array = str1.split("\\,");
        String[] str2Array = str2.split("\\,");
        for(String s : str1Array){
        	s = s.trim();
            hs1.add(s);
        }
        for(String s : str2Array){
        	s = s.trim();
            hs2.add(s);
        }
      //union
        Set<String> res = new TreeSet<String>(hs1);
        res.addAll(hs2);
        //System.out.println("Union = " + res);
        /*List sortedList = new ArrayList(res);
        Collections.sort(sortedList);
        System.out.println();*/
        SortedSet<String> set=new TreeSet<String>(res);
        
        List<String> list=new ArrayList<String>(set);
        System.out.println("Union = " + Arrays.toString(list.toArray()));

        //intersection
        res.clear();
        res.addAll(hs1);
        res.retainAll(hs2);
        set=new TreeSet<String>(res);
        list=new ArrayList<String>(set);
        System.out.println("Intersection = " + Arrays.toString(list.toArray()));

        //difference
        res.clear();
        res.addAll(hs1);
        res.removeAll(hs2);
        System.out.println("Set Difference = " + res);

        //reverse
        /*List<Integer> list = new ArrayList<Integer>(a);
        java.util.Collections.reverse(list);
        System.out.println(list);*/
    }
}