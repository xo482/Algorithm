import java.io.*;
import java.util.*;

public class Main {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static int[] dr = new int[]{1, -1, 0, 0};
    static int[] dc = new int[]{0, 0, -1, 1};
    static int[][] board;
    static boolean[][] visited;
    static PriorityQueue<Node> Q = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            char[] charArray = br.readLine().toCharArray();
            for (int j = 0; j < n; j++) board[i][j] =((charArray[j] - '0') - 1) * (-1);
        }

        System.out.println(bfs());
    }

    private static int bfs() {
        Q.add(new Node(0, 0, 0));

        while (!Q.isEmpty()) {
            Node curNode = Q.poll();
            int r = curNode.r;
            int c = curNode.c;

            if (r == n - 1 && c == n - 1) return curNode.cost;
            if (visited[r][c]) continue;

            visited[r][c] = true;
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if (nr >= 0 && nc >= 0 && nr < n && nc < n && !visited[nr][nc]) {
                    Q.add(new Node(nr, nc, board[nr][nc] + curNode.cost));
                }
            }
        }
        return -1;
    }

    static class Node { // 해당 좌표 포함해서 거기까지 오는데 지나온 검은 방의 수를 지님
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
