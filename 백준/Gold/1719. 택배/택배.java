import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N , M;
    static List<Node>[] list;
    static int INF = 200001;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new List[N + 1];
        for (int i = 1; i < N + 1; i++) list[i] = new ArrayList<>();

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list[a].add(new Node(b, cost, -1));
            list[b].add(new Node(a, cost, -1));
        }

        for (int i = 1; i < N + 1; i++) {
            dijkstra(i);
        }

        System.out.print(sb);
    }

    private static void dijkstra(int start) {
        int[][] distance = new int[N + 1][2];
        for (int i = 1; i < N + 1; i++) distance[i][0] = INF;
        PriorityQueue<Node> Q = new PriorityQueue<>();

        distance[start][0] = 0;
        for (Node node : list[start]) {
            Q.add(new Node(node.v, node.cost, node.v));
            distance[node.v][0] = node.cost;
            distance[node.v][1] = node.v;
        }

        while (!Q.isEmpty()) {
            Node now = Q.poll();
            if (distance[now.v][0] < now.cost) continue;

            distance[now.v][0] = now.cost;
            distance[now.v][1] = now.born;

            for (Node nxt : list[now.v]) {
                if (distance[nxt.v][0] > now.cost + nxt.cost) {
                    distance[nxt.v][0] = now.cost + nxt.cost;
                    Q.add(new Node(nxt.v, distance[nxt.v][0], now.born));
                }
            }
        }

        for (int i = 1; i < N + 1; i++) {
            if (start == i) sb.append("- ");
            else sb.append(distance[i][1]).append(" ");
        }
        sb.append("\n");
    }

    static class Node implements Comparable<Node>{
        int v;
        int cost;
        int born;

        public Node(int v, int cost, int born) {
            this.v = v;
            this.cost = cost;
            this.born = born;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
}
