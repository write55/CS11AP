package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class A5 {

    private JFrame frame;
    private JTextField tx1;
    private JTextField tx2;

    public static void main(String[] args) {
        A5 window = new A5();
        window.frame.setVisible(true);
    }

    public A5() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout());
        init();
        frame.pack();
    }

    public void init() {
        frame.add(createNest1(), BorderLayout.WEST);
        frame.add(createNest2(), BorderLayout.EAST);
        frame.add(createNest3(), BorderLayout.SOUTH);
    }

    public JPanel createNest1() {
        JPanel nest1 = new JPanel();
        tx1 = new JTextField(15);
        JLabel l1 = new JLabel("Input");
        nest1.add(l1);
        nest1.add(tx1);
        return nest1;
    }

    public JPanel createNest2() {
        JPanel nest2 = new JPanel();
        tx2 = new JTextField(15);
        tx2.setEditable(false);
        JLabel l2 = new JLabel("Output");
        nest2.add(l2);
        nest2.add(tx2);
        return nest2;
    }

    public JPanel createNest3() {
        ActionListener convertFC = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Double f = Double.parseDouble(tx1.getText());
                double c = (f - 32) * (5.0 / 9);
                c = Math.round(c * 100.0) / 100.0;
                tx2.setText(c + " degrees C");
            }
        };
        ActionListener convertCF = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Double c = Double.parseDouble(tx1.getText());
                double f = (c * (9.0 / 5)) + 32;
                f = Math.round(f * 100.0) / 100.0;
                tx2.setText(f + " degrees F");
            }
        };
        ActionListener clear = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tx1.setText("");
                tx2.setText("");
            }
        };

        JPanel nest3 = new JPanel();
        JButton fc = new JButton("Convert F to C");
        fc.addActionListener(convertFC);
        JButton cf = new JButton("Convert C to F");
        cf.addActionListener(convertCF);
        JButton cl = new JButton("Clear");
        cl.addActionListener(clear);
        nest3.add(fc);
        nest3.add(cf);
        nest3.add(cl);
        return nest3;
    }
}
