import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class A3 {

	private JFrame frame;

	public static void main(String[] args) {
		A3 window = new A3();
		window.frame.setVisible(true);
	}

	public A3() {
		frame = new JFrame();
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		init();
	}

	public void init() {
		color();
		Random randNum = new Random();
		ActionListener play = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				youLose(randNum.nextInt(3));
			}
		};

		JButton b1 = new JButton("1");
		b1.addActionListener(play);
		b1.setBounds(10, 10, 100, 50);
		frame.getContentPane().add(b1);

		JButton b2 = new JButton("2");
		b2.addActionListener(play);
		b2.setBounds(155, 10, 100, 50);
		frame.getContentPane().add(b2);

		JButton b3 = new JButton("3");
		b3.addActionListener(play);
		b3.setBounds(300, 10, 100, 50);
		frame.getContentPane().add(b3);
	}

	public void youLose(int in) {
		if (in == 0) {
			System.exit(0);
		} else {
			color();
		}
	}

	public void color() {
		Random randNum = new Random();
		float r = randNum.nextFloat();
		float g = randNum.nextFloat();
		float b = randNum.nextFloat();
		frame.getContentPane().setBackground(new Color(r, g, b));
	}

}
