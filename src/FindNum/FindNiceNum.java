package FindNum;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.math.BigInteger;

/**
 * Created by Administrator on 2018/4/9.
 */
public class FindNiceNum {
    public String find(String line){
        int flag1 = 0;
        int flag2 = 0;
        java.math.BigInteger n = new java.math.BigInteger(line);
        java.math.BigInteger n1 = n.add(java.math.BigInteger.ONE);
        java.math.BigInteger n2 = n.add(new java.math.BigInteger("-1"));

        java.math.BigInteger sum = new java.math.BigInteger("1");
        if (n.equals(java.math.BigInteger.ZERO)|| n.equals(java.math.BigInteger.ONE)){
            return "Bad";
        }
        while(n1.compareTo(sum)>=0){
            if (sum.equals(n1)){
                flag2 = 1;
            }
            sum = sum.shiftLeft(1);
        }

        if ((!sum.equals("1"))&&(!sum.equals("2")))
            sum = sum.divide(new java.math.BigInteger("4"));
        else
            sum = new java.math.BigInteger("1");
        while(n2.compareTo(sum)>=0){
            if (sum.equals(n2)){
                flag1 = 1;
            }
            sum = sum.shiftLeft(1);
        }

        if (flag1==1&&flag2==1){
            return "Very Good";
        }

        if (flag1==1&&flag2!=1){
            return "Good";
        }

        if (flag1!=1&&flag2==1){
            return "Bad";
        }

        return "Normal";
    }
}
