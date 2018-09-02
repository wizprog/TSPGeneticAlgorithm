package tsproblem;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Event;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Evolution extends Frame{

	private static final long serialVersionUID = 1L;
	public static int count = 10;
	public static boolean cityCreator = false;
	public static boolean startBtn = false;
	
	private Draw main= new Draw();
	
	Button btn1 = new Button("Create");
	Button btn2 = new Button("Start");
	TextField txt1 = new TextField("Number of cities");
	public Label l = new Label();
	
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
		
		btn1.addActionListener(
			new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e)
				{
					 if (txt1.getText().matches("-?\\d+(\\.\\d+)?")) {
						 	CityBox.clearCities();
						 	count = Integer.parseInt(txt1.getText());
						 	for (int i=0; i<count; i++) {
						 		int x = (int )(Math.random() * main.getWidth()-20 + 20);
						 		int y = (int )(Math.random() * main.getHeight()-20 + 20 );
						 		City city = new City(x, y);
						 		CityBox.addCity(city);
						 	}
						l.setText("Cities created");
						cityCreator = true;
						main.repaint();
					 } else {
						 l.setText("Enter a number");
					 }
					
				}
			  }
		);
		
		btn2.addActionListener(
				new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					new Thread(main).start();
			/*		if (cityCreator) {
						startBtn = true;
						GeneticAlgorithmClass GA = new GeneticAlgorithmClass();
						Population pop = new Population(20,true);
						main.setPop(pop);
						main.repaint();
						try {
							Thread.sleep(100);
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						System.out.println("Initial distance: " + pop.getBestTour().getDistance());
						
						 pop = GA.evolvePopulation(pop);
					        for (int i = 0; i < 100; i++) {
					        	try {
									Thread.sleep(100);
								} catch (InterruptedException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
					            pop = GA.evolvePopulation(pop);	  
					            main.setPop(pop);
					            main.repaint();
					        }
					        System.out.println("Finished");
					        System.out.println("Final distance: " + pop.getBestTour().getDistance());
					        System.out.println("Solution:");
					        System.out.println(pop.getBestTour());
					        
					    	startBtn = false;
					} 
						else l.setText("No cities to work with");  */
					} 
				  }  
			);
		
		p.add(btn1);
		p.add(txt1);
		p.add(btn2);
		p.add(l);
		add(main);
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
		Evolution e = new Evolution();

        // Create and add our cities
   /*     City city = new City(60, 200);
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
*/
    }
		

}
