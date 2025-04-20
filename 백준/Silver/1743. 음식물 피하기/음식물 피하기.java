import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M, K;
    static int[][] board;
    static int[] dr = new int[]{1, -1, 0, 0};
    static int[] dc = new int[]{0, 0, -1, 1};
    static int max = 0;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        board = new int[N][M];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken())-1;
            int c = Integer.parseInt(st.nextToken())-1;

            board[r][c] = 1;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] != 1) continue;
                bfs(i,j);
            }
        }

        System.out.println(max);
    }

    private static void bfs(int r, int c) {
        ArrayDeque<int[]> Q = new ArrayDeque<>();
        Q.add(new int[]{r, c});
        board[r][c] = -1;

        int cnt = 1;
        while (!Q.isEmpty()) {
            int[] now = Q.removeFirst();
            r = now[0];
            c = now[1];

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                if (board[nr][nc] == 0) continue;
                if (board[nr][nc] == -1) continue;

                Q.add(new int[]{nr, nc});
                board[nr][nc] = -1;
                cnt++;
            }
        }
        max = Math.max(max, cnt);
    }
}