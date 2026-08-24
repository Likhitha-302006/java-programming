import java.io.*;
import java.util.*;

public class Main {

    static int[] manacher(String s) {

        int n = s.length();

    
        int[] arr = new int[2 * n + 1];

        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0)
                arr[i] = -1;
            else
                arr[i] = s.charAt(i / 2);
        }

        int[] radius = new int[arr.length];

        int center = 0;
        int right = 0;

        for (int i = 0; i < arr.length; i++) {

            int mirror = 2 * center - i;

            if (i < right) {
                radius[i] = Math.min(
                    right - i,
                    mirror >= 0 ? radius[mirror] : 0
                );
            }

            while (i - radius[i] - 1 >= 0 &&
                   i + radius[i] + 1 < arr.length &&
                   arr[i - radius[i] - 1] ==
                   arr[i + radius[i] + 1]) {

                radius[i]++;
            }

            if (i + radius[i] > right) {
                center = i;
                right = i + radius[i];
            }
        }

        return radius;
    }

    static class SegmentTree {

        int size;
        int[] tree;

        SegmentTree(int[] arr) {

            size = 1;

            while (size < arr.length)
                size *= 2;

            tree = new int[2 * size];

            for (int i = 0; i < arr.length; i++) {
                tree[size + i] = arr[i];
            }

            for (int i = size - 1; i > 0; i--) {
                tree[i] = Math.max(
                    tree[2 * i],
                    tree[2 * i + 1]
                );
            }
        }

        int query(int left, int right) {

            if (left > right)
                return 0;

            left += size;
            right += size;

            int answer = 0;

            while (left <= right) {

                if ((left & 1) == 1) {
                    answer = Math.max(answer, tree[left]);
                    left++;
                }

                if ((right & 1) == 0) {
                    answer = Math.max(answer, tree[right]);
                    right--;
                }

                left /= 2;
                right /= 2;
            }

            return answer;
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine().trim());

        String s = br.readLine().trim();

    
        String doubled = s + s;

        int[] radius = manacher(doubled);

        SegmentTree tree = new SegmentTree(radius);

        StringBuilder output = new StringBuilder();

        for (int start = 0; start < n; start++) {

          
            int left = start * 2;
            int right = (start + n - 1) * 2;

            int low = 1;
            int high = n;
            int answer = 1;

            while (low <= high) {

                int mid = (low + high) / 2;

                int queryLeft = left + mid - 1;
                int queryRight = right - mid + 1;

                if (queryLeft <= queryRight) {

                    int maxRadius =
                        tree.query(queryLeft, queryRight);

                    if (maxRadius >= mid) {
                        answer = mid;
                        low = mid + 1;
                    } else {
                        high = mid - 1;
                    }

                } else {
                    high = mid - 1;
                }
            }

            output.append(answer).append('\n');
        }

        System.out.print(output);
    }
}




Input
7
cacbbba

Sample Output
3
3
3
3
3
3
3