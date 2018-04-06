package DP;

import java.math.BigInteger;

/**
 * Created by Administrator on 2018/4/6.
 */
public class MoveK {

    public String move(String line) {

        String number = line.split(",")[0];
        int k = Integer.parseInt(line.split(",")[1]);
        if (k == 0) {
            return number;
        }
        if (k == number.length()){
            return "0";
        }

        char[] chars = number.toCharArray();
        int length = chars.length;
        char[] min = null;
        for (int i = 0; i < k; i++) {

            if (i != 0) {
                String result = "";
                int isMeetNum = 0;
                for (char c : min) {
                    if (c != '0') {
                        isMeetNum = 1;
                    }
                    if (isMeetNum == 1) {
                        result += c;
                    }
                }
                chars = result.toCharArray();
                length = chars.length;
            }
            min = new char[length];
            char[] integers = null;

            for (int j = 0; j < length; j++) {
                String s = "";
                for (int p = 0; p < length; p++) {
                    if (j != p) {
                        s += "" + chars[p];
                    }
                }
                integers = s.toCharArray();
                if (j == 0) {
                    min = integers;
                } else {
                    int flag = 0;
                    for (int p = 0; p < length - 1; p++) {
                        if (min[p] > integers[p]) {
                            flag = 1;
                            break;
                        } else if (min[p] < integers[p]) {
                            break;
                        }
                    }
                    if (1 == flag) {
                        min = integers;
                    }
                }
            }
        }
        String result = "";
        int isMeetNum = 0;
        for (char c : min) {
            if (c != '0') {
                isMeetNum = 1;
            }
            if (isMeetNum == 1) {
                result += c;
            }
        }
        if (isMeetNum == 0){
            return "0";
        }
        return result;
    }
}
