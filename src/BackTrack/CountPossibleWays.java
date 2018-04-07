package BackTrack;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by Administrator on 2018/4/7.
 */
public class CountPossibleWays {

    // 给出一组不重复的正整数
    // 从这组数中找出所有可能的组合使其加合等于一个目标正整数 N
    public String count(String line){
        String[] nums = line.split(" ")[0].split(",");
        int n = Integer.parseInt(line.split(" ")[1]);
        ArrayList numbers = new ArrayList();

        for (int i=0;i<nums.length;i++){
            numbers.add(Integer.parseInt(nums[i]));
        }
        int counts = 0;
        int sum = 0;
        Stack stack = new Stack();
        stack.push(numbers.get(0));
        sum += (int)stack.peek();
        int flag = -1;
        while (!stack.isEmpty()){

            if (flag==(numbers.size()-1)){
                sum -= (int)stack.peek();
                flag = numbers.indexOf(stack.peek());
                stack.pop();
            }
            if (sum<n&&flag==-1&&flag<(numbers.size()-1)){
                stack.push(numbers.get(0));
                sum += (int)stack.peek();
            }
            if (sum<n&&flag!=-1&&flag<(numbers.size()-1)){
                stack.push(numbers.get(flag+1));
                sum += (int)stack.peek();
                flag = -1;
            }
            if (sum>n&&flag<(numbers.size()-1)){
                sum -= (int)stack.peek();
                flag = numbers.indexOf(stack.peek());
                stack.pop();
            }
            if (sum==n&&flag<(numbers.size()-1)){
                counts++;
                sum -= (int)stack.peek();
                flag = numbers.indexOf(stack.peek());
                stack.pop();
            }

        }

        return ""+counts;
    }
}
