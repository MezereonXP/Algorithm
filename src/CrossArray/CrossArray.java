package CrossArray;

/**
 * Created by Administrator on 2018/4/2.
 */
public class CrossArray {

    public String solution(String line) {
        String[] s = line.split(",");
        char[] a = s[0].toCharArray();
        char[] b = s[1].toCharArray();
        int posA = 0;
        int posB = 0;

        int flag = 0;

        char[] target = s[2].toCharArray();
        int isMatch = 0;
        int times = 0;

        for (int i = 0; i < target.length; i++) {
            isMatch = 0;
            if (flag == 0&&posA<a.length&&target[i] == a[posA]){
                posA++;
                isMatch = 1;
            } else {
                flag = 1;
            }
            if (flag == 1&&posB<b.length&&target[i] == b[posB]){
                posB++;
                isMatch = 1;
            } else {
                flag = 0;
            }
            if (isMatch != 1){
                times++;
                i--;
            } else {
                times = 0;
            }
            if (times >= 2){
                return "false";
            }
        }
        if (posB == b.length&&posA == a.length){
            return "true";
        }
        return "false";
    }
}
