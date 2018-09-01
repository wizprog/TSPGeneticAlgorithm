package tsproblem;

public class Population {
	
	Tour[] tourPopulation;
	
	public Population(int size, boolean create) {
		tourPopulation = new Tour[size];
		if (create) {
			for (int i=0; i<size; i++) {
				Tour t = new Tour();
				t.generateTour();
			    tourPopulation[i] = t;
			}
		}
	}
	
	
	public void setTour(int index, Tour t) {
		tourPopulation[index] = t;
	}
	
	public Tour getTour(int index) {
		return tourPopulation[index];
	}
	
	public int tourPopulationSize() {
		return tourPopulation.length;
	}
	
	public Tour getBestTour() {
		Tour best = null;
		double bestFit = Double.MIN_VALUE;
		for (int i=0; i<tourPopulation.length; i++) {
			tourPopulation[i].calucalteDistance();
			tourPopulation[i].calculateFitness();
			double x = tourPopulation[i].getFitness();
			if (x>bestFit) {
				best = tourPopulation[i];
				bestFit = x;
			}
		}
		
		return best;
	}
	
}
