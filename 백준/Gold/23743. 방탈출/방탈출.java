import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M;
    static boolean[] visited;
    static PriorityQueue<Edge> Q = new PriorityQueue<Edge>();;
    static List<Edge>[] list;
    static int total = 0;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N+1];
        list = new List[N + 1];
        for (int i =0; i <= N; i++) list[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            list[a].add(new Edge(b, cost));
            list[b].add(new Edge(a, cost));
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int cost = Integer.parseInt(st.nextToken());
            list[i].add(new Edge(0, cost));
            list[0].add(new Edge(i, cost));
        }


        Q.add(new Edge(0, 0));
        while (!Q.isEmpty()) {
            Edge now = Q.poll();

            if (visited[now.v]) continue;
            visited[now.v] = true;
            total += now.cost;

            for (Edge nxt : list[now.v]) {
                if (visited[nxt.v]) continue;
                Q.add(nxt);
            }
        }

        System.out.println(total);
    }

    static class Edge implements Comparable<Edge> {
        int v, cost;

        public Edge(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }

}