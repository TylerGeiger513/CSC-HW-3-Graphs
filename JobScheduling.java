import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class JobScheduling {

    static int V = 8;
    static ArrayList<Integer>[] adj = new ArrayList[V];
    static boolean[] visited = new boolean[V];
    static int time = 1;
    static int[] startTime = new int[V];
    static int[] finishTime = new int[V];
    static ArrayList<Integer> schedule = new ArrayList<>();

    public static void addEdge(int u, int v) {
        adj[u].add(v);
    }

    public static void dfs(int node) {
        Stack<Integer> stack = new Stack<>();
        stack.push(node);

        while (!stack.isEmpty()) {
            int current = stack.peek();

            if (!visited[current]) {
                visited[current] = true;
                startTime[current] = time++;
            }

            boolean hasUnvisitedNeighbor = false;
            for (int neighbor : adj[current]) {
                if (!visited[neighbor]) {
                    stack.push(neighbor);
                    hasUnvisitedNeighbor = true;
                    break;
                }
            }

            if (!hasUnvisitedNeighbor) {
                stack.pop();
                finishTime[current] = time++;
                schedule.add(current);
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }

        // Define the graph edges
        addEdge(0, 2);
        addEdge(0, 3);
        addEdge(0, 4);
        addEdge(0, 5);
        addEdge(1, 4);
        addEdge(1, 5);
        addEdge(1, 6);
        addEdge(2, 3);
        addEdge(2, 4);
        addEdge(3, 5);
        addEdge(3, 7);
        addEdge(4, 5);
        addEdge(6, 5);
        addEdge(7, 5);
        addEdge(7, 6);

        dfs(6);

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i);
            }
        }

        for (int i = 0; i < V; i++) {
            System.out.println("Node " + i + " - Start Time: " + startTime[i] + " Finish Time: " + finishTime[i]);
        }

        System.out.println("Job Schedule:");
        Collections.reverse(schedule);
        for (int job : schedule) {
            System.out.print(job + " -> ");
        }
    }
}
