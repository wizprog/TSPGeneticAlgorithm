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
	
	public static Button btn1 = new Button("Create");
	public static Button btn2 = new Button("Start");
	TextField txt1 = new TextField("Number of cities");
	public static Label l = new Label("Information label");
	
	public static Label start = new Label("Initial distance: ");
	public static Label finish = new Label("Final distance: ");
	public static Label evolve = new Label("Generation 0 out of 500");
	
	public Evolution() {
		super("Traveling salesman problem");
		setSize(1200,800);
		addComponents();
		setVisible(true);
	}
	
	public void addComponents() {
		Panel p = new Panel();
		Panel p1 = new Panel();
		p1.setLayout(null);
		
		p.setSize(WIDTH, 30);
		p.setBackground(Color.GRAY);
		
		p1.setSize(WIDTH, 30);
		p1.setBackground(Color.GRAY);
		
		btn1.addActionListener(
			new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e)
				{
					 Draw.started = false;
					 if (txt1.getText().matches("-?\\d+(\\.\\d+)?")) {
						 	CityBox.clearCities();
						 	count = Integer.parseInt(txt1.getText());
						 	for (int i=0; i<count; i++) {
						 		int x = (int )(Math.random() * main.getWidth()-50 + 50);
						 		int y = (int )(Math.random() * main.getHeight()-50 + 50 );
						 		City city = new City(x, y);
						 		CityBox.addCity(city);
						 	}
						l.setText("Cities created");
						repaint();
						cityCreator = true;
						main.repaint();
					 } else {
						 l.setText("Enter a number");
						 repaint();
					 }
					
				}
			  }
		);
		
		btn2.addActionListener(
				new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					new Thread(main).start();
					} 
				  }  
			);
		
		p.add(btn1);
		p.add(txt1,BorderLayout.EAST);
		p.add(btn2);
		
		start.setBounds(this.getWidth() / 3 - 100, 1, 180,20);
		finish.setBounds((this.getWidth()  / 3)+100, 1, 180,20);
		evolve.setBounds((this.getWidth()  / 3)+300, 1, 200, 20);
		p1.add(start);
		p1.add(finish);
		p1.add(evolve);
		p.add(l);
		add(main);
		add(p,BorderLayout.NORTH);
		add(p1,BorderLayout.SOUTH);
		
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
    }
		

}
