import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int N, M, K;
    static boolean[][] board;
    static int cnt = 0;
    static int[] dr = new int[]{1, -1, 0, 0};
    static int[] dc = new int[]{0, 0, -1, 1};

    static PriorityQueue<Integer> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        board = new boolean[N][M];

        while (K-- > 0) {
            st = new StringTokenizer(br.readLine());
            int r1 = Integer.parseInt(st.nextToken());
            int c1 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());

            for (int i = r1; i < r2; i++) {
                for (int j = c1; j < c2; j++) {
                    board[j][i] = true; // 방문처리
                }
            }
        }

        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++)
                if (!board[i][j]) {
                    pq.add(bfs(i,j));
                    cnt++;
                }

        sb.append(cnt).append("\n");
        while (!pq.isEmpty()) sb.append(pq.poll()).append(" ");

        System.out.println(sb.toString());
    }

    static int bfs(int r, int c) {
        int extent = 0;
        ArrayDeque<int[]> Q = new ArrayDeque<>();
        Q.add(new int[]{r, c});

        while (!Q.isEmpty()) {
            int[] now = Q.removeFirst();
            r = now[0];
            c = now[1];

            if (board[r][c]) continue;

            board[r][c] = true;
            extent++;

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr >= 0 && nr < N && nc >= 0 && nc < M && !board[nr][nc])
                    Q.addLast(new int[]{nr, nc});
            }
        }

        return extent;
    }
}