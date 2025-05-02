import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int V, E;
    static List<Node>[] list;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        visited = new boolean[V + 1];
        list = new List[V + 1];
        for (int i = 1; i < V + 1; i++) list[i] = new ArrayList<>();

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            list[v1].add(new Node(v2, cost));
            list[v2].add(new Node(v1, cost));
        }

        System.out.print(prim(1));
    }

    private static long prim(int start) {
        PriorityQueue<Node> Q = new PriorityQueue<>();
        long sum = 0;
        Q.add(new Node(start, 0));

        while (!Q.isEmpty()) {
            Node nowNode = Q.poll();
            int v = nowNode.v;
            int cost = nowNode.cost;

            if (visited[v]) continue;

            visited[v] = true;
            sum += cost;

            for (Node nextNode : list[v]) {
                if (!visited[nextNode.v]) {
                    Q.add(nextNode);
                }
            }
        }

        return sum;
    }

    static class Node implements Comparable<Node> {
        int v;
        int cost;

        public Node(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
}