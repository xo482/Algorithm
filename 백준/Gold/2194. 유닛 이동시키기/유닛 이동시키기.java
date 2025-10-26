import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M, A, B, K;
    static int s_r, s_c ,e_r, e_c, n_N, n_M;
    static int[][] board, new_board;
    static boolean[][] visited;
    static int[] dr = new int[]{-1, 1, 0, 0};
    static int[] dc = new int[]{0, 0, 1, -1};
    static ArrayDeque<int[]> q = new ArrayDeque<>();
    static int answer = -1;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        n_N = N - A + 1;
        n_M = M - B + 1;

        new_board = new int[n_N][n_M];
        visited = new boolean[n_N][n_M];

        while (K-- > 0) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            board[r][c] = -1;
        }

        for (int i = 0; i < n_N; i++) {
            for (int j = 0; j < n_M; j++) {
                reduction(i, j);
            }
        }

        st = new StringTokenizer(br.readLine());
        s_r = Integer.parseInt(st.nextToken()) -1;
        s_c = Integer.parseInt(st.nextToken()) - 1;
        st = new StringTokenizer(br.readLine());
        e_r = Integer.parseInt(st.nextToken()) - 1;
        e_c = Integer.parseInt(st.nextToken()) - 1;

        q.add(new int[]{s_r, s_c, 0});
        visited[s_r][s_c] = true;

        while (!q.isEmpty()) {
            int[] now = q.removeFirst();

            if (now[0] == e_r && now[1] == e_c) {
                answer = now[2];
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nr = now[0] + dr[i];
                int nc = now[1] + dc[i];

                if (nr >= n_N || nr < 0 || nc >= n_M || nc < 0) continue;
                if (new_board[nr][nc] == -1) continue;
                if (visited[nr][nc]) continue;

                q.add(new int[]{nr, nc, now[2] + 1});
                visited[nr][nc] = true;
            }
        }
        System.out.println(answer);
    }


    private static void reduction(int r, int c) {
        for (int i = r; i < r + A; i++) {
            for (int j = c; j < c + B; j++) {
                if (board[i][j] == -1) {
                    new_board[r][c] = -1;
                    break;
                }
            }
        }
    }
}