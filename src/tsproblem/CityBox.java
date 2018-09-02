package tsproblem;

import java.util.ArrayList;

public class CityBox {

	public static ArrayList<City> list = new ArrayList<City>();
	
	public static void addCity(City c) {
		list.add(c);
	}
	
	public static City getCity(int index) {
		return list.get(index);
	}
	
	public static int numOfCities() {
		return list.size();
	}
	
	public static void clearCities() {
		list.clear();
	}
	
}
