import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int R, C;
    static int[][] board, answer;
    static boolean[][] visited;
    static PriorityQueue<Point> pq = new PriorityQueue<>();
    static Map<Integer, int[]> map = new HashMap<>();
    static int[] dr = new int[]{-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dc = new int[]{-1, 0, 1, -1, 1, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        board = new int[R][C];
        answer = new int[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                pq.add(new Point(i, j, board[i][j]));
                map.put(board[i][j], new int[]{i, j});
            }
        }

        while (!pq.isEmpty()) {
            Point now = pq.poll();
            int r = now.r;
            int c = now.c;

            int tr = r, tc = c;
            for (int i = 0; i < 8; i++) {
                int nr = now.r + dr[i];
                int nc = now.c + dc[i];

                if (nr >= R || nr < 0 || nc >= C || nc < 0) continue;
                if (board[tr][tc] < board[nr][nc]) continue;

                tr = nr;
                tc = nc;
            }

            if (tr == r && tc == c) answer[r][c]++;
            else {
                int[] point = map.get(board[tr][tc]);
                map.put(board[r][c], point);
                answer[point[0]][point[1]]++;
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                sb.append(answer[i][j]);
                if (j != C-1) sb.append(' ');
            }
            if (i !=R-1) sb.append('\n');
        }
        System.out.print(sb);
    }

    static class Point implements Comparable<Point>{
        int r, c, cost;

        public Point(int r, int c, int cost) {
            this.r = r;
            this.c = c;
            this.cost = cost;
        }

        @Override
        public int compareTo(Point o) {
            return this.cost - o.cost;
        }
    }
}