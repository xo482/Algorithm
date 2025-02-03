import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M;
    static int[][] board;
    static int[][] visited;
    static int answer = 0;
    static int[] dr = new int[]{-1, 1, 0, 0};
    static int[] dc = new int[]{0, 0, 1, -1};
    static PriorityQueue<int[]> Q = new PriorityQueue<>(new Comparator<int[]>() {
        @Override
        public int compare(int[] o1, int[] o2) {
            return o2[2] - o1[2];
        }
    });

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        visited = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) board[i][j] = Integer.parseInt(st.nextToken());
        }

        Q.add(new int[]{0, 0, board[0][0]});
        visited[0][0] = 1;
        while (!Q.isEmpty()) {
            int[] now = Q.poll();
            int r = now[0];
            int c = now[1];

            if (board[r][c] <= board[N-1][M-1]) continue;
            if (r == N - 1 && c == M - 1) continue;

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr >= N || nr < 0 || nc >= M || nc < 0) continue;
                if (board[nr][nc] >= board[r][c]) continue;
                if (visited[nr][nc] == 0)
                    Q.add(new int[]{nr, nc, board[nr][nc]});
                visited[nr][nc] += visited[r][c];
            }
        }

        System.out.println(visited[N-1][M-1]);
    }

}