package Convert;

import java.math.BigInteger;
import org.testng.annotations.IFactoryAnnotation;

/**
 * @program: ConvertNumber
 * @description: To convert number to chinese
 * @author: mezereonxp Email: mezereonxp@gmail.com
 * @create: 2018/5/17
 **/
public class ConvertNumber {

  public static String solution(String line) {
    String last = "元整";
    String result = "";
    // 在此处理单行数据
    char[] chars = line.toCharArray();
    if(chars.length == 1 && chars[0] == '0'){
      return "零元整";
    }
    if (chars.length > 8) {
      for (int i = 0; i < chars.length - 8; i++) {
        switch (chars[i]) {
          case '0':
            if (i != chars.length - 9)
              result += "零";
            break;
          case '1':
            result += "壹";
            break;
          case '2':
            result += "贰";
            break;
          case '3':
            result += "叁";
            break;
          case '4':
            result += "肆";
            break;
          case '5':
            result += "伍";
            break;
          case '6':
            result += "陆";
            break;
          case '7':
            result += "柒";
            break;
          case '8':
            result += "捌";
            break;
          case '9':
            result += "玖";
            break;
        }
        switch (chars.length - 9 - i) {
          case 1:
            if (chars[i] != '0')
              result += "拾";
            if (chars[i] == '0' && i >= 1 && chars[i-1] == '0')
              result = result.substring(0, result.length()-1);
            break;
          case 2:
            result += "佰";
            break;
        }
      }
      if (result.toCharArray()[result.toCharArray().length-1] == '零')
        result = result.substring(0, result.length()-1);
      result += "亿";
    }
    if (chars.length > 4) {
      int start = chars.length > 8 ? chars.length - 8 : 0;
      int flag = 0;
      for (int i = start; i < chars.length - 4; i++) {
        if (chars[i] != '0' && flag == 0 && i!=start) {
          result += "零";
        }
        switch (chars[i]) {
          case '0':
            if (flag == 0  || i >= 1 &&chars[i-1] == '0') {
              continue;
            }
            if (i != chars.length - 5)
              result += "零";
            break;
          case '1':
            result += "壹";
            break;
          case '2':
            result += "贰";
            break;
          case '3':
            result += "叁";
            break;
          case '4':
            result += "肆";
            break;
          case '5':
            result += "伍";
            break;
          case '6':
            result += "陆";
            break;
          case '7':
            result += "柒";
            break;
          case '8':
            result += "捌";
            break;
          case '9':
            result += "玖";
            break;
        }
        flag = 1;
        switch (chars.length - i - 5) {
          case 1:
            if (chars[i] != '0')
              result += "拾";
            break;
          case 2:
            if (chars[i] != '0')
              result += "佰";
            break;
          case 3:
            result += "仟";
        }
      }
      if (flag != 0) {
        if (result.toCharArray()[result.toCharArray().length-1] == '零')
          result = result.substring(0, result.length()-1);
        result += "万";
      }
    }

    if (chars.length > 0) {
      int start = chars.length > 4 ? chars.length - 4 : 0;
      int flag = 0;
      for (int i = start; i < chars.length; i++) {
        if (chars[i] != '0' && flag == 0 && i!= start) {
          result += "零";
        }
        switch (chars[i]) {
          case '0':
            if (flag == 0 || i >= 1 &&chars[i-1] == '0') {
              continue;
            }
            if (i != chars.length -1)
              result += "零";
            break;
          case '1':
            result += "壹";
            break;
          case '2':
            result += "贰";
            break;
          case '3':
            result += "叁";
            break;
          case '4':
            result += "肆";
            break;
          case '5':
            result += "伍";
            break;
          case '6':
            result += "陆";
            break;
          case '7':
            result += "柒";
            break;
          case '8':
            result += "捌";
            break;
          case '9':
            result += "玖";
            break;
        }
        flag = 1;
        if (chars[i] != '0') {
          switch (chars.length - i - 1) {
            case 1:
              if (chars[i] != '0')
                result += "拾";
              break;
            case 2:
              if (chars[i] != '0')
                result += "佰";
              break;
            case 3:
              result += "仟";
          }
        }
      }
    }
    return result + last;
  }
}
