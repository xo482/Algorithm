import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N , M;
    static int[] dr = new int[]{-1, 1, 0, 0};
    static int[] dc = new int[]{0, 0, 1, -1};
    static char[][] board;
    static ArrayDeque<Coin> Q = new ArrayDeque<>();
    static List<int[]> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new char[N][M];
        for (int i = 0; i < N; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                board[i][j] = line[j];
                if (board[i][j] == 'o') {
                    list.add(new int[]{i, j});
                }
            }
        }

        int[] p1 = list.get(0);
        int[] p2 = list.get(1);
        Coin coin = new Coin(p1[0], p1[1], p2[0], p2[1], 0);
        Q.addLast(coin);
        while (!Q.isEmpty()) {
            Coin now = Q.removeFirst();
            if (now.depth > 9) break;

            for (int i = 0; i < 4; i++) {
                int nr1 = now.r1 + dr[i];
                int nc1 = now.c1 + dc[i];
                int nr2 = now.r2 + dr[i];
                int nc2 = now.c2 + dc[i];

                int cnt = 0;
                if (nr1 >= N || nr1 < 0 || nc1 >= M || nc1 < 0) cnt++;
                if (nr2 >= N || nr2 < 0 || nc2 >= M || nc2 < 0) cnt++;
                if (cnt == 2) continue;
                if (cnt == 1) {
                    System.out.println(now.depth+1);
                    return;
                }

                if (board[nr1][nc1] == '#') {
                    nr1 = now.r1;
                    nc1 = now.c1;
                }
                if (board[nr2][nc2] == '#') {
                    nr2 = now.r2;
                    nc2 = now.c2;
                }

                Q.addLast(new Coin(nr1, nc1, nr2, nc2, now.depth + 1));
            }
        }
        System.out.println(-1);
    }
    static class Coin {
        int r1,r2,c1,c2;
        int depth;

        public Coin(int r1, int c1, int r2, int c2, int depth) {
            this.r1 = r1;
            this.r2 = r2;
            this.c1 = c1;
            this.c2 = c2;
            this.depth = depth;
        }
    }

}