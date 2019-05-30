import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class A4 {

    private JFrame frame;
    private JTextField tx1;
    private JTextField tx2;
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
        frame.setSize(150, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout());
        init();
    }

    public void init() {
        ActionListener one = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tx2.setText(tx1.getText());
                tx1.setText("");
            }
        };
        ActionListener two = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tx2.setText("Enter text in the top field");
            }
        };

        JPanel nest1 = new JPanel();
        tx1 = new JTextField(15);
        tx1.addActionListener(one);
        JLabel l1 = new JLabel("Top");
        nest1.add(l1);
        nest1.add(tx1);

        JPanel nest2 = new JPanel();
        tx2 = new JTextField(15);
        tx2.addActionListener(two);
        JLabel l2 = new JLabel("Bottom");
        nest2.add(l2);
        nest2.add(tx2);

        frame.add(nest1, BorderLayout.NORTH);
        frame.add(nest2, BorderLayout.SOUTH);
    }

}
