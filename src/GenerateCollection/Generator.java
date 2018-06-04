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
//        generateSubset(s);
        generateGraySubset(s);
    }

    private static void generateGraySubset(String[] strings) {
        int[] binary = new int[strings.length];
        while (checkGray(binary)) {
            int count = getSum(binary);
            if (count % 2 == 0) {
                binary[binary.length - 1] = binary[binary.length - 1] == 1 ? 0 : 1;
            } else {
                int position = getJ(binary);
                if (position != binary.length - 1) {
                    binary[position - 1] = binary[position - 1] == 1 ? 0 : 1;
                } else {
                    binary[binary.length - 2] = binary[binary.length - 2] == 1 ? 0 : 1;
                }

            }
            output(binary, strings);
        }
    }

    private static int getJ(int[] binary) {
        for (int i = binary.length - 1; i >= 0; i--) {
            if (binary[i] == 1) {
                return i;
            }
        }
        return -1;
    }

    private static int getSum(int[] binary) {
        int sum = 0;
        for (int i : binary) {
            sum += i;
        }
        return sum;
    }

    private static boolean checkGray(int[] binary) {
        if (binary[0] == 0) {
            return true;
        } else {
            for (int i = 1; i < binary.length; i++) {
                if (binary[i] == 1) {
                    return true;
                }
            }
            return false;
        }
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
        for (int i = 0; i < binary.length; i++) {
            if (binary[i] == 1) {
                System.out.print(strings[i] + "\t");
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
