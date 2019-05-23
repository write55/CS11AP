import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class A3 {

	private JFrame frame;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					A3 window = new A3();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public A3() {
		frame = new JFrame();
		frame.setSize(500,500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(new A31(500,500));

		init();
	}

	public void init() {
		Random randNum = new Random();
		JButton b1 = new JButton("1");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				youLose(randNum.nextInt(3));
			}
		});
		b1.setBounds(10, 10, 46, 39);
		frame.getContentPane().add(b1);
	}

	public void youLose(int in) {
		if (in == 0) {
			System.exit(0);
		} else {
		}
	}

}

class A31 extends JPanel {

	public A31(int x, int y) {
		setPreferredSize(new Dimension(x, y));
		setBackground(Color.WHITE);
	}

	public void color() {
		Random randNum = new Random();
		float r = randNum.nextFloat();
		float g = randNum.nextFloat();
		float b = randNum.nextFloat();
		setBackground(new Color(r, g, b));
	}

	public void paintComponent(Graphics gr) {
		int width = getWidth();
		int height = getHeight();
		super.paintComponent(gr);
	}
}