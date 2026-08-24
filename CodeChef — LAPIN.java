import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            String s = sc.next();

            int n = s.length();
            int[] freq = new int[26];


            for (int i = 0; i < n / 2; i++) {
                freq[s.charAt(i) - 'a']++;
            }

                       for (int i = (n + 1) / 2; i < n; i++) {
                freq[s.charAt(i) - 'a']--;
            }

            boolean lapin = true;

            for (int i = 0; i < 26; i++) {
                if (freq[i] != 0) {
                    lapin = false;
                    break;
                }
            }

            if (lapin) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

        sc.close();
    }
}

 Input
4
gaga
abcde
rotor
xyzxy

 Output
YES
NO
YES
NO
