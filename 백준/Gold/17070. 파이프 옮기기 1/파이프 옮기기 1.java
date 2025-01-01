import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int[][][] dp;
    static int[][] board;


    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        dp = new int[N][N][3]; // 0: 가로, 1: 대각선, 2: 세로
        board = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) board[i][j] = Integer.parseInt(st.nextToken());
        }

        dp[0][1][0] = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {

                for (int k = 0; k < 3; k++) {
                    if (dp[i][j][k] == 0) continue;
                    if (k==0) {
                        if (i+1 < N && j+1 < N && board[i+1][j+1] == 0 && board[i][j+1] == 0 && board[i+1][j] == 0) dp[i+1][j+1][1] += dp[i][j][k];
                        if (j+1 < N && board[i][j+1] == 0) dp[i][j+1][0] += dp[i][j][k];
                    }
                    if (k==1) {
                        if (i+1 < N && j+1 < N && board[i+1][j+1] == 0 && board[i][j+1] == 0 && board[i+1][j] == 0) dp[i+1][j+1][1] += dp[i][j][k];
                        if (j+1 < N && board[i][j+1] == 0) dp[i][j+1][0] += dp[i][j][k];
                        if (i+1 < N && board[i+1][j] == 0) dp[i+1][j][2] += dp[i][j][k];
                    }
                    if (k==2) {
                        if (i+1 < N && j+1 < N && board[i+1][j+1] == 0 && board[i][j+1] == 0 && board[i+1][j] == 0) dp[i+1][j+1][1] += dp[i][j][k];
                        if (i+1 < N && board[i+1][j] == 0) dp[i+1][j][2] += dp[i][j][k];
                    }
                }

            }
        }

        System.out.println(dp[N-1][N-1][0] + dp[N-1][N-1][1] + dp[N-1][N-1][2]);
    }
}
