import java.io.*;
import java.util.*;

public class Main {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int t, n, cnt = 1;
    static int INF = 100_000_000;
    static int[][] cave, distance;
    static int[] dr = new int[]{1, -1, 0, 0};
    static int[] dc = new int[]{0, 0, -1, 1};
    static PriorityQueue<Node> Q = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));

    public static void main(String[] args) throws IOException {

        while (true){
            n = Integer.parseInt(br.readLine());
            if (n==0) break;
            cave = new int[n][n];
            distance = new int[n][n];

            for (int i = 0; i < n; i++) Arrays.fill(distance[i], INF);
            for (int i = 0; i < n; i++) {
                String[] line = br.readLine().split(" ");
                for (int j = 0; j < n; j++) cave[i][j] = Integer.parseInt(line[j]);
            }

            dijkstra(0, 0);
            sb.append("Problem ").append(cnt++).append(": ").append(distance[n-1][n-1]).append("\n");
        }

        System.out.println(sb);
    }

    private static void dijkstra(int r, int c) {
        distance[r][c] = cave[r][c];
        Q.add(new Node(r, c, distance[r][c]));

        while (!Q.isEmpty()) {
            Node cur = Q.poll();
            r = cur.r;
            c = cur.c;

            if (distance[r][c] < cur.cost) continue;

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr < 0 || nc < 0 || nr >= n || nc >= n) continue;
                if (distance[nr][nc] > cur.cost + cave[nr][nc]) {
                    distance[nr][nc] = cur.cost + cave[nr][nc];
                    Q.add(new Node(nr, nc, distance[nr][nc]));
                }
            }
        }
    }

    static class Node { // 해당 좌표의 값 포함해서 그 좌표까지 오는데 걸린 비용
        int r;
        int c;
        int cost;

        public Node(int r, int c, int cost) {
            this.r = r;
            this.c = c;
            this.cost = cost;
        }
    }
}