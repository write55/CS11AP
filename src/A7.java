import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

public class A7 extends JFrame implements ChangeListener {
    JSlider sliderA, sliderB;
    JTextField textA, textB;

    public A7() {
        setTitle("Change Listener");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        sliderA = new JSlider(JSlider.HORIZONTAL, 0, 1000, 400);
        sliderA.setMajorTickSpacing(100);
        sliderA.setMinorTickSpacing(50);
        sliderA.setPaintTicks(true);
        sliderA.setPaintLabels(true);
        sliderA.setPreferredSize(new Dimension(300, 50));
        sliderA.addChangeListener(this);
        sliderA.setName("sliderA");
        textA = new JTextField(4);
        textA.setText(sliderA.getValue() + " ");

        sliderB = new JSlider(JSlider.HORIZONTAL, 0, 1000, 400);
        sliderB.setMajorTickSpacing(100);
        sliderB.setMinorTickSpacing(50);
        sliderB.setPaintTicks(true);
        sliderB.setPaintLabels(true);
        sliderB.setPreferredSize(new Dimension(300, 50));
        sliderB.addChangeListener(this);
        sliderB.setName("sliderB");
        textB = new JTextField(4);
        textB.setText(sliderB.getValue() + " ");

        // frame
        setLayout(new FlowLayout());
        add(textA);
        add(sliderA);
        add(textB);
        add(sliderB);
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
        theApp.setSize(400, 150);
        theApp.setResizable(false);
        theApp.setVisible(true);
    }
}