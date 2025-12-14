import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static final int N = 11;
    static int T, max;
    static int[][] board = new int[N][N];
    static boolean[] visited = new boolean[N];


    public static void main(String[] args) throws Exception {
        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            max = 0;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) board[i][j] = Integer.parseInt(st.nextToken());
            }

            tracking(0, 0);
            sb.append(max).append('\n');
        }
        System.out.print(sb);
    }

    private static void tracking(int num, int sum) {
        if (num == N) {
            max = Math.max(max, sum);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (visited[i]) continue;
            if (board[num][i] == 0) continue;
            visited[i] = true;
            tracking(num + 1, sum + board[num][i]);
            visited[i] = false;
        }
    }
}