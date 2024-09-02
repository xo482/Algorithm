import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static boolean[][] visited;
    static int[][] adj;
    static int[] dr = new int[]{1, -1, 0, 0};
    static int[] dc = new int[]{0, 0, -1, 1};
    static int max = 0, area = 1;
    static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        adj = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                adj[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, adj[i][j]);
            }
        }

        for (int h = 1; h < max; h++) {
            visited = new boolean[N][N];
            area = Math.max(area, bfs(h));
        }
        System.out.println(area);
    }

    private static int bfs(int h) {
        int cnt = 0;
        ArrayDeque<int[]> Q = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (adj[i][j] > h && !visited[i][j]) {
                    Q.addLast(new int[]{i, j});
                    visited[i][j] = true;
                    cnt++;

                    while (!Q.isEmpty()) {
                        int[] cur = Q.removeFirst();
                        int r = cur[0];
                        int c = cur[1];

                        for (int k = 0; k < 4; k++) {
                            int nr = r + dr[k];
                            int nc = c + dc[k];

                            if (nr >= 0 && nc >= 0 && nr < N && nc < N && !visited[nr][nc] && adj[nr][nc] > h) {
                                Q.addLast(new int[]{nr, nc});
                                visited[nr][nc] = true;
                            }
                        }
                    }
                }
            }
        }

        return cnt;
    }
}