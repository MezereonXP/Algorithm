package BigNum;/**
 * Created by Administrator on 2018/5/24.
 */

/**
 * @program: BigNum
 * @description: To calculate bignum
 * @author: mezereonxp Email: mezereonxp@gmail.com
 * @create: 2018/5/24
 **/
public class BigNum {

    /**
         描述
         对于给定的算术表达式，按规则输出计算结果，仅包含加法和大小判断。

         输入
         一行字符串，为加号、大于、小于( + < > ) 连接的两个不限大小的非负整数。

         输出
         当符号为 + 时, 计算两个数相加的和, 并以字符串格式返回；
         当符号为 < 时, 如果左数小于右数, 返回大写字母字符 Y, 否则返回大写字母字符 N；
         当符号为 > 时, 如果左数大于右数, 返回大写字母字符 Y, 否则返回大写字母字符 N。
     * @param line
     * @return
     */
    private static String solution(String line) {
        // 在此处理单行数据
        if (line.contains("<")){

        } else if (line.contains(">")){

        } else {

        }
        // 返回处理后的结果
        return line;
    }
}
