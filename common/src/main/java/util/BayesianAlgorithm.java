package util;

import java.util.List;

/**
 * Created by saeed on 4/14/2016.
 */
public class BayesianAlgorithm implements AverageAlgorithm {
    @Override
    public double calculate(List<RateValue> inputList) {
        double retCalculatedValue=0;
        double totalSum=0;
        double totalCount=0;
        for(RateValue  item:inputList)
        {
            totalCount+=item.getCount();
            double itemValue=item.getValue()*item.getCount();
            totalSum+=totalSum+itemValue;

        }
        if(totalCount>0)
        {
            retCalculatedValue=totalSum/totalCount;
        }
        return  retCalculatedValue;



    }
}
