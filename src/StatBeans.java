
/*
UML DIAGRAM

StateBeans
----------

+computeMean(ArrayList<Double>):double
+computeVariance(ArrayList<Double>):double
+computeSD(ArrayList<Double>):double
+maxNumber(ArrayList<Double>):double
+minNumber(ArrayList<Double>):double
+computeQuartile(ArrayList<Double>):double
+medianNumber(ArrayList<Double>):double
+computeInterQuartileRange(ArrayList<Double>):double

 */



import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class StatBeans {



    public double computeMean(ArrayList<Double> xarray) //we're passing array x[]
    {

        double sum =0.0;
        double mean =0.0;

        for (int i=0; i<xarray.size() ; i++)
        {
            sum += xarray.get(i);

            mean = sum/xarray.size();
        }
        System.out.println(mean);

        return mean;
    }

    public double computeVariance(ArrayList<Double> xarray)
    {
        double variance=0;
        double mean = computeMean(xarray);
        double sumDiff=0.0;
        for (int i=0; i<xarray.size() ; i++)
        {
            sumDiff += Math.pow((xarray.get(i)-mean),2);
        }
        variance = sumDiff/(xarray.size()-1);
        return variance;
    }

    public double computeSD(ArrayList<Double> xarray)
    {
        double standardDev =0;
        double variance = computeVariance(xarray);

        standardDev = Math.sqrt(variance);

        return standardDev;
    }

    public double maxNumber(ArrayList<Double> xarray)
    {
        double maximum =0.0;
        for (int i=0; i<xarray.size() ; i++)
            if(xarray.get(i) > maximum)
                maximum = xarray.get(i);
        //System.out.println(maximum);
        return maximum;

    }


    public double minNumber(ArrayList<Double> xarray)
    {
        Collections.sort(xarray);
        return (xarray.get(0));

    }

    public double[] computeQuartile(ArrayList<Double> xarray)
    {

        double dataPos[]= {0.0,0.0};
        Collections.sort(xarray);
        int Index = (int)Math.ceil(((double)25 / (double)100) * (double)xarray.size());
        dataPos[0]=xarray.get(Index-1);
        Index = (int)Math.ceil(((double)75 / (double)100) * (double)xarray.size());
        dataPos[1]=xarray.get(Index-1);
        return dataPos;

    }

    public double medianNumber (ArrayList<Double> xarray)
    {

        // First we sort the array
        Collections.sort(xarray);

        // check for even case
        if (xarray.size() % 2 != 0)

            return (xarray.get(xarray.size()/2)-1)+ xarray.get(xarray.size()/2)/2.0;
        else
            return (xarray.get(xarray.size()/2));
    }

    public double computeInterQuartileRange(ArrayList<Double> xarray)
    {
        double temp[]= computeQuartile(xarray);
        return (temp[1]-temp[0]);
    }




    public StatBeans() {
        // TODO Auto-generated constructor stub
    }

}
