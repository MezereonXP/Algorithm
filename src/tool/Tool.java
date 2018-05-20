package tool;/**
 * Created by Administrator on 2018/5/20.
 */

/**
 * @program: Tool
 * @description: To Display result
 * @author: mezereonxp Email: mezereonxp@gmail.com
 * @create: 2018/5/20
 **/
public class Tool {

  public static void displayResult(String result){
    System.out.println("Result is: "+result);
  }

  public static void displayIntArray(int[] objects){
    int position = 0;
    for (int i:objects){
      System.out.print(i+(position==objects.length-1?"":", "));
      position++;
    }
    System.out.println();
  }
}
