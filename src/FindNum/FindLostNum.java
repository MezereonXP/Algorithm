package FindNum;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/4/3.
 */
public class FindLostNum {
    public String find(String line){
        ArrayList<Integer> list = new ArrayList<>();

        String[] s = line.split(",");
        int max = Integer.MIN_VALUE;

        for (int i=0;i<s.length;i++){
            int num = Integer.parseInt(s[i]);
            if (num>0){
                max = num>max?num:max;
                list.add(num);
            }
        }
        if (list.isEmpty())
            return "1";
        for (int i=1;i<=max;i++){
            if (list.indexOf(i)==-1){
                return i+"";
            }
        }
        return (max+1)+"";
    }
}
