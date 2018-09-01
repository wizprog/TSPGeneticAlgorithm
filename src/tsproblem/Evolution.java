package tsproblem;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Event;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextField;

public class Evolution extends Frame{

	private static final long serialVersionUID = 1L;
	
	Button btn1 = new Button("Start");
	TextField txt1 = new TextField("Number of cities");
	
	public Evolution() {
		super("Traveling salesman problem");
		setSize(800,500);
		addComponents();
		setVisible(true);
	}
	
	public void addComponents() {
		Panel p = new Panel();
		p.setSize(WIDTH, 800);
		p.setBackground(Color.GRAY);
		btn1.setSize(50, 50);
		p.add(btn1);
		p.add(txt1);
		add(p,BorderLayout.NORTH);
	}
	
	public boolean handleEvent(Event e) {
		if(e.id == Event.WINDOW_DESTROY) {
			System.exit(0);
			return true;
		} else 
			return false;
	}

	public static void main(String[] args) {
	//	Evolution e = new Evolution();
		
		
		GeneticAlgorithmClass GA = new GeneticAlgorithmClass();

        // Create and add our cities
        City city = new City(60, 200);
        CityBox.addCity(city);
        City city2 = new City(180, 200);
        CityBox.addCity(city2);
        City city3 = new City(80, 180);
        CityBox.addCity(city3);
        City city4 = new City(140, 180);
        CityBox.addCity(city4);
        City city5 = new City(20, 160);
        CityBox.addCity(city5);
        City city6 = new City(100, 160);
        CityBox.addCity(city6);
       City city7 = new City(200, 160);
        CityBox.addCity(city7);
        City city8 = new City(140, 140);
        CityBox.addCity(city8);
        City city9 = new City(40, 120);
        CityBox.addCity(city9);
        City city10 = new City(100, 120);
        CityBox.addCity(city10);
        City city11 = new City(180, 100);
        CityBox.addCity(city11);
        City city12 = new City(60, 80);
        CityBox.addCity(city12);
        City city13 = new City(120, 80);
        CityBox.addCity(city13);
        City city14 = new City(180, 60);
        CityBox.addCity(city14);
        City city15 = new City(20, 40);
        CityBox.addCity(city15);
        City city16 = new City(100, 40);
        CityBox.addCity(city16);
        City city17 = new City(200, 40);
        CityBox.addCity(city17);
        City city18 = new City(20, 20);
        CityBox.addCity(city18);
        City city19 = new City(60, 20);
        CityBox.addCity(city19);
        City city20 = new City(160, 20);
        CityBox.addCity(city20);  

        // Initialize population
        Population pop = new Population(20,true);
        System.out.println("Initial distance: " + pop.getBestTour().getDistance());

        // Evolve population for 100 generations
       pop = GA.evolvePopulation(pop);
        for (int i = 0; i < 100; i++) {
            pop = GA.evolvePopulation(pop);
        }

        // Print final results
        System.out.println("Finished");
        System.out.println("Final distance: " + pop.getBestTour().getDistance());
        System.out.println("Solution:");
        System.out.println(pop.getBestTour());
    }
		

}
