package lesson;


import java.awt.BorderLayout;  
import java.awt.CardLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JPanel;

public class Home extends JPanel {
	Base base;
	Intro intro;
	Buttons bottons;
	
	public Home(Base b) {
	base = b;
	intro = new Intro(base);
	bottons = new Buttons(base);
	setLayout(new BorderLayout());
	add(bottons, BorderLayout.SOUTH);
	add(intro, BorderLayout.CENTER);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
	}
	class Intro extends JPanel{
		Base base;
		JPanel blankPanel, textPanel;
		Image img;
		public Intro(Base b) {
			setLayout(new GridLayout(2,1));
			base = b;
			textPanel = new DisplayText();
			img = Toolkit.getDefaultToolkit().getImage("images//TimePics.jpg");
			JPanel imgr = new JPanel() {
				public void paintComponent(Graphics g) {
					super.paintComponent(g);
					g.drawImage(img, 230, 0, 800, 300, this);
				}
			};
			add(textPanel);
			add(imgr);
		}
	}
	
	class DisplayText extends JPanel{
		JLabel title, subtitle, desc;
		Font titleFont, subtitleFont, descFont;
		public DisplayText() {
			setLayout(new GridLayout(3,1));
			title = new JLabel("Task Timer", SwingConstants.CENTER);
			titleFont = new Font("Verdana", Font.PLAIN, 35);
			title.setFont(titleFont);
			add(title);
			subtitle = new JLabel("Task management made easy", SwingConstants.CENTER);
			subtitleFont = new Font("Verdana", Font.PLAIN, 23);
			subtitle.setFont(subtitleFont);
			add(subtitle);
			desc = new JLabel("<html>Task-Timer helps you increase your productivity"
					+ " by focusing <br>on individual tasks, one at a time.</html>", SwingConstants.CENTER);
			descFont = new Font("Verdana", Font.PLAIN, 16);
			desc.setFont(descFont);
			add(desc);
		}
	}
	class Buttons extends JPanel implements ActionListener{
		Base base;
		JButton begin;
		JButton help;
		public Buttons(Base b) {
			base = b;
			setLayout(new GridLayout(1,2));
			begin = new JButton("Start now");
			help = new JButton("Help page");
			begin.addActionListener(this);
			help.addActionListener(this);
			add(begin);
			add(help);
		}
		
		public void actionPerformed(ActionEvent e) {
			requestFocus();
			if(e.getSource() == begin) {
				base.showIt("sched");
			}
			else {
				base.showIt("help");
			}
		}
	}

}
