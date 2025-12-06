import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M;
    static int[][] board;
    static boolean[][] visited;
    static ArrayDeque<Node> Q = new ArrayDeque<>();
    static int[] dr = new int[]{-1, 1, 0, 0};
    static int[] dc = new int[]{0, 0, -1, 1};


    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 9) {
                    visited[i][j] = true;
                    for (int dir = 0; dir < 4; dir++)
                        Q.add(new Node(i, j, dir));
                }
            }
        }

        while (!Q.isEmpty()) {
            Node now = Q.removeFirst();
            int nr = now.r + dr[now.dir];
            int nc = now.c + dc[now.dir];

            if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
            if (board[nr][nc] == 9) continue;
            if ((now.dir == 0 || now.dir == 1) && board[nr][nc] == 2) { visited[nr][nc] = true; continue; }
            if ((now.dir == 2 || now.dir == 3) && board[nr][nc] == 1) { visited[nr][nc] = true; continue; }

            int nxt_dir = now.dir;
            if (board[nr][nc] == 3) {
                if (now.dir == 0) nxt_dir = 3;
                if (now.dir == 1) nxt_dir = 2;
                if (now.dir == 2) nxt_dir = 1;
                if (now.dir == 3) nxt_dir = 0;
            }

            if (board[nr][nc] == 4) {
                if (now.dir == 0) nxt_dir = 2;
                if (now.dir == 1) nxt_dir = 3;
                if (now.dir == 2) nxt_dir = 0;
                if (now.dir == 3) nxt_dir = 1;
            }

            visited[nr][nc] = true;
            Q.add(new Node(nr, nc, nxt_dir));
        }

        int ans = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visited[i][j]) ans++;
            }
        }
        System.out.println(ans);
    }

    static class Node {
        int r, c, dir;

        public Node(int r, int c, int dir) {
            this.r = r;
            this.c = c;
            this.dir = dir;
        }
    }
}
