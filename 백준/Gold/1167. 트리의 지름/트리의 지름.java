import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int V, node, max = 0;
    static boolean[] visited;
    static List<Node>[] list;
    static List<Integer> leaf = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        V = Integer.parseInt(br.readLine());

        list = new List[V+1];
        for (int i = 1; i < V+1; i++) list[i] = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            st = new StringTokenizer(br.readLine());
            int now = Integer.parseInt(st.nextToken());
            while (true) {
                int next = Integer.parseInt(st.nextToken()); if (next == -1) break;
                int cost = Integer.parseInt(st.nextToken());
                list[now].add(new Node(next, cost));
            }
        }

        for (int i = 1; i < V + 1; i++) {
            if (list[i].size() == 1)
                leaf.add(i);
        }

        visited = new boolean[V + 1];
        dfs(leaf.get(0), 0);
        visited = new boolean[V + 1];
        dfs(node, 0);

        System.out.println(max);
    }

    static void dfs(int now, int sum) {
        if (sum > max) {
            max = sum;
            node = now;
        }
        visited[now] = true;

        for (Node next : list[now]) {
            if (!visited[next.v]) {
                dfs(next.v, sum + next.cost);
                visited[next.v] = true;
            }
        }
    }

    static class Node{
        int v,cost;

        public Node(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }
    }
}
