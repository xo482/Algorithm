import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int M;
    static int[][] adj;
    static int[][] visited;
    static int[] dr = new int[]{1, -1, 0, 0};
    static int[] dc = new int[]{0, 0, -1, 1};
    static ArrayDeque<int[]> Q = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        adj = new int[N][M];
        visited = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                adj[i][j] = Integer.parseInt(st.nextToken());
                if (adj[i][j] == 2) Q.addLast(new int[]{i,j});
            }
        }

        while (!Q.isEmpty()) {
            int[] ints = Q.removeFirst();
            int r = ints[0];
            int c = ints[1];

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr >= 0 && nc >= 0 && nr < N && nc < M
                        && visited[nr][nc] == 0 && adj[nr][nc] == 1) {

                    Q.addLast(new int[]{nr, nc});
                    visited[nr][nc] = visited[r][c] + 1;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (adj[i][j] == 1 && visited[i][j] == 0) sb.append("-1 ");
                else sb.append(visited[i][j]).append(" ");
            }
            sb.append("\n");
            
        }

        System.out.println(sb);
    }
}
