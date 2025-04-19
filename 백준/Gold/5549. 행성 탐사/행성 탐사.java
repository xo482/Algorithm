import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, M, K;
    static int[][][] board;
    static int a, b, c, d;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());
        board = new int[N+1][M+1][3]; // 정글,바다,얼음

        for (int i = 1; i <= N; i++) {
            char[] arr = br.readLine().toCharArray();
            for (int j = 1; j <= M; j++) {

                for (int k = 0; k < 3; k++)
                    board[i][j][k] = board[i - 1][j][k] + board[i][j - 1][k] - board[i - 1][j - 1][k];

                if (arr[j-1]=='J') board[i][j][0] += 1;
                if (arr[j-1]=='O') board[i][j][1] += 1;
                if (arr[j-1]=='I') board[i][j][2] += 1;
            }
        }

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());

            for (int k = 0; k < 3; k++) sb.append(board[c][d][k] - board[a - 1][d][k] - board[c][b - 1][k] + board[a - 1][b - 1][k]).append(" ");
            sb.append("\n");
        }
        System.out.print(sb);
    }
}