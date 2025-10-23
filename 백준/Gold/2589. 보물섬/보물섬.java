import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M, sea, land;
    static int[][] board;
    static ArrayDeque<Point> points = new ArrayDeque<>();
    static int[] dr = new int[]{-1, 1, 0, 0};
    static int[] dc = new int[]{0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];

        sea = 'W' - 'A';
        land = 'L' - 'A';

        for (int i = 0; i < N; i++) {
            char[] chars = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                board[i][j] = chars[j] - 'A';
                if (board[i][j] == land) points.add(new Point(i, j));
            }
        }

        int answer = 0;
        for (Point point : points) {
            answer = Math.max(answer, bfs(point));
        }
        System.out.println(answer);
    }

    private static int bfs(Point start) {
        boolean[][] visited = new boolean[N][M];
        ArrayDeque<Point> q = new ArrayDeque<>();

        q.add(start);
        visited[start.r][start.c] = true;
        int loop = 0;

        while (true) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Point now = q.removeFirst();

                for (int j = 0; j < 4; j++) {
                    int nr = now.r + dr[j];
                    int nc = now.c + dc[j];


                    if (nr >= N || nr < 0 || nc >= M || nc < 0) continue;
                    if (board[nr][nc] == sea) continue;
                    if (visited[nr][nc]) continue;

                    visited[nr][nc] = true;
                    q.add(new Point(nr, nc));
                }
            }

            if (q.isEmpty()) break;
            loop++;
        }
        return loop;
    }

    static class Point {
        int r, c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}