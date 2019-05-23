import javax.swing.*;
import java.awt.*;

public class A1 {

	private JFrame frame;

	public A1(int x, int y, int d) {
		frame = new JFrame();
		frame.setSize(x, y);
		frame.getContentPane().add(new A11(x, y, d));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void init() {
		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		A1 frame = new A1(500, 500, 175);
		frame.init();
	}
}

class A11 extends JPanel {

	private int diameter;

	public A11(int x, int y, int d) {
		setPreferredSize(new Dimension(x, y));
		setBackground(Color.WHITE);
		diameter = d;
	}

	public void paintComponent(Graphics gr) {
		int width = getWidth();
		int height = getHeight();
		super.paintComponent(gr);

		// Top Left
		gr.setColor(Color.BLUE);
		gr.drawOval((width / 4) - (diameter / 2), (height / 4) - (diameter / 2), diameter, diameter);

		// Top Right
		gr.setColor(Color.BLACK);
		gr.drawOval(((3 * width) / 4) - (diameter / 2), (height / 4) - (diameter / 2), diameter, diameter);

		// Bottom Left
		gr.setColor(Color.RED);
		gr.drawOval((width / 4) - (diameter / 2), ((3 * height) / 4) - (diameter / 2), diameter, diameter);

		// Bottom Right
		gr.setColor(Color.CYAN);
		gr.drawOval(((3 * width) / 4) - (diameter / 2), ((3 * height) / 4) - (diameter / 2), diameter, diameter);

	}

}