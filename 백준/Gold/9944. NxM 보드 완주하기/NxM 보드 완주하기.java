import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int[] dr = new int[]{1, -1, 0, 0};
    static int[] dc = new int[]{0, 0, -1, 1};
    static char[][] board;
    static int N, M, total, min, T=1;

    public static void main(String[] args) throws IOException {
        while (true) {
            String s = br.readLine();
            if (s == null || s.isEmpty()) break;

            st = new StringTokenizer(s);
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            board = new char[N][M];

            total = 0;
            min = 1000001;
            for (int i = 0; i < N; i++) {
                char[] charArray = br.readLine().toCharArray();
                for (int j = 0; j < M; j++) {
                    board[i][j] = charArray[j];
                    if (board[i][j] == '.') total++;
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (board[i][j] == '*') continue;

                    board[i][j] = '@';
                    tracking(i, j, -1, 0, 0);
                    board[i][j] = '.';
                }
            }


            if (min == 1000001) sb.append("Case ").append(T++).append(": ").append(-1).append("\n");
            else sb.append("Case ").append(T++).append(": ").append(min).append("\n");
        }
        System.out.println(sb);
    }

    private static void tracking(int r, int c, int d, int cnt, int depth) {

        if (depth == total-1) {
            min = Math.min(min, cnt);
            return;
        }

        if (min <= cnt) return;

        for (int i = 0; i < 4; i++) {

            int nr = r + dr[i];
            int nc = c + dc[i];

            if (nr >= N || nr < 0 || nc >= M || nc < 0) continue;
            if (board[nr][nc] != '.') continue;

            // 그 방향으로 갈 수 있다.
            ArrayDeque<int[]> list = move(r, c, i);
            int[] nxt = list.peekLast();
            depth += list.size();

            if (d == i) tracking(nxt[0], nxt[1], i, cnt, depth);
            else tracking(nxt[0], nxt[1], i, cnt+1, depth);

            depth -= list.size();
            for (int[] ints : list) {
                board[ints[0]][ints[1]] = '.';
            }
        }
    }

    private static ArrayDeque<int[]> move(int r, int c, int d) {
        ArrayDeque<int[]> list = new ArrayDeque<>();
        while (true) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr >= N || nr < 0 || nc >= M || nc < 0) break;
            if (board[nr][nc] != '.') break;

            list.add(new int[]{nr, nc});
            board[nr][nc] = '@';
            r = nr;
            c = nc;
        }

        return list;
    }
}