import java.util.*;

class Result {

    public static int diagonalDifference(List<List<Integer>> arr) {

        int n = arr.size();

        int diagonal1 = 0;
        int diagonal2 = 0;

        for (int i = 0; i < n; i++) {
            diagonal1 += arr.get(i).get(i);
            diagonal2 += arr.get(i).get(n - 1 - i);
        }

        return Math.abs(diagonal1 - diagonal2);
    }
}
Input
3
11 2 4
4 5 6
10 8 -12

Main diagonal:

11 + 5 + (-12) = 4

Other diagonal:

4 + 5 + 10 = 19

Output
15