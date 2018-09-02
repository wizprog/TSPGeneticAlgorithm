package tsproblem;

import java.awt.*;	
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Draw extends Component implements Runnable {

	public static final Color bkC = new Color(0x096000);   //green
	public static final Color bk2C = new Color(0x000000);  //black
	public static final Color lnC = new Color(0xffc900);   //yellow
	public static final Color ln2C = new Color(0xcccc00);  //yellow 2
	public static final Color fgC = new Color(0xffffff);	// white
	
	public Population pop;
	private boolean started = false;
	
	@Override
	public void run() {
		
		started = true;
		GeneticAlgorithmClass GA = new GeneticAlgorithmClass();
		pop = new Population(20,true);
	    System.out.println("Initial distance: " + pop.getBestTour().getDistance());

	        // Evolve population for 100 generations
	    pop = GA.evolvePopulation(pop);
	    repaint();
	    try {
			Thread.sleep(100);
		    for (int i = 0; i < 1000; i++) {
		         pop = GA.evolvePopulation(pop);	
		         repaint();
		         Thread.sleep(100);
		      }
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    started = false;

	   System.out.println("Finished");
	   System.out.println("Final distance: " + pop.getBestTour().getDistance());
	   System.out.println("Solution:");
	   System.out.println(pop.getBestTour());  

	}
	
	public void setPop(Population p) {
		this.pop = p;
	}
	
	
	public void paint(Graphics g) {	
		Graphics2D g2 = (Graphics2D) g;
		int w = getSize().width;
		int h = getSize().height;
		Rectangle rect = new Rectangle(0, 0, w, h);
		g2.setColor(Color.BLUE);
		g2.fillRect(0, 0, w, h);
		
		g2.setColor(Color.RED);
		for (int i=0; i<CityBox.numOfCities();i++) {		
			g2.fillOval(CityBox.getCity(i).getX(),CityBox.getCity(i).getY(),10, 10);
		}
		
		g2.setColor(Color.PINK);
		if (CityBox.numOfCities() > 0)
		//	g2.drawLine(CityBox.getCity(1).getX()+5, CityBox.getCity(1).getY()+5, CityBox.getCity(2).getX()+5, CityBox.getCity(2).getY()+5);
		
		if (started) paintConections(g2);
		
	}
	
	
	public void paintConections(Graphics g) {
		
		Tour tour = pop.getBestTour();
		
		for (int i = 0; i<CityBox.numOfCities(); i++) {
			if (i + 1 < CityBox.numOfCities()) g.drawLine(tour.getCity(i).getX()+5, tour.getCity(i).getY()+5, tour.getCity(i+1).getX()+5, tour.getCity(i+1).getY()+5);  
			else g.drawLine(tour.getCity(i).getX()+5, tour.getCity(i).getY()+5, tour.getCity(0).getX()+5, tour.getCity(0).getY()+5);
		}
		
	}

}
