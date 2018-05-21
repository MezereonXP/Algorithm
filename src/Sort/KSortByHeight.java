package Sort;/**
 * Created by Administrator on 2018/5/19.
 */

import tool.Tool;

import java.util.LinkedList;

/**
 * @program: KSortByHeight
 * @description: To solve k sort problem
 * @author: mezereonxp Email: mezereonxp@gmail.com
 * @create: 2018/5/19
 **/

public class KSortByHeight {

    public static void main(String[] args) {
        Tool.displayResult(solution("[[7,0],[4,4],[7,1],[5,0],[6,1],[5,2],[3,3]]"));
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
        int position = 0;
        for (String item : items) {
            heights[position] = Integer.parseInt(item.split(",")[0].substring(1));
            k[position++] = Integer.parseInt(item.split(",")[1]);
        }
        // 对<h, k>进行排序
        for (int i = 0; i < heights.length - 1; i++) {
            for (int j = i + 1; j < heights.length; j++) {
                if (heights[i] > heights[j] || (heights[i] == heights[j] && k[i] < k[j])) {
                    int t = heights[i];
                    heights[i] = heights[j];
                    heights[j] = t;
                    t = k[i];
                    k[i] = k[j];
                    k[j] = t;
                }
            }
        }

        LinkedList linkedListForHeights = new LinkedList();
        LinkedList linkedListForK = new LinkedList();
        for (int i = heights.length - 1; i >= 0; i--) {
            if (i == heights.length - 1){
                linkedListForHeights.add(heights[i]);
                linkedListForK.add(k[i]);
            } else {
                linkedListForHeights.add(k[i], heights[i]);
                linkedListForK.add(k[i], k[i]);
            }
        }
        for (int i=0;i<linkedListForHeights.size();i++){
            heights[i] = (int) linkedListForHeights.get(i);
            k[i] = (int) linkedListForK.get(i);
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
