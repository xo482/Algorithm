import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int T, N ,M, K;
    static int INF = 10000000;
    static int[] distance_sum, distance;
    static List<Node>[] list;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            distance_sum = new int[N + 1];
            list = new List[N + 1];
            for (int i = 1; i <= N; i++) list[i] = new ArrayList<>();


            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                list[a].add(new Node(b, c));
                list[b].add(new Node(a, c));
            }

            K = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < K; i++) {
                int friend = Integer.parseInt(st.nextToken());
                dijkstra(friend);
            }

            int idx = -1;
            int min = INF;
            for (int i = 1; i <= N; i++) {
                if (min > distance_sum[i]) {
                    min = distance_sum[i];
                    idx = i;
                }
            }
            sb.append(idx).append("\n");
        }
        System.out.print(sb);
    }

    private static void dijkstra(int start) {
        distance = new int[N + 1];
        Arrays.fill(distance, INF);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        distance[start] = 0;

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            if (distance[now.v] < now.cost) continue;

            for (Node nxt : list[now.v]) {
                if (distance[nxt.v] > distance[now.v] + nxt.cost) {
                    distance[nxt.v] = distance[now.v] + nxt.cost;
                    pq.add(new Node(nxt.v, distance[nxt.v]));
                }
            }
        }

        for (int i = 1; i <= N; i++) distance_sum[i] += distance[i];
    }

    static class Node implements Comparable<Node>{
        int v, cost;

        public Node(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return cost - o.cost;
        }
    }
}