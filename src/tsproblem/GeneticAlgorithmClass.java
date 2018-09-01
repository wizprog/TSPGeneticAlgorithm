package tsproblem;


public class GeneticAlgorithmClass {

    private  double mutationRate = 0.015;
    private  int tournamentSize = 5;
    private  boolean elitism = true;

    // Evolves a population over one generation
    public Population evolvePopulation(Population pop) {
    	
        Population newPopulation = new Population(pop.tourPopulationSize(), false);

        int elitismOffset = 0;
        if (elitism) {
            newPopulation.setTour(0, pop.getBestTour());
            elitismOffset = 1;
        }

        // Crossover population
        // Loop over the new population's size and create individuals from
        // Current population
        for (int i = elitismOffset; i < newPopulation.tourPopulationSize(); i++) {
            // Select parents
            Tour parent1 = tournamentSelection(pop);
            Tour parent2 = tournamentSelection(pop);
            // Crossover parents
            Tour child = crossover(parent1, parent2);
            // Add child to new population
            newPopulation.setTour(i, child);
        }

        // Mutate the new population a bit to add some new genetic material
        for (int i = elitismOffset; i < newPopulation.tourPopulationSize(); i++) {
            mutate(newPopulation.getTour(i));
        }

        return newPopulation;
    }

    public Tour crossover(Tour parent1, Tour parent2) {
    	
        Tour child = new Tour();
        int startPosition = (int) (Math.random() * parent1.tourSize());
        int endPosition = (int) (Math.random() * parent1.tourSize());

        for (int i = 0; i < child.tourSize(); i++) {
            if (startPosition < endPosition && i > startPosition && i < endPosition) {
                child.setCity(i, parent1.getCity(i));
            }      
            else if (startPosition > endPosition) {
                if (!(i < startPosition && i > endPosition)) {
                    child.setCity(i, parent1.getCity(i));
                }
            }
        }

        for (int i = 0; i < parent2.tourSize(); i++) {
            if (!child.containsCity(parent2.getCity(i))) {
                for (int ii = 0; ii < child.tourSize(); ii++) {
                    if (child.getCity(ii) == null) {
                        child.setCity(ii, parent2.getCity(i));
                        break;
                    }
                }
            }
        }
        return child;
    }

    private void mutate(Tour tour) {
        for(int i=0; i < tour.tourSize(); i++){
            if(Math.random() < mutationRate){
                int j = (int) (tour.tourSize() * Math.random());
                City c1 = tour.getCity(i);
                City c2 = tour.getCity(j);
                tour.setCity(j, c1);
                tour.setCity(i, c2);
            }
        }
    }

    private Tour tournamentSelection(Population pop) {
    	
        Population tournament = new Population(tournamentSize, false);
        for (int i = 0; i < tournamentSize; i++) {
            int randomId = (int) (Math.random() * pop.tourPopulationSize());
            tournament.setTour(i, pop.getTour(randomId));
        }
        Tour fittest = tournament.getBestTour();
        return fittest;
    }
    

	public double getMutationRate() {
		return mutationRate;
	}

	public void setMutationRate(double mutationRate) {
		this.mutationRate = mutationRate;
	}

	public int getTournamentSize() {
		return tournamentSize;
	}

	public void setTournamentSize(int tournamentSize) {
		this.tournamentSize = tournamentSize;
	}

	public boolean isElitism() {
		return elitism;
	}

	public void setElitism(boolean elitism) {
		this.elitism = elitism;
	}
    
    
}
