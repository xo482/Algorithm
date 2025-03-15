import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int[][][] dp;
    static int[][] board;
    static int[] dr = new int[]{0, 1, 1};
    static int[] dc = new int[]{1, 1, 0};

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        board = new int[N][N];
        dp = new int[N][N][3]; // 3차원의 인덱스 0: 가로,  1: 대각선,  2: 세로

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) board[i][j] = Integer.parseInt(st.nextToken());
        }

        dp[0][1][0] = 1;
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (board[r][c] == 1) continue;

                for (int i = 0; i < 3; i++) {
                    if (dp[r][c][i] == 0) continue;

                    for (int j = 0; j < 3; j++) {
                        if (i!=j && (i-j)%2 == 0) continue;

                        int nr = r + dr[j];
                        int nc = c + dc[j];
                        if (nr >= N || nr < 0 || nc >= N || nc < 0) continue;
                        if (board[nr][nc] == 1) continue;
                        if (j == 1 && (board[nr][c] == 1 || board[r][nc] == 1)) continue;

                        dp[nr][nc][j] += dp[r][c][i];
                    }
                }
            }
        }

        System.out.println(dp[N-1][N-1][0] + dp[N-1][N-1][1] + dp[N-1][N-1][2]);
    }
}
