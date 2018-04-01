package FindNum;

import java.util.Arrays;

/**
 * Created by Administrator on 2018/4/1.
 */
public class FindNumInRotateArray {

    public String solution(String line) {
        String[] numbers = line.split(",");
        int pos = 0;
        for (int i=0;i<numbers.length-1;i++){
            int currentNum = Integer.parseInt(numbers[i]);
            int nextNum = Integer.parseInt(numbers[i+1]);
            if (currentNum>nextNum){
                pos = i;
                break;
            }
        }

        int roateLength = numbers.length-1-pos;
        int originNumPos = (numbers.length+1)/2;
        if (pos == 0){
            return numbers[originNumPos-1];
        }
        int currentNumPos = originNumPos>roateLength?originNumPos-roateLength-1:numbers.length+originNumPos-roateLength-1;
        return numbers[currentNumPos];
    }
}
