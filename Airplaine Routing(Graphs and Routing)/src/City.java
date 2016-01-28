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
	import com.google.code.geocoder.*;
	import com.google.code.geocoder.model.*;
	import latlng.LatLng;
	import java.io.Serializable;
	

public class City implements Serializable{
	static int cityCount =0;
	private int indexPos;
	private String name;
	private String addr;
	private LatLng location = new LatLng();
	
	public City(String cityName){
		
		this.name = cityName;
		indexPos = cityCount;
		cityCount++;
		this.setLocation();
	}
	
	
	/**
	 * Uses the geocoder to set latitude and longitude
	 */
	public void setLocation(){
		try {
		    Geocoder geocoder = new Geocoder();
		    GeocoderRequest geocoderRequest;
		    GeocodeResponse geocodeResponse;
		   

		    geocoderRequest = new GeocoderRequestBuilder().setAddress(name).getGeocoderRequest();
		    geocodeResponse = geocoder.geocode(geocoderRequest);
		    addr = geocodeResponse.getResults().get(0).getFormattedAddress();
		    location.setLat(geocodeResponse.getResults().get(0).getGeometry().getLocation().getLat().doubleValue());
		    location.setLng(geocodeResponse.getResults().get(0).getGeometry().getLocation().getLng().doubleValue());
		} catch (Exception e) {
		    // error handling goes here
		}
	}
	
	/**
	 * Returns the location which holds lat and lng
	 * @return
	 */
	public LatLng getLocation(){
		return this.location;
	}
	
	/*
	 * Returns the name of the city
	 */
	public String getName(){
		return name;
	}
	
	/**
	 * Returns the indexPosition of a city
	 * @return
	 */
	public  int getIndexPos(){
		return indexPos;
	}
	/**
	 * Returns the amount of cities currently used
	 * @return
	 */
	public int getCityCount(){
		return cityCount;
	}
	
	/**
	 * Returns a string representation of a city
	 */
	public String toString(){
		String name = this.getName();
		String lat =  this.getLocation().getLat() + "";
		String lng = this.getLocation().getLng()+"";
		String s  = String.format("%-50s %-30s %-30s", name, lat, lng);
		return s;
	}
	public static void main(String[]args){
		 City abc = new City("Sacramento");
		System.out.println( abc.getLocation().getLng());
		System.out.println(abc.indexPos);
		
		City def = new City("Tokyo");
		System.out.println( def.getLocation().getLng());
		System.out.println(def.indexPos);
	}
}
