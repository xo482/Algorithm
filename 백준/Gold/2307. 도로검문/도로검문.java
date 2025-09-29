import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M;
    static int[] distance, history;
    static List<Integer> results = new ArrayList<>();
    static List<int[]> ban_list = new ArrayList<>();
    static final int INF = 50000001;
    static List<Node>[] list;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        distance = new int[N + 1];
        history = new int[N + 1];
        list = new List[N + 1];
        for (int i = 1; i <= N; i++) list[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            list[a].add(new Node(b, t));
            list[b].add(new Node(a, t));
        }

        dijkstra();
        int idx = N;
        while (true) {
            ban_list.add(new int[]{history[idx], idx});
            idx = history[idx];

            if (idx == 1) break;
        }

        for (int[] ints : ban_list) {
            dijkstra_ben(ints);
        }

        int max = -1;
        for (int i : results)
            max = Math.max(max, i);

        if (max == INF) System.out.println(-1);
        else System.out.println(max - results.get(0));
    }

    private static void dijkstra() {
        for (int j = 0; j <= N; j++) distance[j] = INF;
        PriorityQueue<Node> Q = new PriorityQueue<>();
        Q.add(new Node(1, 0));
        distance[1] = 0;

        while (!Q.isEmpty()) {
            Node now = Q.poll();
            if (distance[now.v] < now.cost) continue;

            for (Node nxt : list[now.v]) {
                if (distance[nxt.v] > distance[now.v] + nxt.cost) {
                    distance[nxt.v] = distance[now.v] + nxt.cost;
                    history[nxt.v] = now.v;
                    Q.add(new Node(nxt.v, distance[nxt.v]));
                }
            }
        }
        results.add(distance[N]);
    }

    private static void dijkstra_ben(int[] bans) {

        int ban1 = bans[0];
        int ban2 = bans[1];

        for (int j = 0; j <= N; j++) distance[j] = INF;
        PriorityQueue<Node> Q = new PriorityQueue<>();
        Q.add(new Node(1, 0));
        distance[1] = 0;

        while (!Q.isEmpty()) {
            Node now = Q.poll();
            if (distance[now.v] < now.cost) continue;

            for (Node nxt : list[now.v]) {

                if ((now.v == ban1 && nxt.v == ban2)||(now.v == ban2 && nxt.v == ban1)) continue;

                if (distance[nxt.v] > distance[now.v] + nxt.cost) {
                    distance[nxt.v] = distance[now.v] + nxt.cost;
                    Q.add(new Node(nxt.v, distance[nxt.v]));
                }
            }
        }
        results.add(distance[N]);
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