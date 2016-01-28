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


public class NameComparator implements Comparator<City> {

	/**
	 * Compares the names of two cities 
	 */
	public int compare(City arg0, City arg1) {
		City c1 = arg0;
		City c2 = arg1;
		
		return (c1.getName().compareTo(c2.getName()));
	}

}
