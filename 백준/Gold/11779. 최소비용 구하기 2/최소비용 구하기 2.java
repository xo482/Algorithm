import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static List<Edge>[] list;
    static int N, M;
    static int start, end;
    static int[] distance;
    static int INF = 100000001;
    static PriorityQueue<Node> Q = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        distance = new int[N + 1];
        Arrays.fill(distance, INF);

        list = new List[N + 1];
        for (int i = 0; i < N + 1; i++) list[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            list[a].add(new Edge(b, cost));
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        dijkstra();
    }

    private static void dijkstra() {
        distance[start] = 0;
        for (Edge nxt : list[start]) {
            List<Integer> initList = new ArrayList<>();
            initList.add(start);
            Q.add(new Node(nxt.v, nxt.cost, initList));
            distance[nxt.v] = nxt.cost;
        }

        while (!Q.isEmpty()) {
            Node now = Q.poll();
            now.nxtList.add(now.v);
            
            if (now.v == end) {
                sb.append(now.cost).append("\n").append(now.nxtList.size()).append("\n");
                for (int i : now.nxtList) sb.append(i).append(" ");

                System.out.print(sb);
                return;
            }
            if (distance[now.v] < now.cost) continue;


            for (Edge nxt : list[now.v]) {
                if (distance[nxt.v] > now.cost + nxt.cost) {
                    distance[nxt.v] = now.cost + nxt.cost;
                    Q.add(new Node(nxt.v, distance[nxt.v], new ArrayList<>(now.nxtList)));
                }
            }
        }


    }

    static class Node implements Comparable<Node>{
        int v, cost;
        List<Integer> nxtList;

        public Node(int v, int cost, List<Integer> nxtList) {
            this.v = v;
            this.cost = cost;
            this.nxtList = nxtList;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    static class Edge {
        int v, cost;

        public Edge(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }
    }
}