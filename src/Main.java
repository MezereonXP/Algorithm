public class Main {

    public static void main(String[] args) {

        String line = "mi zhizhqpoem";
        char[] s1 = line.split(" ")[0].toCharArray();
        char[] s2 = line.split(" ")[1].toCharArray();
        int[] count1 = new int[26];
        int[] count2 = new int[26];
        for (char c:s1){
            count1[c-'a']++;
        }
        for (char c:s2){
            count2[c-'a']++;
        }
        for (int i=0;i<count1.length;i++){
            if (count1[i]>count2[i]){
                System.out.println("false");
            }
        }
        System.out.println("true");

    }
}
