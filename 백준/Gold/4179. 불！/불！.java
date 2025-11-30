import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int R, C;
    static char[][] board;
    static int[] dr = new int[]{-1, 1, 0, 0};
    static int[] dc = new int[]{0, 0, 1, -1};
    static ArrayDeque<Node> pQ = new ArrayDeque<>();
    static ArrayDeque<Node> fQ = new ArrayDeque<>();
    static int time = 0;
    static boolean flag = false;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        board = new char[R][C];

        for (int i = 0; i < R; i++) {
            char[] chars = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                board[i][j] = chars[j];
                if (board[i][j] == 'J') pQ.add(new Node(i, j));
                if (board[i][j] == 'F') fQ.add(new Node(i, j));
            }
        }

        while (!pQ.isEmpty()) {

            time++;

            int size = pQ.size();
            for (int i = 0; i < size; i++) {
                Node now = pQ.removeFirst();
                if (board[now.r][now.c] != 'J') continue;

                for (int j = 0; j < 4; j++) {
                    int nr = now.r + dr[j];
                    int nc = now.c + dc[j];
                    if (nr >= R || nr < 0 || nc >= C || nc < 0) { flag = true; break; }
                    if (board[nr][nc] != '.') continue;

                    board[nr][nc] = 'J';
                    pQ.add(new Node(nr, nc));
                }
                if (flag) break;
            }
            if (flag) break;

            size = fQ.size();
            for (int i = 0; i < size; i++) {
                Node now = fQ.removeFirst();

                for (int j = 0; j < 4; j++) {
                    int nr = now.r + dr[j];
                    int nc = now.c + dc[j];
                    if (nr >= R || nr < 0 || nc >= C || nc < 0) continue;
                    if (board[nr][nc] == 'F') continue;
                    if (board[nr][nc] == '#') continue;

                    board[nr][nc] = 'F';
                    fQ.add(new Node(nr, nc));
                }
            }
        }

        if (flag) System.out.println(time);
        else System.out.println("IMPOSSIBLE");
    }

    static class Node {
        int r, c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}