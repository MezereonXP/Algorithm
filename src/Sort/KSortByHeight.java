package Sort;/**
 * Created by Administrator on 2018/5/19.
 */

import tool.Tool;

/**
 * @program: KSortByHeight
 * @description: To solve k sort problem
 * @author: mezereonxp Email: mezereonxp@gmail.com
 * @create: 2018/5/19
 **/

public class KSortByHeight {

    public static void main(String[] args) {
        Tool.displayResult(solution("[[7,0],[4,4],[7,1],[5,3],[6,1],[5,2]]"));
    }

    /*
        描述
        用一个数组表示一群正在排队的小学生，每个小学生用一对整数来表示 [height, k], height 表示这个小学生的身高，k 表示这个小学生前面应该有 k 个人的身高 >= 他。

        写一个算法，对给出的一组小学生计算出符合描述的正确排序。

        输入
        一行文本如：[[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]，格式为 JSON（算法中可使用 JSON decode 得到数组）。

        可以发现该序列不满足描述的条件，比如 [4,4] ：4 前面只有一个 7 大于 4。

        输出
        根据输入，重新排列数组，然后将符合条件的数组编码为 JSON 输出（不要有空格），如：[[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]。
     */
    private static String solution(String line) {
        // 在此处理单行数据
        String data = line.substring(1, line.length() - 2);
        String[] items = data.split("],");
        int[] heights = new int[items.length];
        int[] k = new int[items.length];
        int[] newHeights = heights.clone();
        int[] newK = k.clone();
        int position = 0;
        for (String item : items) {
            heights[position] = Integer.parseInt(item.split(",")[0].substring(1));
            k[position++] = Integer.parseInt(item.split(",")[1]);
        }
        // 大范围的调整， 使得所有的排序是可能的， 也就是前面必然有大于k的高度较高的数
        for (int i = 0; i < heights.length; i++) {
            int temp = k[i];
            while (k[temp] > temp) {
                temp++;
            }
            if (temp < heights.length) {
                int tempHeight = heights[temp];
                heights[temp] = heights[i];
                heights[i] = tempHeight;
                int tempK = k[temp];
                k[temp] = k[i];
                k[i] = tempK;
            }
        }
        //微调
        for (int i = 0; i < heights.length; i++) {
            int count = 0;
            int p = 0;
            while (p < i) {
                count = heights[p++] >= heights[i] ? count + 1 : count;
            }
            int reset = 0;
            while (count != k[i]) {
                int flag = count > k[i] ? -1 : 1;
                int temp = i + flag;
                temp += flag;
                if (temp < 0 || temp > heights.length - 1){
                    break;
                }
                if (heights[temp] > heights[i]) {
                    count += flag;
                }
                int tempHeight = heights[temp];
                heights[temp] = heights[i];
                heights[i] = tempHeight;
                int tempK = k[temp];
                k[temp] = k[i];
                k[i] = tempK;
                reset = 1;
            }
            if (reset == 1) {
                i--;
            }
        }
        String first = "[";
        String last = "]";
        for (int i = 0; i < heights.length; i++) {
            first += "[" + heights[i] + "," + k[i] + "]" + (i == heights.length - 1 ? "" : ",");
        }
        first += last;
        Tool.displayIntArray(heights);
        Tool.displayIntArray(k);
        return first;
    }
}
