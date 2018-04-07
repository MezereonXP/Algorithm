package BackTrack;

/**
 * Created by Administrator on 2018/4/7.
 */
public class CountPossibleWays {

    // 给出一组不重复的正整数
    // 从这组数中找出所有可能的组合使其加合等于一个目标正整数 N
    public String count(String line){
        String[] nums = line.split(" ")[0].split(",");
        int n = Integer.parseInt(line.split(" ")[1]);
        int[] numbers = new int[nums.length];
        for (int i=0;i<numbers.length;i++){
            numbers[i] = Integer.parseInt(nums[i]);
        }
        int[] counts = new int[numbers.length];


        return "";
    }
}
