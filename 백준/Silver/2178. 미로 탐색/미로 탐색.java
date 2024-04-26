import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);
        ArrayDeque<int[]> Q = new ArrayDeque<>();
        int[] dr = new int[]{1,-1,0,0};
        int[] dc = new int[]{0,0,-1,1};

        int[][] field = new int[N+1][M+1];
        int[][] visited = new int[N+1][M+1];

        for(int i = 1; i <= N; i++) {
            String line = br.readLine();
            for(int j = 1; j <= M; j++) {
                field[i][j] = line.charAt(j - 1) - '0';
            }
        }

        Q.addLast(new int[]{1,1});
        visited[1][1] = 1;

        while(!Q.isEmpty()) {
            int[] now = Q.removeFirst();
            int r = now[0];
            int c = now[1];

            if (r == N && c == M) break;

            for(int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr > 0 && nc > 0 && nr <= N && nc <= M && field[nr][nc] == 1 && visited[nr][nc] == 0) {
                    visited[nr][nc] = visited[r][c] + 1;
                    Q.addLast(new int[]{nr,nc});
                }
            }
        }
        System.out.print(visited[N][M]);
    }
}