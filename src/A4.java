import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class A4 {

	private JFrame frame;
	private JTextField tx1;
	private JLabel l1;
	private JTextField tx2;
	private JLabel l2;
	private int count = 0;

	public static void main(String[] args) {
		A4 window = new A4();
		window.frame.setVisible(true);
		if (window.count == 3) {
			System.exit(0);
		}
	}

	public A4() {
		frame = new JFrame();
		frame.setSize(250, 250);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new FlowLayout());
		init();
	}

	public void init() {
		tx1 = new JTextField();
		tx1.setColumns(20);
		l1 = new JLabel("Top");
		frame.getContentPane().add(l1);
		frame.getContentPane().add(tx1);

		tx2 = new JTextField();
		tx2.setColumns(20);
		l2 = new JLabel("Bottom");
		frame.getContentPane().add(l2);
		frame.getContentPane().add(tx2);

	}
}
