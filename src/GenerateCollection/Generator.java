package GenerateCollection;

/**
 * @program: Algorithm
 * @description: A generator to generate some subset
 * @author: mezereonxp Email: mezereonxp@gmail.com
 * @create: 2018-05-22 16:45
 **/
public class Generator {

    public static void main(String[] args) {
        String[] s = {"a", "b", "c"};
        generateSubset(s);
    }

    private static void generateSubset(String[] strings) {
        int[] binary = new int[strings.length];
        while (!isAllOne(binary)) {
            int position = findZero(binary);
            setBinary(position, binary);
            output(binary, strings);
        }
    }

    private static void output(int[] binary, String[] strings) {
        for (int i = 0;i<binary.length;i++){
            if (binary[i] == 1){
                System.out.print(strings[i]+"\t");
            }
        }
        System.out.println();
    }

    private static void setBinary(int position, int[] binary) {
        binary[position] = 1;
        for (int i = position + 1; i < binary.length; i++) {
            binary[i] = 0;
        }
    }

    private static int findZero(int[] binary) {
        for (int i = binary.length - 1; i >= 0; i--) {
            if (binary[i] == 0) {
                return i;
            }
        }
        return -1;
    }

    private static boolean isAllOne(int[] binary) {
        for (int i : binary) {
            if (i != 1) {
                return false;
            }
        }
        return true;
    }
}
