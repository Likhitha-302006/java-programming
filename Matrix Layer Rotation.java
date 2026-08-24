import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();
        int r = sc.nextInt();

        int[][] matrix = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        int layers = Math.min(m, n) / 2;

        for (int layer = 0; layer < layers; layer++) {

            List<Integer> elements = new ArrayList<>();

            int top = layer;
            int bottom = m - layer - 1;
            int left = layer;
            int right = n - layer - 1;

  
            for (int j = left; j <= right; j++) {
                elements.add(matrix[top][j]);
            }

        
            for (int i = top + 1; i <= bottom; i++) {
                elements.add(matrix[i][right]);
            }

   
            for (int j = right - 1; j >= left; j--) {
                elements.add(matrix[bottom][j]);
            }


            for (int i = bottom - 1; i > top; i--) {
                elements.add(matrix[i][left]);
            }

            int len = elements.size();
            int shift = r % len;

            int index = 0;

          
            for (int j = left; j <= right; j++) {
                matrix[top][j] = elements.get((index + shift) % len);
                index++;
            }

         
            for (int i = top + 1; i <= bottom; i++) {
                matrix[i][right] = elements.get((index + shift) % len);
                index++;
            }

             
            for (int j = right - 1; j >= left; j--) {
                matrix[bottom][j] =
                    elements.get((index + shift) % len);
                index++;
            }

         
            for (int i = bottom - 1; i > top; i--) {
                matrix[i][left] =
                    elements.get((index + shift) % len);
                index++;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}




Input
4 4 1
1 2 3 4
5 6 7 8
9 10 11 12
13 14 15 16

 Output
2 3 4 8
1 7 11 12
5 6 10 16
9 13 14 15
