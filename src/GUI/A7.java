package GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.event.*;

public class A7 extends JFrame implements ChangeListener {
    private JSlider sliderA, sliderB;
    private JTextField textA, textB;

    private int chirps;
    private boolean isWest;

    public A7() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        ChangeListener chirp = new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                chirps = sliderA.getValue();
                if (isWest) {
                    textA.setText(sliderA.getValue() + " Chirps/12.5s");
                } else {
                    textA.setText(sliderA.getValue() + " Chirps/13s");
                }
                sliderB.setValue(calculate());
                textB.setText("Temperature: " + calculate() + "F");
            }
        };

        sliderA = new JSlider(JSlider.VERTICAL, 0, 60, 0);
        sliderA.setMajorTickSpacing(10);
        sliderA.setMinorTickSpacing(5);
        sliderA.setPaintTicks(true);
        sliderA.setPaintLabels(true);
        sliderA.setPreferredSize(new Dimension(50, 300));
        sliderA.addChangeListener(chirp);
        sliderA.setName("sliderA");
        textA = new JTextField(10);
        if (isWest) {
            textA.setText(sliderA.getValue() + " Chirps/12.5s");
        } else {
            textA.setText(sliderA.getValue() + " Chirps/13s");
        }
        textA.setEditable(false);

        sliderB = new JSlider(JSlider.VERTICAL, 35, 45, 40);
        sliderB.setMajorTickSpacing(1);
        sliderB.setPaintTicks(true);
        sliderB.setPaintLabels(true);
        sliderB.setPreferredSize(new Dimension(50, 300));
        sliderB.addChangeListener(this);
        sliderB.setName("Temperature");
        textB = new JTextField(10);
        textB.setText("Temperature");
        textB.setEditable(false);
        ButtonGroup l = new ButtonGroup();
        JRadioButton east = new JRadioButton("East", true);
        east.setActionCommand("e");
        JRadioButton west = new JRadioButton("West", false);
        west.setActionCommand("w");
        l.add(east);
        l.add(west);
        ActionListener dir = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isWest = e.getActionCommand().equals("w");
                if (isWest) {
                    textA.setText(sliderA.getValue() + " Chirps/12.5s");
                } else {
                    textA.setText(sliderA.getValue() + " Chirps/13s");
                }
                sliderB.setValue(calculate());
                textB.setText("Temperature: " + calculate() + "F");
            }
        };
        east.addActionListener(dir);
        west.addActionListener(dir);
        Box lBox = new Box(BoxLayout.Y_AXIS);
        lBox.add(Box.createRigidArea(new Dimension(1, 3)));
        lBox.add(east);
        lBox.add(west);

        // frame
        setLayout(new FlowLayout());
        add(lBox);
        add(textA);
        add(sliderA);
        add(textB);
        add(sliderB);
    }

    public int calculate() {
        if (isWest) {
            double ch = chirps / 12.5;
            return (int) (ch + 38);
        } else {
            double ch = chirps / 13.0;
            return (int) (ch + 40);
        }
    }

    public void stateChanged(ChangeEvent evt) {
        JSlider source;
        source = (JSlider) evt.getSource();

        if (source.getName().equals("sliderA"))
            textA.setText(source.getValue() + " ");

        if (source.getName().equals("sliderB"))
            textB.setText(source.getValue() + " ");
    }

    public static void main(String[] args) {
        A7 theApp = new A7();
        theApp.pack();
        theApp.setResizable(true);
        theApp.setVisible(true);
    }
}