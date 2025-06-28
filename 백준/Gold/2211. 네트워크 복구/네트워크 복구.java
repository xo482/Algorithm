import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, M, K = 0;
    static List<int[]>[] list;
    static int[] distance;
    static int INF = Integer.MAX_VALUE;
    static PriorityQueue<Node> Q = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        distance = new int[N + 1];
        Arrays.fill(distance, INF);
        list = new List[N + 1];
        for (int i = 0; i < N + 1; i++) list[i] = new ArrayList<>();

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            list[a].add(new int[]{b, cost});
            list[b].add(new int[]{a, cost});
        }


        distance[1] = 0;
        Q.add(new Node(-1, 1, 0));
        while (!Q.isEmpty()) {
            Node now = Q.poll();
            if (distance[now.v] < now.cost) continue;

            if (now.pre != -1) {
                K++;
                sb.append(now.pre).append(" ").append(now.v).append("\n");
            }


            for (int[] nxt : list[now.v]) {
                if (distance[nxt[0]] > nxt[1] + distance[now.v]) {
                    distance[nxt[0]] = nxt[1] + distance[now.v];
                    Q.add(new Node(now.v, nxt[0], distance[nxt[0]]));
                }
            }
        }


        System.out.println(K);
        System.out.println(sb);
    }

    static class Node implements Comparable<Node>{
        int pre, v;
        int cost;

        public Node(int pre, int v, int cost) {
            this.pre = pre;
            this.v = v;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
}