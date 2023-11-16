package lesson;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class End extends JPanel implements ActionListener {
Message ma;
JButton b;
Base base;
String s;
int h;
int m;

public End(Base ba) {
	base = ba;
	setLayout(new BorderLayout());
}

public void setValues(String sa, int ha, int mar) {
	s = sa;
	h = ha;
	m = mar;
	ma = new Message(s, h, m);
	b = new JButton("Go back to home");
	b.addActionListener(this);
	add(b, BorderLayout.SOUTH);
	add(ma, BorderLayout.CENTER);
}

public void actionPerformed(ActionEvent e) {
	base.showIt("home");
}
}
class Message extends JPanel{
	String message;
	int hours;
	int minutes;
	
	public Message(String s, int h, int m) {
		message = s;
		hours = h;
		minutes = m;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawString("You have " + message + " " + hours + " hours and " + minutes + " minutes.", (getWidth()/2)-10, getHeight()/2);
	}
}
