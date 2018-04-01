package BackTrack;

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
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(strings[i]);
        }
        int pos = 0;
        int maxLength = 1;

        for (int i = pos; i <numbers.length-1;i++){
            if (numbers[i]-numbers[i+1]!=1&&numbers[i]>numbers[i+1]){
                int temp = numbers[i];
                numbers[i] = numbers[i+1];
                numbers[i+1] = temp;
            }
        }
        return "";
    }
}
