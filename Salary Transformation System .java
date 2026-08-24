import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        List<Integer> salaries = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            salaries.add(sc.nextInt());
        }

        salaries.stream()
                .map(salary -> salary + salary / 10)
                .forEach(salary -> System.out.print(salary + " "));
    }
}

input
5
1000 2000 3000 4000 5000
 output
1100 2200 3300 4400 5500
