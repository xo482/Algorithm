import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int T, n;
    static int[][] board;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {

            // init
            n = Integer.parseInt(br.readLine());
            board = new int[2][n];
            for (int i = 0; i < 2; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) board[i][j] = Integer.parseInt(st.nextToken());
            }


            if (n == 1) {
                sb.append(Math.max(board[0][0], board[1][0])).append("\n");
                continue;
            }

            // logic
            board[0][1] += board[1][0];
            board[1][1] += board[0][0];

            for (int j = 2; j < n; j++) {
                board[0][j] += Math.max(board[1][j - 2], board[1][j - 1]);
                board[1][j] += Math.max(board[0][j - 2], board[0][j - 1]);
            }
            sb.append(Math.max(board[0][n-1], board[1][n-1])).append("\n");
        }

        System.out.println(sb);
    }
}