package FindNum;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/4/10.
 */
public class FindTripleGroup {

    //计算出相加为0的三元组个数
    public String find(String line) {
        String[] strings = line.split(",");
        int[] numbers = new int[strings.length];
        ArrayList<Integer> list = new ArrayList();

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(strings[i]);
            list.add(numbers[i]);
        }
        //排序
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i) > list.get(j)) {
                    int temp = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, temp);
                }
            }
        }

        //找到中值
        int flag = 0;// 标记正负号的转变位置
        int zeroCount = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) >= 0) {
                flag = i;
                break;
            }
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == 0) {
                zeroCount++;
            }
            if (list.get(i) > 0) {
                break;
            }
        }

        ArrayList<String> result = new ArrayList<>();
        //三个数相加为0, 只有三种情况
        //1. 两正一负
        //2. 两负一正
        //3. 一零和正负

        //处理第一种情况, 对正数从小到大遍历, 针对每一个正数, 与最大的负数相减, 再寻找正数使其和为0
        for (int i = flag; i < list.size(); i++) {
            int num = list.get(i);
            for (int j = 0; j < flag; j++) {
                int delta = Math.abs(list.get(j)) - num;
                for (int k = i+1; k < list.size(); k++) {
                    String s = num + "," + delta + "," + list.get(j);
                    if (delta == (list.get(k))&&!result.contains(s)) {
                        result.add(num + "," + delta + "," + list.get(j));
                    }
                    if (delta < list.get(k)) {
                        break;
                    }
                }
            }
        }

        //处理第二种情况
        for (int i = flag-1; i >= 0; i--) {
            int num = list.get(i);
            for (int j = list.size()-1; j >= flag; j--) {
                int delta = Math.abs(num) - list.get(j);
                for (int k = i-1; k >= 0; k--) {
                    String s = num + "," + delta + "," + list.get(j);
                    if (delta == (list.get(k))&&!result.contains(s)) {
                        result.add(num + "," + delta + "," + list.get(j));
                    }
                    if (delta > list.get(k)) {
                        break;
                    }
                }
            }
        }

        //处理三个零的情况
        if (zeroCount >= 3) {
            result.add("0,0,0");
        }

        return "" + result.size();
    }
}
