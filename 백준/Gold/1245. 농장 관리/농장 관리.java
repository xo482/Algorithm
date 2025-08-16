import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M;
    static int[][] board;
    static boolean[][] visited;
    static int answer = 0;
    static int[] dr = new int[]{1, -1, 0, 0, 1, 1, -1, -1};
    static int[] dc = new int[]{0, 0, -1, 1, 1, -1, 1, -1};
    static PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o2[2] - o1[2]);

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());

                if (board[i][j] == 0) continue;
                pq.add(new int[]{i, j, board[i][j]});
            }
        }


        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            int r = now[0];
            int c = now[1];
            int value = now[2];
            if (visited[r][c]) continue;

//            System.out.print("r = " + r);
//            System.out.print(", c = " + c);
//            System.out.println(", value = " + value);

            boolean flag = false;
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr >= N || nr < 0 || nc >= M || nc < 0) continue;
                if (board[r][c] >= board[nr][nc]) continue;

                flag = true;
            }
            if (flag) continue;


            if (bfs(r, c, value)) {
                answer++;
            }
        }

        System.out.println(answer);
    }

    private static boolean bfs(int r, int c, int maxValue) {
        boolean flag = true;
        ArrayDeque<int[]> Q = new ArrayDeque<>();
        Q.add(new int[]{r, c});
        visited[r][c] = true;

        while (!Q.isEmpty()) {
            int[] now = Q.removeFirst();
            r = now[0];
            c = now[1];

            for (int i = 0; i < 8; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr >= N || nr < 0 || nc >= M || nc < 0) continue;
                if (board[nr][nc] > maxValue && board[r][c] == maxValue) {
                    flag = false;
                }
                if (visited[nr][nc]) continue;
                if (board[nr][nc] == 0) continue;
                if (maxValue != board[nr][nc]) continue;

                visited[nr][nc] = true;
                Q.add(new int[]{nr, nc});
            }
        }

        return flag;
    }
}