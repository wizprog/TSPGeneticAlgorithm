package tsproblem;

import java.util.ArrayList;
import java.util.Collections;

public class Tour {
	
	public ArrayList<City> tour = new ArrayList<City>();
	
	
	private double fitness = 0;
	private double distance = 0;
	
	  public Tour(){
	        for (int i = 0; i < CityBox.numOfCities(); i++) {
	            tour.add(null);
	        }
	    }
	
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
		  if (fitness == 0) {
	            fitness = 1/(double)getDistance();
	        }
	}
	
	public void calucalteDistance() {
		distance = 0;
		for (int i = 0; i<tour.size(); i++) {
			if (i + 1 < tour.size()) distance += tour.get(i).distance(tour.get(i+1));
			else distance += tour.get(i).distance(tour.get(0));
		}
	}
	
	public void generateTour() {
		for (int i=0; i<CityBox.numOfCities();i++) {
			tour.set(i,CityBox.getCity(i));
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
	
	public City getCity(int index) {
		return tour.get(index);
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

    @Override
    public String toString() {
        String geneString = "|";
        for (int i = 0; i < tourSize(); i++) {
            geneString += getCity(i)+"|";
        }
        return geneString;
    }
	
	
	
	
}
