package FindNum;

import java.math.BigDecimal;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Created by Administrator on 2018/4/3.
 */
public class FindUglyNum {

    //Ugly number is 1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, 16
    public String find(String line){
        int n = Integer.parseInt(line);
        double[] numbers = new double[n];
        numbers[0] = 1;

        double t2 = 0;
        double t3 = 0;
        double t5 = 0;
        for (int i=1;i<numbers.length;i++){
            double p = numbers[i-1];
            //find t2
            for (int j=0;j<i;j++){
                double temp = numbers[j]*2;
                if (temp > p){
                    t2 = temp;
                    break;
                }
            }
            for (int j=0;j<i;j++){
                double temp = numbers[j]*3;
                if (temp > p){
                    t3 = temp;
                    break;
                }
            }
            for (int j=0;j<i;j++){
                double temp = numbers[j]*5;
                if (temp > p){
                    t5 = temp;
                    break;
                }
            }
            double t = t2>t3?t3:t2;
            t = t>t5?t5:t;
            numbers[i] = t;
        }
        return new java.text.DecimalFormat("#").format(numbers[n-1])+"";

    }
}
