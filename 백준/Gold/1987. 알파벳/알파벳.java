import java.io.*;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M;
    static int[][] board;
    static boolean[][] visited;
    static boolean[] used;
    static int max;
    static int[] dr = new int[]{-1, 1, 0, 0};
    static int[] dc = new int[]{0, 0, 1, -1};

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        visited = new boolean[N][M];
        used = new boolean[26];

        for (int i = 0; i < N; i++) {
            char[] charArray = br.readLine().toCharArray();
            for (int j = 0; j < M; j++)
                board[i][j] = charArray[j] - 'A';
        }

        visited[0][0] = true;
        used[board[0][0]] = true;
        dfs(0, 0, 1);
        System.out.println(max);
    }

    //r,c까지 누적값 cnt임
    private static void dfs(int r, int c, int cnt) {
        max = Math.max(max, cnt);

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
            if (visited[nr][nc] || used[board[nr][nc]]) continue;

            visited[nr][nc] = true;
            used[board[nr][nc]] = true;

            dfs(nr, nc, cnt + 1);

            visited[nr][nc] = false;
            used[board[nr][nc]] = false;
        }
    }
}