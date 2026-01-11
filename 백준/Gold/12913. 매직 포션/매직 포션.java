import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, K;
    static double[][] distance;
    static int[][] arr;
    static double INF = 450.0;
    static PriorityQueue<Node> pq = new PriorityQueue<>();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N][N];
        distance = new double[N][K+1];
        for (int i = 0; i < N; i++) Arrays.fill(distance[i], INF);

        for (int i = 0; i < N; i++) {
            char[] chars = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) arr[i][j] = chars[j] - '0';
        }

        distance[0][0] = 0.0;
        pq.add(new Node(0, 0, 0));
        while (!pq.isEmpty()) {
            Node now = pq.poll();
            if (distance[now.v][now.drink] < now.cost) continue;

            for (int nxt = 0; nxt < N; nxt++) {
                if (now.v == nxt) continue;

                if (distance[nxt][now.drink] > distance[now.v][now.drink] + arr[now.v][nxt]) {
                    distance[nxt][now.drink] = distance[now.v][now.drink] + arr[now.v][nxt];
                    pq.add(new Node(nxt, distance[nxt][now.drink], now.drink));
                }
                if (now.drink == K) continue;

                if (distance[nxt][now.drink + 1] > distance[now.v][now.drink] + (double) arr[now.v][nxt] / 2.0) {
                    distance[nxt][now.drink + 1] = distance[now.v][now.drink] + (double) arr[now.v][nxt] / 2.0;
                    pq.add(new Node(nxt, distance[nxt][now.drink + 1], now.drink + 1));
                }
            }
        }

        double min = INF;
        for (int i = 0; i <= K; i++) {
            min = Math.min(min, distance[1][i]);
        }
        System.out.println(min);
    }

    static class Node implements Comparable<Node>{
        int v, drink;
        double cost;

        public Node(int v, double cost, int drink) {
            this.v = v;
            this.drink = drink;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return (int) (this.cost - o.cost);
        }
    }
}