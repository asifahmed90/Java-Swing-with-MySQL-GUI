/*
UML DIAGRAM

StatsResults
----------
-firstMean:Double
-firstVariance:Double
-firstSD:Double
-firstMax:Double
-firstMin:Double
-firstMedian:Double
-firstQuartile:Double

+ComputeResult: void
+getFirstMean: double
+getFirstVariance: double
+getFirstSD:double
+getFirstMax:double
+getFirstMin:double
+getFirstMedian:double
+getFirstQuartile:double

 */

import java.util.ArrayList;

public class StatsResults {
    private double firstMean;
    private double firstVariance;
    private double firstSD;
    private double firstMax;
    private double firstMin;
    private double firstMedian;
    private double firstQuartile;


    public void ComputeResults(){


        DbAccess db = new DbAccess();
        ArrayList<Double> first = db.firstColumn();

        StatBeans stats = new StatBeans();

        firstMean = stats.computeMean(first);
        firstVariance = stats.computeVariance(first);
        firstSD = stats.computeSD(first);
        firstMax = stats.maxNumber(first);
        firstMin = stats.minNumber(first);
        firstMedian = stats.medianNumber(first);
        firstQuartile = stats.computeInterQuartileRange(first);

        ArrayList<Double> second = db.secondColumn();

        double secondMean = stats.computeMean(second);
        double secondVariance = stats.computeVariance(second);
        double secondSD = stats.computeVariance(second);

        ArrayList<Double> third = db.thirdColumn();

        double thirdMean = stats.computeMean(third);
        double thirdVariance = stats.computeVariance(third);
        double thirdSD = stats.computeVariance(third);
    }

    public double getFirstMean() {
        return firstMean;
    }

    public double getFirstVariance() {
        return firstVariance;
    }

    public double getFirstSD() {
        return firstSD;
    }

    public double getFirstMax() {
        return firstMax;
    }

    public double getFirstMin() {
        return firstMin;
    }

    public double getFirstMedian() {
        return firstMedian;
    }

    public double getFirstQuartile() {
        return firstQuartile;
    }
}
