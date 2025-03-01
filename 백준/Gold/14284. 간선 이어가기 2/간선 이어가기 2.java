import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M, start, end;
    static int INF = 500000;
    static int[] distance;
    static List<Node>[] list;
    static PriorityQueue<Node> Q = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        distance = new int[N + 1];
        Arrays.fill(distance, INF);
        list = new List[N + 1];
        for (int i = 1; i <= N; i++) list[i] = new ArrayList<>();

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list[a].add(new Node(b, c));
            list[b].add(new Node(a, c));
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        dijkstra();
        System.out.println(distance[end]);
    }

    private static void dijkstra() {
        distance[start] = 0;
        Q.add(new Node(start, 0));
        while (!Q.isEmpty()) {
            Node now = Q.poll();

            if (distance[now.v] < now.cost) continue;

            for (Node nxt : list[now.v]) {
                if (distance[nxt.v] > distance[now.v] + nxt.cost) {
                    distance[nxt.v] = distance[now.v] + nxt.cost;
                    Q.add(new Node(nxt.v, distance[nxt.v]));
                }
            }
        }
    }


    static class Node implements Comparable<Node> {
        int v, cost;

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
