import org.w3c.dom.Node;

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, T, M;
    static int INF = 2000001;
    static int[] distance;
    static int[][] costs;
    static int[][] points;
    static boolean[] isTeleport;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        distance = new int[N];
        costs = new int[N][N];
        points = new int[N][3];
        isTeleport = new boolean[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            points[i][0] = x;
            points[i][1] = y;
            isTeleport[i] = s == 1;
        }

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                int cost = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                costs[i][j] = cost;
                costs[j][i] = cost;
            }
        }

        M = Integer.parseInt(br.readLine());
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()) - 1;
            int e = Integer.parseInt(st.nextToken()) - 1;

            sb.append(dijkstra(s, e)).append('\n');
        }
        System.out.print(sb);
    }

    private static int dijkstra(int s, int e) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        Arrays.fill(distance, INF);
        distance[s] = 0;
        pq.add(new Node(s, 0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            if (distance[now.v] < now.cost) continue;

            for (int nxt = 0; nxt < N; nxt++) {
                if (distance[nxt] > distance[now.v] + costs[now.v][nxt]) {
                    distance[nxt] = distance[now.v] + costs[now.v][nxt];
                    pq.add(new Node(nxt, distance[nxt]));
                }

                if (isTeleport[now.v] && isTeleport[nxt] && distance[nxt] > distance[now.v] + T) {
                    distance[nxt] = distance[now.v] + T;
                    pq.add(new Node(nxt, distance[nxt]));
                }
            }
        }

        return distance[e];
    }

    static class Node implements Comparable<Node> {
        int v, cost;
        Node(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return cost - o.cost;
        }
    }
}