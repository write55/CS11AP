import javax.swing.*;
import java.awt.*;

public class A2 {

	private JFrame frame;

	public A2(int x, int y) {
		frame = new JFrame();
		frame.setSize(x, y);
		frame.getContentPane().add(new A21(x, y));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void init() {
		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		A2 frame = new A2(500, 500);
		frame.init();
	}
}

class A21 extends JPanel {

	public A21(int x, int y) {
		setPreferredSize(new Dimension(x, y));
		setBackground(Color.WHITE);
	}

	public void paintComponent(Graphics gr) {
		int width = getWidth();
		int height = getHeight();
		super.paintComponent(gr);
		// GROUND
		gr.setColor(Color.BLACK);
		gr.drawLine(0, height / 2, width, height / 2);
		// FEET
		gr.setColor(Color.BLACK);
		gr.drawOval(155, 290, 190, 190);
		// BODY
		gr.setColor(Color.BLACK);
		gr.drawOval(175, 200, 150, 150);
		gr.setColor(Color.WHITE);
		gr.fillOval(177, 202, 147, 147);
		// HEAD
		gr.setColor(Color.BLACK);
		gr.drawOval(190, 100, 120, 120);
		gr.setColor(Color.WHITE);
		gr.fillOval(192, 102, 117, 117);
		// EYES
		gr.setColor(Color.BLACK);
		gr.fillOval(220, 130, 10, 10);
		gr.fillOval(275, 130, 10, 10);
		// BUTTONS
		gr.fillOval(245, 240, 8, 8);
		gr.fillOval(245, 270, 8, 8);
		gr.fillOval(245, 300, 8, 8);

	}

}