import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M, K;
    static PriorityQueue<Node> Q = new PriorityQueue<>();
    static List<Node>[] list;
    static boolean[] visited;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        list = new List[N+1];
        visited = new boolean[N+1];
        for (int i = 1; i <= N; i++) list[i] = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) visited[Integer.parseInt(st.nextToken())] = true;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list[u].add(new Node(v, w));
            list[v].add(new Node(u, w));

            if (visited[u]) Q.add(new Node(v, w));
            if (visited[v]) Q.add(new Node(u, w));
        }

        while (!Q.isEmpty()) {
            Node now = Q.poll();
            if (visited[now.v]) continue;
            visited[now.v] = true;
            answer += now.w;

            for (Node nxt : list[now.v]) {
                if (visited[nxt.v]) continue;
                Q.add(new Node(nxt.v, nxt.w));
            }
        }

        System.out.print(answer);
    }

    static class Node implements Comparable<Node>{
        int v, w;

        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return this.w - o.w;
        }
    }
}