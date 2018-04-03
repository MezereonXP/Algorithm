package FindNum;

import java.math.BigDecimal;

/**
 * Created by Administrator on 2018/4/3.
 */
public class FindUglyNumTest {

    //0, 1, 2, 4, 6, 7, 10, 13, 14, 18
    // 1, 2, 2, 1, 3, 3, 1, 4, 4
    public static void main(String[] args){
        FindUglyNum findUglyNum = new FindUglyNum();
        System.out.println(findUglyNum.find("2333"));
    }
}
