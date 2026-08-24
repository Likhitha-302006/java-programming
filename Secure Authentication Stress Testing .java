import java.io.*;
import java.util.*;

public class Main {

    static boolean authenticate(String username, String password) {
        // Boundary and edge-case validation
        if (username == null || password == null) {
            return false;
        }

        if (username.length() < 3 || username.length() > 20) {
            return false;
        }

        if (password.length() < 6 || password.length() > 20) {
            return false;
        }

        // Example valid credentials
        return username.equals("admin") && password.equals("admin123");
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine().trim());
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String line = br.readLine();

            if (line == null) {
                output.append("FAILURE\n");
                continue;
            }

            String[] parts = line.trim().split("\\s+");

            if (parts.length != 2) {
                output.append("FAILURE\n");
                continue;
            }

            String username = parts[0];
            String password = parts[1];

            if (authenticate(username, password)) {
                output.append("SUCCESS\n");
            } else {
                output.append("FAILURE\n");
            }
        }

        System.out.print(output);
    }
}




 Input
3
admin admin123
ab 123
user pass

Sample Output
SUCCESS
FAILURE
FAILURE
