import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class SetOfListsOperations {

    @SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) throws Exception{
    	BufferedReader br;
    	String strRatingsBy1Person;
    	int n = 15;
    	
    	HashMap<String,Double> smartPhoneRating = new HashMap<String, Double> ();
    	List<List<String>> ratingsByDifferentPerson = new ArrayList<List<String>>();
    	List<String> listRatingsBy1Person = new ArrayList<>();
    	Set<String> union = new TreeSet<String>();
    	Set<String> intersection = new TreeSet<String>();
    	int count = 0;
//    	for (int i = 0; i < hs.length; ++i)
//    	    hs[i] = new ArrayList<String>();

    	String[] strArrRatingsBy1Person;
    	StringBuilder sb = new StringBuilder();
    	int k = 0, totalElementsIn1PersonRating = 0, totalPersons = 0;
    	double elementCumulativeRating, rating;
    	br = new BufferedReader(new FileReader("C:\\Users\\I341365\\Desktop\\Experimentation\\cars.txt"));
    	while((strRatingsBy1Person = br.readLine()) != null) {
    		totalPersons++;
    		sb.setLength(0);			//reset the string builder
            sb.append(strRatingsBy1Person.trim());
    		strRatingsBy1Person = sb.toString();
    		strRatingsBy1Person = strRatingsBy1Person.toUpperCase();
    		strArrRatingsBy1Person = strRatingsBy1Person.split("\\,");
    		totalElementsIn1PersonRating = strArrRatingsBy1Person.length;
    		int iCountInPersonList = 0;
    		for(String ratedElement : strArrRatingsBy1Person){
    			//rating = (totalElementsIn1PersonRating - iCountInPersonList) / (double) totalElementsIn1PersonRating * 10;
    			int rate = 10 - iCountInPersonList;
				rating = rate > 0 ? rate : 1;
    			String trimmedRatedElement = ratedElement.trim();
				if(smartPhoneRating.containsKey(trimmedRatedElement)) {
    				elementCumulativeRating = smartPhoneRating.get(trimmedRatedElement);
    				smartPhoneRating.put(trimmedRatedElement, elementCumulativeRating + rating);
    			} else {
    				smartPhoneRating.put(trimmedRatedElement, rating);
    			}
    			iCountInPersonList++;
                //((ArrayList<String>)hs[k]).add(ratedElement);
            }
    	}
    	//sortedOnKey(smartPhoneRating, totalPersons);
    	List ll_allElements = new LinkedList(smartPhoneRating.entrySet());
    	Collections.sort(ll_allElements, new Comparator() {
    		public int compare(Object o1, Object o2) {
                return ((Comparable) ((Map.Entry) (o2)).getValue())
                   .compareTo(((Map.Entry) (o1)).getValue());
             }
		});
    	//add in sequence of list
    	 HashMap<String, Double> sortedOnValueRatings = new LinkedHashMap<>();
         for (Iterator it = ll_allElements.iterator(); it.hasNext();) {
                Map.Entry entry = (Map.Entry) it.next();
                sortedOnValueRatings.put(entry.getKey().toString(), Double.valueOf(entry.getValue().toString()));
         }
         for(String element : sortedOnValueRatings.keySet()) {
     		System.out.println(element + "\t\t.........\t" + sortedOnValueRatings.get(element) / totalPersons);
     	}
    }

	private static void sortedOnKey(HashMap<String, Double> smartPhoneRating, int totalPersons) {
		TreeMap<String,Double> sortedOnKeyRatings = new TreeMap<>(smartPhoneRating);
    	for(String element : sortedOnKeyRatings.keySet()) {
    		System.out.println(element + "\t\t.........\t" + sortedOnKeyRatings.get(element) / totalPersons);
    	}
	}
}