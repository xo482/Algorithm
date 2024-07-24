import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int INF = 100_000_000;
    static int T, n, d, c, a, b, s;
    static int cnt, time;
    static ArrayList<Node>[] adj;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            adj = new ArrayList[n+1];
            for (int i = 0; i < n + 1; i++) adj[i] = new ArrayList<Node>();
            dist = new int[n+1];

            Arrays.fill(dist, INF);

            while (d-- > 0) {
                st = new StringTokenizer(br.readLine());
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());
                s = Integer.parseInt(st.nextToken());

                adj[b].add(new Node(a, s));
            }

            dijkstra(c);

            cnt = 0; time = 0;
            for (int i : dist) {
                if (i != INF) {
                    cnt++;
                    time = Math.max(time, i);
                }
            }

            sb.append(cnt).append(" ").append(time).append("\n");
        }

        System.out.print(sb);
    }

    static class Node {
        int idx;
        int cost;

        Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }

    private static void dijkstra(int start) {
        PriorityQueue<Node> Q = new PriorityQueue<Node>(((o1, o2) -> Integer.compare(o1.cost, o2.cost)));
        Q.add(new Node(start, 0));
        dist[start] = 0;

        while (!Q.isEmpty()) {
            Node curNode = Q.poll();

            if (dist[curNode.idx] < curNode.cost) continue;

            for (Node nxtNode : adj[curNode.idx]) {
                if (dist[nxtNode.idx] > dist[curNode.idx] + nxtNode.cost) {
                    dist[nxtNode.idx] = dist[curNode.idx] + nxtNode.cost;
                    Q.add(new Node(nxtNode.idx, dist[nxtNode.idx]));
                }
            }
        }
    }
}