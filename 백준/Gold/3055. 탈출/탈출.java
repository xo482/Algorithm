import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int R, C;
    static int eR, eC;
    static int[] dr = new int[]{-1, 1, 0, 0};
    static int[] dc = new int[]{0, 0, 1, -1};
    static char[][] board;
    static ArrayDeque<Doch> dochQ = new ArrayDeque<>();
    static ArrayDeque<Water> waterQ = new ArrayDeque<>();


    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        board = new char[R][C];

        for (int i = 0; i < R; i++) {
            char[] chars = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                board[i][j] = chars[j];
                if (board[i][j] == 'S') dochQ.add(new Doch(i, j, 0));
                if (board[i][j] == '*') waterQ.add(new Water(i, j));
                if (board[i][j] == 'D') { eR = i; eC = j; }
            }
        }

        while (!dochQ.isEmpty()) {
            int size = waterQ.size();
            while (size-- > 0) {
                Water water = waterQ.removeFirst();

                for (int i = 0; i < 4; i++) {
                    int nr = water.r + dr[i];
                    int nc = water.c + dc[i];
                    if (nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
                    if (board[nr][nc] == '*' || board[nr][nc] == 'X' || board[nr][nc] == 'D') continue;

                    board[nr][nc] = '*';
                    waterQ.add(new Water(nr, nc));
                }
            }


            size = dochQ.size();
            while (size-- > 0) {
                Doch doch = dochQ.removeFirst();


                for (int i = 0; i < 4; i++) {
                    int nr = doch.r + dr[i];
                    int nc = doch.c + dc[i];

                    if (nr == eR && nc == eC) {
                        System.out.println(doch.time+1);
                        return;
                    }

                    if (nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
                    if (board[nr][nc] != '.') continue;

                    board[nr][nc] = 'D';
                    dochQ.add(new Doch(nr, nc, doch.time + 1));
                }
            }
        }

        System.out.println("KAKTUS");
    }

    static class Water {
        int r, c;

        public Water(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    static class Doch {
        int r, c, time;

        public Doch(int r, int c, int time) {
            this.r = r;
            this.c = c;
            this.time = time;
        }
    }
}