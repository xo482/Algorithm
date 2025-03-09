import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int T, N, M;
    static ArrayDeque<Point> fireQ, personQ;
    static char[][] board;
    static int[] dr = new int[]{1, -1, 0, 0};
    static int[] dc = new int[]{0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());

            board = new char[N][M];
            fireQ = new ArrayDeque<>();
            personQ = new ArrayDeque<>();

            for (int i = 0; i < N; i++) {
                char[] charArray = br.readLine().toCharArray();
                for (int j = 0; j < M; j++) {
                    board[i][j] = charArray[j];
                    if (board[i][j] == '*') fireQ.add(new Point(i, j));
                    if (board[i][j] == '@') personQ.add(new Point(i, j));
                }
            }

            int cnt = 0;
            boolean flag = false;
            while (!personQ.isEmpty()) {
                int size = fireQ.size();
                for (int i = 0; i < size; i++) {
                    Point now = fireQ.removeFirst();

                    for (int j = 0; j < 4; j++) {
                        int nr = now.r + dr[j];
                        int nc = now.c + dc[j];

                        if (nr >= N || nr < 0 || nc >= M || nc < 0) continue;
                        if (board[nr][nc] == '#') continue;
                        if (board[nr][nc] == '*') continue;

                        board[nr][nc] = '*';
                        fireQ.add(new Point(nr, nc));
                    }
                }

                cnt++;
                size = personQ.size();
                for (int i = 0; i < size; i++) {
                    Point now = personQ.removeFirst();

                    for (int j = 0; j < 4; j++) {
                        int nr = now.r + dr[j];
                        int nc = now.c + dc[j];


                        if (nr >= N || nr < 0 || nc >= M || nc < 0) { flag = true; break; }
                        if (board[nr][nc] == '.') {
                            board[nr][nc] = '@';
                            personQ.add(new Point(nr, nc));
                        }
                    }
                    if (flag) break;
                }
                if (flag) break;
            }

            if (flag) sb.append(cnt).append("\n");
            else sb.append("IMPOSSIBLE\n");
        }
        System.out.println(sb);
    }

    static class Point{
        int r, c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}