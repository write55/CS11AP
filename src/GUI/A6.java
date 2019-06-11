package GUI;

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

    boolean isMale = true;
    double h = 62.0;
    String output = "";

    public A6() {
        setTitle("Your Ideal Weight");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // gender group
        genderM = new JRadioButton("Male", true);
        genderF = new JRadioButton("Female", false);
        genderM.setActionCommand("male");
        genderF.setActionCommand("female");
        genderGroup = new ButtonGroup();
        ActionListener gender = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isMale = e.getActionCommand().equals("male");
                calculate();
                resultText.setText(output);
            }
        };
        genderM.addActionListener(gender);
        genderF.addActionListener(gender);
        genderGroup.add(genderM);
        genderGroup.add(genderF);

        genderBox = new Box(BoxLayout.Y_AXIS);
        genderBox.add(Box.createRigidArea(new Dimension(1, 53)));
        genderBox.add(Box.createVerticalGlue());
        genderBox.add(Box.createHorizontalGlue());
        genderBox.add(new JLabel("Your Gender"));
        genderBox.add(genderM);
        genderBox.add(genderF);
        genderBox.add(Box.createVerticalGlue());
        genderBox.add(Box.createHorizontalGlue());
        genderBox.add(Box.createRigidArea(new Dimension(1, 73)));

        // height group
        heightA = new JRadioButton("60 to 64 inches", true);
        heightB = new JRadioButton("64 to 68 inches", false);
        heightC = new JRadioButton("68 to 72 inches", false);
        heightD = new JRadioButton("72 to 76 inches", false);
        heightE = new JRadioButton("76 to 80 inches", false);
        heightA.setActionCommand("62");
        heightB.setActionCommand("66");
        heightC.setActionCommand("70");
        heightD.setActionCommand("74");
        heightE.setActionCommand("78");

        ActionListener height = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                h = new Double(e.getActionCommand());
                calculate();
                resultText.setText(output);
            }
        };
        heightA.addActionListener(height);
        heightB.addActionListener(height);
        heightC.addActionListener(height);
        heightD.addActionListener(height);
        heightC.addActionListener(height);
        heightD.addActionListener(height);
        heightE.addActionListener(height);

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

    public void calculate() {
        try {
            if (isMale) {
                double i = (h * h) / 28.0;
                i = Math.round(i * 100.0) / 100.0;
                output = Double.toString(i);
            } else {
                double i = (h * h) / 30.0;
                i = Math.round(i * 100.0) / 100.0;
                output = Double.toString(i);
            }
        } catch (Exception e) {
        }
    }

    public static void main(String[] args) {
        A6 weightApp = new A6();
        weightApp.pack();
        weightApp.setResizable(true);
        weightApp.setVisible(true);
    }
}