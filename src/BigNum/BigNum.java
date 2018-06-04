package BigNum;/**
 * Created by Administrator on 2018/5/24.
 */

import java.math.BigInteger;

/**
 * @program: BigNum
 * @description: To calculate bignum
 * @author: mezereonxp Email: mezereonxp@gmail.com
 * @create: 2018/5/24
 **/
public class BigNum {

    public static void main(String[] args) {
        solution("7625022925148127196027859399571498914361+790786706794530");
        System.out.println(solution("123>122"));
    }

    /**
     * 描述
     * 对于给定的算术表达式，按规则输出计算结果，仅包含加法和大小判断。
     *
     * 输入
     * 一行字符串，为加号、大于、小于( + < > ) 连接的两个不限大小的非负整数。
     *
     * 输出
     * 当符号为 + 时, 计算两个数相加的和, 并以字符串格式返回；
     * 当符号为 < 时, 如果左数小于右数, 返回大写字母字符 Y, 否则返回大写字母字符 N；
     * 当符号为 > 时, 如果左数大于右数, 返回大写字母字符 Y, 否则返回大写字母字符 N。
     *
     * @param line
     * @return
     */
    private static String solution(String line) {
        // 在此处理单行数据
        if (line.contains("<")) {
            String str1 = line.split("<")[0];
            String str2 = line.split("<")[1];
            if (str1.length() != str2.length()) {
                return str1.length() > str2.length() ? "N" : "Y";
            } else {
                for (int i = 0; i < str1.length(); i++) {
                    if (str1.toCharArray()[i] < str2.toCharArray()[i]) {
                        return "Y";
                    }
                    if (str1.toCharArray()[i] > str2.toCharArray()[i]) {
                        return "N";
                    }
                    if (i == str1.length() - 1 && str1.toCharArray()[i] == str2.toCharArray()[i]){
                        return "N";
                    }
                }
                return "Y";
            }
        } else if (line.contains(">")) {
            String str1 = line.split(">")[0];
            String str2 = line.split(">")[1];
            if (str1.length() != str2.length()) {
                return str1.length() < str2.length() ? "N" : "Y";
            } else {
                for (int i = 0; i < str1.length(); i++) {
                    if (str1.toCharArray()[i] > str2.toCharArray()[i]) {
                        return "Y";
                    }
                    if (str1.toCharArray()[i] < str2.toCharArray()[i]) {
                        return "N";
                    }
                    if (i == str1.length() - 1 && str1.toCharArray()[i] == str2.toCharArray()[i]){
                        return "N";
                    }
                }
                return "Y";
            }
        } else {
            char[] num1 = line.split("\\u002B")[0].toCharArray();
            char[] num2 = line.split("\\u002B")[1].toCharArray();
            int maxLength = Math.max(num1.length, num2.length) - 1;
            int[] num = new int[Math.max(num1.length, num2.length) + 1];

            int position = num.length - 1;
            int numPosition = maxLength == num1.length - 1? num2.length - 1 : num1.length - 1;
            int flag = 0;
            for (int i = maxLength; i >= 0; i--) {
                int a, b;
                if (numPosition != -1){
                    a = num1[maxLength == num1.length - 1? i : numPosition] - '0';
                    b = num2[maxLength == num2.length - 1? i : numPosition] - '0';
                } else {
                    numPosition = 0;
                    a = num1[maxLength == num1.length - 1? i : numPosition] - (maxLength == num1.length - 1?'0':num1[numPosition]);
                    b = num2[maxLength == num2.length - 1? i : numPosition] - (maxLength == num2.length - 1?'0':num2[numPosition]);
                }

                num[position] = (a + b + flag) % 10;
                if (a + b + flag >= 10) {
                    flag = 1;
                } else {
                    flag = 0;
                }
                numPosition--;
                position--;
            }
            if (flag == 1) {
                num[position] = 1;
            }
            String result = "";
            for (int i = 0; i < num.length; i++) {
                if (!(i == 0 && num[i] == 0))
                    result += num[i];
            }
            return result;
        }
    }
}
