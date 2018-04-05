package Counts;

/**
 * Created by Administrator on 2018/4/5.
 */
public class CountSwapTimes {

    /**
     * 计算最少交换次数
     * @param line 按逗号分隔的数列
     * @return
     */
    public String solution(String line) {
        String[] strings = line.split(",");
        int[] numbers = new int[strings.length];
        for (int i=0;i<numbers.length;i++){
            numbers[i] = Integer.parseInt(strings[i]);
        }
        int counts = 0;
        for (int i=0;i<numbers.length-1;i++){
            if (numbers[i]>numbers[i+1]){
                counts++;
                int temp = numbers[i];
                numbers[i] = numbers[i+1];
                numbers[i+1] = temp;
                if (i != 0)
                    i -= 2;
            }
        }
        return ""+counts;
    }
}
