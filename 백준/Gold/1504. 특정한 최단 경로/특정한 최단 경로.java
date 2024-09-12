import java.io.*;
import java.util.*;

// 1에서 N까지 가는데 필수로 지나가야하는 v1, v2가 주어진다.
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, E;
    static int INF = 800_0001;
    static List<Node>[] list;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        list = new List[N + 1];
        for (int i = 1; i < N + 1; i++) list[i] = new ArrayList<>();

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list[a].add(new Node(b, c));
            list[b].add(new Node(a, c));
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());
        int case1 = dijkstra(1, v1) + dijkstra(v1, v2) + dijkstra(v2, N);
        int case2 = dijkstra(1, v2) + dijkstra(v2, v1) + dijkstra(v1, N);
        int answer = Math.min(case1, case2);

        if (answer >= INF) System.out.println(-1);
        else System.out.println(answer);
    }

    private static int dijkstra(int start, int end) {
        PriorityQueue<Node> Q = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
        dist = new int[N + 1];
        Arrays.fill(dist, INF);
        Q.add(new Node(start, 0));
        dist[start] = 0;

        while (!Q.isEmpty()) {
            Node curNode = Q.poll();
            if (dist[curNode.v] < curNode.cost) continue;

            for (Node nextNode : list[curNode.v]) {
                if (dist[nextNode.v] > dist[curNode.v] + nextNode.cost) {
                    dist[nextNode.v] = dist[curNode.v] + nextNode.cost;
                    Q.add(new Node(nextNode.v, dist[nextNode.v]));
                }
            }
        }
        return dist[end];
    }

    static class Node {
        int v;
        int cost;

        public Node(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }
    }

}