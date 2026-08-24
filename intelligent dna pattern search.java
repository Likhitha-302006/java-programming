import java.util.*;

public class Main {


    static int[] buildLPS(String pattern) {

        int m = pattern.length();
        int[] lps = new int[m];

        int len = 0;
        int i = 1;

        while (i < m) {

            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {

                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return lps;
    }

       static List<Integer> search(String text, String pattern) {

        List<Integer> positions = new ArrayList<>();

        int[] lps = buildLPS(pattern);

        int i = 0;     
     int j = 0; 


        while (i < text.length()) {

            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            }

            if (j == pattern.length()) {
                positions.add(i - j);
                j = lps[j - 1];

            } else if (i < text.length() &&
                       text.charAt(i) != pattern.charAt(j)) {

                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }

        return positions;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String text = sc.nextLine();
        String pattern = sc.nextLine();

        List<Integer> result = search(text, pattern);

        System.out.println(result.size());


        for (int index : result) {
            System.out.print(index + " ");
        }

        sc.close();
    }
}



 Input
AABAACAADAABAABA
AABA

 Output
3
0 9 12
