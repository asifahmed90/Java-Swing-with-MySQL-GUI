/*
UML DIAGRAM

GuiScreenControl
----------
-mean:Double
-variance:Double
-SD:Double
-max:Double
-min:Double
-median:Double
-quartile:Double

+Screen:void

 */


import javax.swing.*;
import java.awt.*;

public class GuiScreenControl extends JFrame {

    private JTextField mean;
    private JTextField variance;
    private JTextField SD;
    private JTextField max;
    private JTextField min;
    private JTextField quartile;
    private JTextField median;


    public void Screen(){


        JFrame frame = new DbAccess();
        frame.setLayout(new GridLayout(1, 3));;
        //frame.setLayout(new BorderLayout());
        frame.setTitle("Database GUI");
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        frame.setLocationByPlatform(true);


        StatsResults stats = new StatsResults();
        stats.ComputeResults();


        JPanel panel = new JPanel(new FlowLayout(SwingConstants.NORTH,20,10));
        //JPanel panel = new JPanel(new FlowLayout());
        frame.setLayout(new GridLayout(2,3));


        panel.add(new JLabel("MEAN: "));
        mean = new JTextField(10);
        mean.setBackground(Color.WHITE);
        mean.setText("0");
        mean.setEditable(false);
        panel.add(mean);

        panel.add(new JLabel("VARIANCE: "));
        variance = new JTextField(10);
        variance.setBackground(Color.WHITE);
        variance.setText("0");
        variance.setEditable(false);
        panel.add(variance);


        panel.add(new JLabel("SD: "));
        SD = new JTextField(10);
        SD.setBackground(Color.WHITE);
        SD.setText("0");
        SD.setEditable(false);
        panel.add(SD);

        panel.add(new JLabel("Maximum: "));
        max = new JTextField(10);
        max.setBackground(Color.WHITE);
        max.setText("0");
        max.setEditable(false);
        panel.add(max);

        panel.add(new JLabel("Minimum: "));
        min = new JTextField(10);
        min.setBackground(Color.WHITE);
        min.setText("0");
        min.setEditable(false);
        panel.add(min);

        panel.add(new JLabel("Quartile: "));
        quartile = new JTextField(10);
        quartile.setBackground(Color.WHITE);
        quartile.setText("0");
        quartile.setEditable(false);
        panel.add(quartile);

        panel.add(new JLabel("Median: "));
        median = new JTextField(10);
        median.setBackground(Color.WHITE);
        median.setText("0");
        median.setEditable(false);
        panel.add(median);

        CalculateListener actionListener = new CalculateListener();
        actionListener.setMean(mean);
        actionListener.setVariance(variance);
        actionListener.setSD(SD);
        actionListener.setMax(max);
        actionListener.setMin(min);
        actionListener.setQuartile(quartile);
        actionListener.setMedian(median);

        JButton b=new JButton("calculate_oilgal");
        b.setBounds(50,100,95,30);
        b.addActionListener(actionListener);

        panel.add(b);
        frame.getContentPane().add(panel);

        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}
