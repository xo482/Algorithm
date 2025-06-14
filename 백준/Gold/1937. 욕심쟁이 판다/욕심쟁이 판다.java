import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int[][] board, dp;
    static int max = 0;
    static int[] dr = new int[]{-1, 1, 0, 0};
    static int[] dc = new int[]{0, 0, 1, -1};
    static PriorityQueue<int[]> Q = new PriorityQueue<>(((o1, o2) -> o2[2] - o1[2]));

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        dp = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                Q.add(new int[]{i, j, board[i][j]});
            }
        }

        while (!Q.isEmpty()) {
            int[] now = Q.poll();
            int r = now[0];
            int c = now[1];

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
                if (board[r][c] >= board[nr][nc]) continue;

                dp[r][c] = Math.max(dp[r][c], dp[nr][nc] + 1);
                max = Math.max(max, dp[r][c]);
            }
        }
        
        System.out.println(max+1);
    }
}
