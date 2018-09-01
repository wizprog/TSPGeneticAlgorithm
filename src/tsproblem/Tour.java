package tsproblem;

import java.util.ArrayList;
import java.util.Collections;

public class Tour {
	
	public ArrayList<City> tour = new ArrayList<City>();
	
	private double fitness = 0;
	private double distance = 0;
	
	public double getFitness() {
		return fitness;
	}
	
	public void setFitness(double fitness) {
		this.fitness = fitness;
	}
	
	public double getDistance() {
		return distance;
	}
	
	public void setDistance(double distance) {
		this.distance = distance;
	}
	
	public void calculateFitness() {
		if (distance != 0) {
			fitness = 1 / distance;
		} else 
			fitness = 0;
	}
	
	public void calucalteDistance() {
		for (int i = 1; i<tour.size(); i++) {
			if (tour.get(i) != null && tour.get(i-1) != null)
				distance += tour.get(i).distance(tour.get(i-1));
			else {
				distance = 0;
				return;
			}
		}
	}
	
	public void generateTour() {
		for (int i=0; i<CityBox.numOfCities();i++) {
			tour.set(i, CityBox.getCity(i));
		}
		Collections.shuffle(tour);
		fitness = 0;
		distance = 0;
			
	}
	
	public void setCity(int index, City c) {
		tour.set(index, c);	
	    fitness = 0;
	    distance = 0;
	}
	
	public void setTour(ArrayList<City> list) {
		this.tour = list;
	}
	
	public int tourSize() {
		return tour.size();
	}
	
	public boolean containsCity(City c){
        return tour.contains(c);
    }
	
	
}
