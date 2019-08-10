
/*
UML DIAGRAM

CalculateListener
----------
-mean:Double
-variance:Double
-SD:Double
-max:Double
-min:Double
-median:Double
-quartile:Double

+CalculateListener:void
+actionPerformed(ActionEvent):void
+setMean(mean):void
+setVariance(variance):void
+setSD(SD):void
+setMin(min):void
+setQuartile(quartile):void
+setMedian(median):void

 */


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CalculateListener implements ActionListener {
    private JTextField mean;
    private JTextField variance;
    private JTextField SD;
    private JTextField max;
    private JTextField min;
    private JTextField quartile;
    private JTextField median;

    public  CalculateListener(){
        //TODO Auto Generate constructor stub
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        StatsResults results = new StatsResults();
        results.ComputeResults();

        switch(action.toLowerCase()){
            case "calculate_oilgal":

                double resMean = results.getFirstMean();
                mean.setText(Double.toString(resMean));

                double resVariance = results.getFirstVariance();
                variance.setText(Double.toString(resVariance));

                double resSD = results.getFirstSD();
                SD.setText(Double.toString(resSD));

                double resMax = results.getFirstMax();
                max.setText(Double.toString(resMax));

                double resMin = results.getFirstMin();
                min.setText(Double.toString(resMin));

                double resQuart = results.getFirstQuartile();
                quartile.setText(Double.toString(resQuart));

                double resMedian = results.getFirstMedian();
                median.setText(Double.toString(resMedian));

//            case "calculate_temperature":
//                double secondMean = results.getFirstMax();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + action.toLowerCase());
        }

    }

    public void setMean(JTextField mean) {
        this.mean = mean;
    }

    public void setVariance(JTextField variance) {
        this.variance = variance;
    }

    public void setSD(JTextField SD) {
        this.SD = SD;
    }

    public void setMax(JTextField max) {
        this.max = max;
    }

    public void setMin(JTextField min) {
        this.min = min;
    }

    public void setQuartile(JTextField quartile) {
        this.quartile = quartile;
    }

    public void setMedian(JTextField median) {
        this.median = median;
    }
}

