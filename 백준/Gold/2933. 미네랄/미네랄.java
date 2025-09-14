import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int R, C, N;
    static char[][] board;
    static boolean[][] visited;
    static int[] dr = new int[]{-1, 1, 0, 0};
    static int[] dc = new int[]{0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        board = new char[R][C];
        for (int i = 0; i < R; i++) {
            char[] temp = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                board[i][j] = temp[j];
            }
        }

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int k = 0; k < N; k++) {
            int h = Integer.parseInt(st.nextToken());
            int r = R - h;
            int c;
            if (k % 2 == 0) {
                for (c = 0; c < C; c++) {
                    if (board[r][c] == 'x') {
                        board[r][c] = '.';
                        break;
                    }
                }
            }
            else {
                for (c = C-1; c >= 0; c--) {
                    if (board[r][c] == 'x') {
                        board[r][c] = '.';
                        break;
                    }
                }
            }

            visited = new boolean[R][C];
            boolean escape = false;
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (visited[i][j]) continue;
                    if (board[i][j] == '.') continue;

                    if (!bfs(i, j)){
                        escape = true;
                        break;
                    }
                }
                if (escape) break;
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    private static boolean bfs(int r, int c) {
        List<Node> points = new ArrayList<>();
        ArrayDeque<Node> Q = new ArrayDeque<>();
        Q.add(new Node(r, c));
        visited[r][c] = true;
        boolean flag = false;

        while (!Q.isEmpty()) {
            Node now = Q.removeFirst();
            points.add(new Node(now.r, now.c));
            r = now.r;
            c = now.c;
            if (r == R-1) {
                flag = true;
            }

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr >= R || nr < 0 || nc >= C || nc < 0) continue;
                if (visited[nr][nc]) continue;
                if (board[nr][nc] == '.') continue;

                Q.add(new Node(nr,nc));
                visited[nr][nc] = true;
            }
        }

        if (!flag) {
            Collections.sort(points);
            gravity(points);
        }

        return flag;
    }

    private static void gravity(List<Node> points) {
        boolean flag = false;
        while (true) {
            for (int i = 0; i < points.size(); i++) {
                Node now = points.get(i);
                int r = now.r;
                int c = now.c;

                board[r][c] = '.';
                board[r+1][c] = 'x';
                now.r = r + 1;
            }

            for (int i = 0; i < points.size(); i++) {
                Node now = points.get(i);
                int r = now.r;
                int c = now.c;

                int nr = r+1;
                int nc = c;

                boolean ex = false;
                for (Node point : points) {
                    if (point.r == nr && point.c == nc) {
                        ex = true;
                        break;
                    }
                }
                if (ex) continue;

                if (nr == R || board[nr][c] == 'x') {
                    flag = true;
                    break;
                }
            }

            if (flag) break;
        }
    }

    static class Node implements Comparable<Node>{
        int r, c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }

        @Override
        public int compareTo(Node o) {
            return o.r - this.r;
        }
    }
}