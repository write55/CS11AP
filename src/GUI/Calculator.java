package GUI;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class Calculator {

	double n1 = 0;
	double n2 = 0;
	double result = 0;
	char op;

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculator window = new Calculator();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Calculator() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton button = new JButton("0");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText() + "0");
			}
		});
		button.setBounds(62, 233, 46, 39);
		frame.getContentPane().add(button);

		JButton button_1 = new JButton("1");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText() + "1");
			}
		});
		button_1.setBounds(6, 182, 46, 39);
		frame.getContentPane().add(button_1);

		JButton button_2 = new JButton("2");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText() + "2");
			}
		});
		button_2.setBounds(62, 182, 46, 39);
		frame.getContentPane().add(button_2);

		JButton button_3 = new JButton("3");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText() + "3");
			}
		});
		button_3.setBounds(120, 182, 46, 39);
		frame.getContentPane().add(button_3);

		JButton button_4 = new JButton("4");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText() + "4");
			}
		});
		button_4.setBounds(6, 131, 46, 39);
		frame.getContentPane().add(button_4);

		JButton button_5 = new JButton("5");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText() + "5");
			}
		});
		button_5.setBounds(62, 131, 46, 39);
		frame.getContentPane().add(button_5);

		JButton button_6 = new JButton("6");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText() + "6");
			}
		});
		button_6.setBounds(120, 131, 46, 39);
		frame.getContentPane().add(button_6);

		JButton button_7 = new JButton("7");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText() + "7");
			}
		});
		button_7.setBounds(6, 80, 46, 39);
		frame.getContentPane().add(button_7);

		JButton button_8 = new JButton("8");
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText() + "8");
			}
		});
		button_8.setBounds(62, 80, 46, 39);
		frame.getContentPane().add(button_8);

		JButton button_9 = new JButton("9");
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText() + "9");
			}
		});
		button_9.setBounds(120, 80, 46, 39);
		frame.getContentPane().add(button_9);

		JButton button_10 = new JButton("=");
		button_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				n2 = Double.parseDouble(textField.getText());

				switch (op) {
				case '+':
					result = n1 + n2;
					break;
				case '-':
					result = n1 - n2;
					break;
				case 'x':
					result = n1 * n2;
					break;
				case '/':
					result = n1 / n2;
					break;
				}

				textField.setText(result + "");
			}
		});
		button_10.setBounds(347, 233, 97, 39);
		frame.getContentPane().add(button_10);

		JButton button_11 = new JButton("/");
		button_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				n1 = Double.parseDouble(textField.getText());
				op = '/';
				textField.setText("");
			}
		});
		button_11.setBounds(347, 187, 97, 39);
		frame.getContentPane().add(button_11);

		JButton button_12 = new JButton("x");
		button_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				n1 = Double.parseDouble(textField.getText());
				op = 'x';
				textField.setText("");
			}
		});
		button_12.setBounds(347, 136, 97, 39);
		frame.getContentPane().add(button_12);

		JButton button_13 = new JButton("-");
		button_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				n1 = Double.parseDouble(textField.getText());
				op = '-';
				textField.setText("");
			}
		});
		button_13.setBounds(347, 85, 97, 39);
		frame.getContentPane().add(button_13);

		JButton button_14 = new JButton("+");
		button_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				n1 = Double.parseDouble(textField.getText());
				op = '+';
				textField.setText("");
			}
		});
		button_14.setBounds(347, 34, 97, 39);
		frame.getContentPane().add(button_14);

		textField = new JTextField();
		textField.setBounds(6, 6, 326, 62);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
			}
		});
		btnClear.setBounds(218, 233, 117, 39);
		frame.getContentPane().add(btnClear);
	}
}