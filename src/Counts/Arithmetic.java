package Counts;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by Administrator on 2018/4/11.
 */
public class Arithmetic {

    public static String solution(String line) {
        // 在此处理单行数据
        String[] chars = line.split(" ");
        ArrayList<Double> numbers = new ArrayList<>();
        ArrayList operation = new ArrayList();
        for (int i=0;i<chars.length;i++){
            String c = chars[i];
            if (c.equals("*") || c.equals("/")){
                Double a = (Double) numbers.get(numbers.size()-1);
                numbers.remove(numbers.size()-1);
                if (c.equals("*")) {
                    numbers.add(a * Double.parseDouble(chars[i + 1]));
                } else {
                    if (chars[i+1].equals("0")){
                        return "err";
                    }
                    numbers.add(a / Double.parseDouble(chars[i + 1]));
                }
                i++;
            } else if (c.equals("+") || c.equals("-")) {
                operation.add(c);
            } else {
                numbers.add(Double.parseDouble(String.valueOf(c)));
            }
        }
        Double sum = numbers.get(0)>numbers.get(0).intValue()?(double)numbers.get(0).intValue():numbers.get(0);
        Double temp = new Double(0);
        for (int i=0;i<operation.size();i++){
            String c = (String) operation.get(i);
            if (numbers.get(i+1) > numbers.get(i+1).intValue()){
                numbers.set(i+1, (double) numbers.get(i+1).intValue());
            }
            if (c.equals("+")){
                sum += numbers.get(i+1);
            } else {
                sum -= numbers.get(i+1);
            }
        }
        // 返回处理后的结果
        System.out.println(sum);
        return String.valueOf(sum.intValue()+((sum - sum.intValue())>=0.5?1:0));
    }
}
