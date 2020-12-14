import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SetOfSetsOperations {

    @SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) throws Exception{
    	BufferedReader br;
    	String str;
    	int n = 10;
    	
    	HashSet<?>[] hs = new HashSet<?>[n];
    	Set<String> union = new TreeSet<String>();
    	Set<String> intersection = new TreeSet<String>();
    	int count = 0;
    	for (int i = 0; i < hs.length; ++i)
    	    hs[i] = new HashSet<String>();

    	String[] str1Array;
    	StringBuilder sb = new StringBuilder();
    	int k = 0;
    	br = new BufferedReader(new FileReader("C:\\Users\\I341365\\Desktop\\Experimentation\\cars.txt"));
    	while((str = br.readLine()) != null) {
    		sb.setLength(0);			//reset the string builder
            sb.append(str);
    		str = sb.toString();
    		str = str.toUpperCase();
    		str1Array = str.split("\\,");
    		for(String s : str1Array){
                ((HashSet<String>)hs[k]).add(s.trim());
            }
    		union.addAll((HashSet<String>)hs[k]);
    		if(k == 0)
    			intersection.addAll((HashSet<String>)hs[k]);
    		else
    			intersection.retainAll((HashSet<String>)hs[k]);
    		k++;
    	}
    	System.out.println("Union = " + union);
    	System.out.println("Intersection = " + intersection);
    	int m = union.size();
    	HashSet<?>[] stringInPriority = new HashSet<?>[m];
    	for(int i = 0;i < m;i++) {
    		stringInPriority[i] = new HashSet<String>();
    	}
    	
    	for(String strUnion : union) {
    		count = 0;
    		for(int i = 0;i < n;i++) {
    			if(hs[i].contains(strUnion))
    				count++;
    		}
    		((HashSet<String>)stringInPriority[count]).add(strUnion);				//add(strUnion);
    	}
    	System.out.println("--Following List tells how many people counted an element in toppers--");
    	for(int i = n-1;i>=1;i--) {
    		System.out.println("Rating " + i + " = " + stringInPriority[i]);
    	}
    }
}