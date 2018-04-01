package BackTrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * Created by Administrator on 2018/4/1.
 */
public class MaxContinuesLength {

    /**
     * 最长连续数列长度(回溯法解决)
     *
     * @param line
     * @return
     */
    public String solution(String line) {

        String[] strings = line.split(",");
        int[] numbers = new int[strings.length];
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(strings[i]);
            set.add(numbers[i]);
        }
        int pos = 0;
        int maxLength = 0;

        int[] length = new int[numbers.length];
        Arrays.fill(length, 1);

        for (int i = pos; i <numbers.length;i++){
            if (set.contains(numbers[i]+1)){
                length[i]++;
            }
            if (set.contains(numbers[i]-1)){
                length[i]++;
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0;i<length.length; i++){
            if (length[i] == 2){
                list.add(numbers[i]);
            }
        }
        for (int i=0;i<list.size()-1;i++){
            for (int j=i+1;j<list.size();j++){
                if (list.get(i).compareTo(list.get(j))>0){
                    int temp = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, temp);
                }
            }
        }

        if (list.isEmpty()){
            return 0+"";
        }else{
            maxLength = list.get(1) - list.get(0)+1;
        }
        for (int i=2;i<list.size();i+=2){
            int temp = list.get(i+1) - list.get(i)+1;
            if (temp > maxLength){
                maxLength = temp;
            }
        }
        System.out.println(maxLength);
        return ""+maxLength;
    }
}
