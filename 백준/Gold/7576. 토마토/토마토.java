import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] dr = new int[]{1, -1, 0, 0};
        int[] dc = new int[]{0, 0, -1, 1};
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[][] adj = new int[N][M];
        ArrayDeque<int[]> Q = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                adj[i][j] = Integer.parseInt(st.nextToken());
                if (adj[i][j] == 1) Q.addLast(new int[]{i, j});
            }
        }

        int day = -1;
        while (!Q.isEmpty()) {
            int size = Q.size();
            for (int i = 0; i < size; i++) {
                int[] now = Q.removeFirst();
                int r = now[0];
                int c = now[1];

                for (int j = 0; j < 4; j++) {
                    int nr = r + dr[j];
                    int nc = c + dc[j];
                    if (nr >= 0 && nc >= 0 && nr < N && nc < M && adj[nr][nc] == 0) {
                        adj[nr][nc] = 1;
                        Q.addLast(new int[]{nr, nc});
                    }
                }
            }
            day++;
        }

        for (int[] ints : adj)
            for (int anInt : ints)
                if (anInt == 0) day = -1;
        System.out.print(day);
    }
}