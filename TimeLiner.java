package lesson;

import java.awt.CardLayout;  
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class TimeLiner extends JFrame{

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.pack();
		new TimeLiner();
	}
	
	public TimeLiner() {
		super("Task Timer");
		setSize(700,700);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setContentPane(new Base());
		setResizable(true);
		setVisible(true);
		
		ImageIcon image = new ImageIcon("images//logo.jpeg"); //creates an ImageIcon
		this.setIconImage(image.getImage());  //change icon of this

	}
}


class Base extends JPanel{
	CardLayout cards;
	Home home;
	Help help;
	public Schedule sched;
	Timeline time;
	End end;
	public Base() {
		cards = new CardLayout();
		home = new Home(this);
		help = new Help(this);
		sched = new Schedule(this);
		time = new Timeline(this);
		end = new End(this);
		setLayout(cards);
		add(home, "home");
		add(help, "help");
		add(sched, "sched");
		add(time, "time");
		add(end, "end");
	}
	
	public void showIt(String name) {
		cards.show(this, name);

	}
	
}
