import java.io.*;
import java.util.*;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M;
    static int[][] board;
    static int[] dr = new int[]{1, 0};
    static int[] dc = new int[]{0, 1};

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        board = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++)
                board[i][j] = Integer.parseInt(st.nextToken());
        }

        System.out.print(bfs());
    }

    private static String bfs() {
        ArrayDeque<int[]> Q = new ArrayDeque<>();
        Q.addLast(new int[]{0, 0});
        board[0][0] = 2;

        while (!Q.isEmpty()) {
            int[] cur = Q.removeFirst();
            int r = cur[0];
            int c = cur[1];

            if (r == N-1 && c == M-1) return "Yes";

            for (int i = 0; i < 2; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if (nr >= 0 && nr < N && nc >= 0 && nc < M && board[nr][nc] == 1) {
                    Q.addLast(new int[]{nr, nc});
                    board[nr][nc] = 2;
                }
            }
        }

        return "No";
    }
}
