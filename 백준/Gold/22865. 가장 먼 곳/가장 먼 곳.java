import java.io.*;
import java.util.*;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M;
    static int INF = 1_000_000_001;
    static int[][] distance;
    static List<Node>[] list;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        distance = new int[N + 1][3];
        for (int i = 1; i < N + 1; i++) Arrays.fill(distance[i], INF);

        list = new List[N + 1];
        for (int i = 1; i < N + 1; i++) list[i] = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            list[d].add(new Node(e, l));
            list[e].add(new Node(d, l));
        }


        dijkstra(a, 0);
        dijkstra(b, 1);
        dijkstra(c, 2);

        int max = 0;
        int answer = -1;
        for (int i = 1; i < N + 1; i++) {
            int min = INF;
            for (int j = 0; j < 3; j++) {
                min = Math.min(min, distance[i][j]);
            }

            if (max < min) {
                max = min;
                answer = i;
            }
        }
        
        System.out.println(answer);
    }

    static void dijkstra(int friend, int idx) {
        PriorityQueue<Node> Q = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
        Q.add(new Node(friend, 0));
        distance[friend][idx] = 0;

        while (!Q.isEmpty()) {
            Node curNode = Q.poll();
            if (distance[curNode.v][idx] < curNode.cost) continue;

            distance[curNode.v][idx] = curNode.cost;
            for (Node nxtNode : list[curNode.v]) {
                if (distance[nxtNode.v][idx] > distance[curNode.v][idx] + nxtNode.cost) {
                    distance[nxtNode.v][idx] = distance[curNode.v][idx] + nxtNode.cost;
                    Q.add(new Node(nxtNode.v, distance[nxtNode.v][idx]));
                }
            }
        }
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