import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N;
    static char[][] board;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        board = new char[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = ' ';
            }
        }
        draw(N, 0, 0);


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(board[i][j]);
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    private static void draw(int n,int r, int c) {
        if (n==1) {
            board[r][c] = '*';
            return;
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i==1&&j==1) continue;
                draw(n/3, r + (n/3)*i, c + (n/3)*j);
            }
        }
    }


}
