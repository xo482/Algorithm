import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int T, N, M, K, r, c, answer;
    static boolean[][] field;

    static int[] dr = new int[]{-1, 1, 0, 0};
    static int[] dc = new int[]{0, 0, -1, 1};

    public static void main(String[] args) throws IOException {

        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            // 초기화
            answer = 0;
            field = new boolean[N][M];
            while (K-- > 0) {
                st = new StringTokenizer(br.readLine());
                c = Integer.parseInt(st.nextToken());
                r = Integer.parseInt(st.nextToken());
                field[r][c] = true;
            }

            // 탐색
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (field[i][j]) {
                        dfs(new int[]{i, j});
                        answer++;
                    }
                }
            }

            sb.append(answer).append("\n");
        }

        System.out.print(sb);
    }

    private static void dfs(int[] ints) {
        int r = ints[0];
        int c = ints[1];

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (nr >= 0 && nr < N && nc >= 0 && nc < M && field[nr][nc]){
                field[nr][nc] = false;
                dfs(new int[]{nr, nc});
            }
        }
    }
}