import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        // Adjacency list
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

   
        for (int i = 0; i < m; i++) {

            int u = sc.nextInt();
            int v = sc.nextInt();

      
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        int source = sc.nextInt();
        int destination = sc.nextInt();

        boolean[] visited = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();

        queue.add(source);
        visited[source] = true;

        boolean found = false;

        while (!queue.isEmpty()) {

            int current = queue.poll();

            if (current == destination) {
                found = true;
                break;
            }

            for (int next : graph.get(current)) {

                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }

        System.out.println(found ? "YES" : "NO");

        sc.close();
    }
}



Input:

5 3
1 2
2 3
4 5
1 5


Output:

NO