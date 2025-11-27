import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M, H;
    static int ans = -1;
    static boolean[][] board;
    static boolean flag = false;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        board = new boolean[N + 1][H + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            board[b][a] = true;
        }

        for (int i = 0; i <= 3; i++) {
            tracking(0, i);
            if (flag) { ans = i; break; }
        }

        System.out.println(ans);
    }

    private static void tracking(int depth, int max_depth) {
        if (depth == max_depth) {
            flag = check();
            return;
        }

        for (int i = 1; i < N; i++) {
            for (int j = 1; j <= H; j++) {
                if (board[i][j]) continue;
                if (board[i - 1][j] || board[i + 1][j]) continue;

                board[i][j] = true;
                tracking(depth + 1, max_depth);
                board[i][j] = false;

                if (flag) break;
            }
            if (flag) break;
        }
    }

    private static boolean check() {
        for (int i = 1; i <= N; i++) {
            int line = i;

            for (int j = 1; j <= H; j++) {
                if (board[line - 1][j]) line--;
                else if (board[line][j]) line++;
            }
            if (i != line) return false;
        }
        return true;
    }
}