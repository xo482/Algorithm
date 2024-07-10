import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int M;
    static int INF = 1_000_000_001;
    static int[][] arr;
    static int[] distance;
    static boolean[] visited;
    static PriorityQueue<Node> Q = new PriorityQueue<Node>((o1, o2) -> Integer.compare(o1.cost, o2.cost));

    static class Node {
        int idx, cost;

        public Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        arr = new int[N + 1][N + 1];
        distance = new int[N + 1];

        for (int i = 0; i <N+1; i++) {
            for (int j = 0; j <N+1; j++) {
                arr[i][j] = INF;
            }
        }

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());
            arr[u][v] = Math.min(arr[u][v], val);
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        dijkstra(start);
        System.out.print(distance[end]);
    }

    private static void dijkstra(int start) {
        Arrays.fill(distance, INF);
        distance[start] = 0;
        Q.add(new Node(start, distance[start]));

        while (!Q.isEmpty()) {
            Node curNode = Q.remove();

            // 이 경우에 다른 노드에서 해당 노드까지의 거리가 이미 다른 값으로 대체되었기 때문에 넘어간다.
            if (distance[curNode.idx] < curNode.cost) continue;

            for (int nextInx = 1; nextInx < N + 1; nextInx++) {
                if (distance[nextInx] > distance[curNode.idx] + arr[curNode.idx][nextInx]) {
                    distance[nextInx] = distance[curNode.idx] + arr[curNode.idx][nextInx];
                    Q.add(new Node(nextInx, distance[nextInx]));
                }
            }
        }
    }
}