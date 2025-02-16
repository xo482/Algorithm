import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int INF = 1000000000;
    static int N, M, A, B, C;
    static int[] minShameList;
    static List<int[]>[] list;
    static PriorityQueue<Node> Q = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        init();

        dijkstra();
        System.out.println(minShameList[B]);
    }

    private static void dijkstra() {
        minShameList[A] = 0;
        Q.add(new Node(A, 0, 0));
        while (!Q.isEmpty()) {
            Node now = Q.poll();

            if (now.v == B) break;
            if (now.shame > minShameList[now.v]) continue;

            minShameList[now.v] = now.shame;
            for (int[] nxt : list[now.v]) {
                int shame = Math.max(now.shame, nxt[1]);
                if (now.cost + nxt[1] > C) continue;
                if (minShameList[nxt[0]] <= shame) continue;

                minShameList[nxt[0]] = shame;
                Q.add(new Node(nxt[0], now.cost + nxt[1], shame));
            }
        }
    }

    private static void init() throws IOException {
        minShameList = new int[N + 1];
        Arrays.fill(minShameList, INF);
        list = new List[N + 1];
        for (int i = 1; i < N + 1; i++) list[i] = new ArrayList<>();

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list[a].add(new int[]{b, cost});
            list[b].add(new int[]{a, cost});
        }
    }

    static class Node implements Comparable<Node>{
        int v;
        int cost; // 여기까지 오는데 비용
        int shame; // 여기까지 오는데 수치심

        public Node(int v, int cost, int shame) {
            this.v = v;
            this.cost = cost;
            this.shame = shame;
        }

        @Override
        public int compareTo(Node o) {
            if (this.shame == o.shame) return this.cost - o.cost;
            return this.shame - o.shame;
        }
    }
}