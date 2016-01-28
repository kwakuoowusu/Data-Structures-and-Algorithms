/**
 * Kwaku Owusu
 * 109181846
 * HW 7
 * CSE 214 Recitation 3
 * Recitation TA Sun Lin
 * Grading TA Ke Ma
 * @author Kwaku
 * 
 */
import java.util.Comparator;


public class LatComparator implements Comparator<City> {
	
	/**
	 * Compares the latitude of two cities
	 */
	public int compare(City o1, City o2) {
		City c1 = o1;
		City c2 = o2;
		if(c1.getLocation().getLat()==c2.getLocation().getLat()){
			return 0;
		}
		else if(c1.getLocation().getLat()>c2.getLocation().getLat()){
			return 1;
		}
		else
			return -1;
	}

}
