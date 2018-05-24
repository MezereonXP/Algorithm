package DP;

/**
 * Created by Administrator on 2018/4/1.
 */
public class Stairs {

    public String solution(String line) {
        int length = Integer.parseInt(line);
        if (length == 1){
            return "1";
        }
        if (length == 2){
            return "2";
        }
        if (length == 0){
            return "0";
        }
        int times = Integer.parseInt(solution(length-1+"")) + Integer.parseInt(solution(length-2+""));
        System.out.println(times);
        return times+"";
    }
}
