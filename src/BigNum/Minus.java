package BigNum;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2018/4/1.
 */
public class Minus {

    //大数相减
    public String solution(String line) {
        // 在此处理单行数据
        String[] numbers = line.split("-");
        int lengthA = numbers[0].trim().length();
        int lengthB = numbers[1].trim().length();
        int maxLength = Math.max(lengthA, lengthB);
        int[][] num = new int[2][maxLength];
        Arrays.fill(num[0], 0);
        Arrays.fill(num[1], 0);

        for (int i = 0; i < numbers.length; i++) {
            String item = numbers[i].trim();
            char[] chars = item.toCharArray();
            int position = chars.length - 1;
            for (int j = num[i].length - 1; j >= 0; j--) {
                num[i][j] = Integer.parseInt(String.valueOf(chars[position]));
                position--;
                if (position < 0) {
                    break;
                }
            }
        }

        int[] cost = new int[maxLength];
        int[] result = new int[maxLength];
        String re = "";
        for (int j = maxLength - 1; j >= 0; j--) {
            int a = num[0][j];
            int b = num[1][j];
            if (a > b){
                result[j] = a - b;
            }else if (a < b){
                num[0][j-1]--;
                a += 10;
                result[j] = a - b;
            }else {
                result[j] = 0;
            }
            re = result[j] + re;
        }

        return re;
    }
}
