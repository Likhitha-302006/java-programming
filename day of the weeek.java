import java.time.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String date = sc.next();

        LocalDate d = LocalDate.parse(date);

        System.out.println(d.getDayOfWeek());
    }
}




Input
2026-08-18
Output
TUESDAY