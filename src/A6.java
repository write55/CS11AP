import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class A6 extends JFrame {
	JRadioButton genderM, genderF;
	ButtonGroup genderGroup;
	Box genderBox;

	JRadioButton heightA, heightB, heightC, heightD, heightE;
	ButtonGroup heightGroup;
	Box heightBox;

	Box buttonBox;

	JTextField resultText;
	JLabel resultLabl;
	JPanel resultPanel;

	public A6() {
		setTitle("Your Ideal Weight");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// gender group
		genderM = new JRadioButton("Male", true);
		genderF = new JRadioButton("Female", false);
		genderGroup = new ButtonGroup();
		genderGroup.add(genderM);
		genderGroup.add(genderF);

		genderBox = new Box(BoxLayout.Y_AXIS);
		genderBox.add(new JLabel("Your Gender"));
		genderBox.add(Box.createRigidArea(new Dimension(1, 8)));
		genderBox.add(genderM);
		genderBox.add(genderF);
		genderBox.add(Box.createRigidArea(new Dimension(1, 73)));

		// height group
		heightA = new JRadioButton("60 to 64 inches", true);
		heightB = new JRadioButton("64 to 68 inches", false);
		heightC = new JRadioButton("68 to 72 inches", false);
		heightD = new JRadioButton("72 to 76 inches", false);
		heightE = new JRadioButton("76 to 80 inches", false);

		heightGroup = new ButtonGroup();
		heightGroup.add(heightA);
		heightGroup.add(heightB);
		heightGroup.add(heightC);
		heightGroup.add(heightD);
		heightGroup.add(heightE);

		heightBox = new Box(BoxLayout.Y_AXIS);
		heightBox.add(new JLabel("Your Height"));
		heightBox.add(Box.createRigidArea(new Dimension(1, 8)));
		heightBox.add(heightA);
		heightBox.add(heightB);
		heightBox.add(heightC);
		heightBox.add(heightD);
		heightBox.add(heightE);

		// button Box
		buttonBox = new Box(BoxLayout.X_AXIS);
		buttonBox.add(Box.createVerticalGlue());
		buttonBox.add(Box.createHorizontalGlue());
		buttonBox.add(genderBox);
		buttonBox.add(Box.createHorizontalGlue());
		buttonBox.add(heightBox);
		buttonBox.add(Box.createHorizontalGlue());
		buttonBox.add(Box.createVerticalGlue());

		// result panel
		resultText = new JTextField(7);
		resultText.setEditable(false);
		resultLabl = new JLabel("Ideal Weight");
		resultPanel = new JPanel();
		resultPanel.add(resultLabl);
		resultPanel.add(resultText);

		// Frame
		setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		add(buttonBox);
		add(resultPanel);
	}

	public static void main(String[] args) {
		A6 weightApp = new A6();
		weightApp.setSize(250, 225);
		weightApp.setResizable(true);
		weightApp.setVisible(true);
	}
}