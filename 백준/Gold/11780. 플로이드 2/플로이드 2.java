import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M;
    static int INF = 10000001;
    static List<Node>[] list;
    static PriorityQueue<Node> pq = new PriorityQueue<Node>();
    static ArrayDeque<Integer> stack = new ArrayDeque<>();
    static int[][] distance;
    static StringBuilder min_cost_sb = new StringBuilder();
    static StringBuilder tracking_sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        list = new List[N + 1];
        distance = new int[N + 1][2];
        for (int i = 1; i < N + 1; i++) {
            list[i] = new ArrayList<>();
            distance[i][0] = INF;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list[a].add(new Node(b, c));
        }

        for (int i = 1; i < N + 1; i++) {
            dijkstra(i);

            for (int j = 1; j < N + 1; j++)
                min_cost_sb.append(distance[j][0] != INF ? distance[j][0] : 0).append(' ');
            min_cost_sb.append('\n');

            for (int j = 1; j < N + 1; j++) {
                if (distance[j][0] == INF || i==j) {
                    tracking_sb.append(0).append('\n');
                    continue;
                }

                int t = j;
                while (t != 0) {
                    stack.addLast(t);
                    t = distance[t][1];
                }

                tracking_sb.append(stack.size()).append(' ');
                while (!stack.isEmpty()) {
                    tracking_sb.append(stack.removeLast()).append(' ');
                }
                tracking_sb.append('\n');
            }
        }

        System.out.print(min_cost_sb);
        System.out.println(tracking_sb);
    }

    private static void dijkstra(int start) {

        for (int i = 1; i < N + 1; i++) {
            distance[i][0] = INF;
            distance[i][1] = 0;
        }

        distance[start][0] = 0;
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            if (distance[now.v][0] < now.cost) continue;

            for (Node nxt : list[now.v]) {
                if (distance[nxt.v][0] > distance[now.v][0] + nxt.cost) {
                    distance[nxt.v][0] = distance[now.v][0] + nxt.cost;
                    pq.add(new Node(nxt.v, distance[nxt.v][0]));

                    distance[nxt.v][1] = now.v;
                }
            }
        }
    }


    static class Node implements Comparable<Node>{
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