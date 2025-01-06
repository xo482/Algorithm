import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] dr = new int[]{-1, 1, 0, 0};
    static int[] dc = new int[]{0, 0, -1, 1};
    static int N, cnt = 1;
    static int[][] board;
    static boolean[][] visited;
    static List<int[]> path = new ArrayList<>();
    static int min = Integer.MAX_VALUE;


    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 1 && !visited[i][j]) {
                    cnt++;
                    find(i,j);
                }
            }
        }

        for (int i = 0; i < path.size(); i++) {
            int[] p1 = path.get(i);
            for (int j = 0; j < path.size(); j++) {
                int[] p2 = path.get(j);

                if (p1[2] == p2[2]) continue;

                min = Math.min(min, Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]) - 1);
            }
        }
        
        System.out.println(min);
    }

    static void find(int sr, int sc) {
        ArrayDeque<int[]> Q = new ArrayDeque<>();
        Q.add(new int[]{sr, sc});

        while (!Q.isEmpty()) {
            int[] cur = Q.poll();
            int r = cur[0];
            int c = cur[1];

            if (visited[r][c]) continue;

            visited[r][c] = true;
            board[r][c] = cnt;

            int check = 0;
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr < 0 || nc < 0 || nr >= N || nc >= N) {
                    check++;
                    continue;
                }
                if (!visited[nr][nc] && board[nr][nc] == 1) {
                    Q.add(new int[]{nr, nc});
                    check++;
                }
            }

            if (check != 4) {
                path.add(new int[]{r, c, cnt});
            }
        }
    }
}