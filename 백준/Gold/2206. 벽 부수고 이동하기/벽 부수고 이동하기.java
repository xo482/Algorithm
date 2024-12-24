import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M;
    static int[][] board;
    static int[][][] arr;
    static boolean[][][] visited;
    static int[] dr = new int[]{-1, 1, 0, 0};
    static int[] dc = new int[]{0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        arr = new int[N][M][2];
        visited = new boolean[N][M][2];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = line.charAt(j) - '0';
            }
        }

        ArrayDeque<Point> Q = new ArrayDeque<>();
        Q.add(new Point(0, 0, 0, 1));
        arr[0][0][0] = 1;

        while (!Q.isEmpty()) {
            Point now = Q.removeFirst();
            if (visited[now.r][now.c][now.boom]) continue;

            visited[now.r][now.c][now.boom] = true;
            for (int i = 0; i < 4; i++) {
                int nr = now.r + dr[i];
                int nc = now.c + dc[i];
                if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                if (visited[nr][nc][now.boom]) continue;
                if (now.boom == 1 && board[nr][nc] == 1) continue;

                int boom = now.boom;
                if (now.boom == 0 && board[nr][nc] == 1) boom = 1;

                arr[nr][nc][boom] = now.distance + 1;
//                System.out.print("nr = " + nr);
//                System.out.print(", nc = " + nc);
//                System.out.print(", boom = " + boom);
//                System.out.println(", now.distance+1 = " + (now.distance+1));
                Q.add(new Point(nr, nc, boom, arr[nr][nc][boom]));
            }
        }

        if (visited[N-1][M-1][0] && visited[N-1][M-1][1]) {
            System.out.println(Math.min(arr[N-1][M-1][0], arr[N-1][M-1][1]));
        } else if (visited[N - 1][M - 1][0]) {
            System.out.println(arr[N - 1][M - 1][0]);
        } else if (visited[N - 1][M - 1][1]) {
            System.out.println(arr[N - 1][M - 1][1]);
        } else {
            System.out.println(-1);
        }
    }

    static class Point {
        int r,c;
        int boom;
        int distance;

        public Point(int r, int c, int boom, int distance) {
            this.r = r;
            this.c = c;
            this.boom = boom;
            this.distance = distance;
        }
    }
}