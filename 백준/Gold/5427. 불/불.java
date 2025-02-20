import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int T, N, M;
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

            ArrayDeque<Unit> fireQ = new ArrayDeque<>();
            ArrayDeque<Unit> UserQ = new ArrayDeque<>();


            for (int i = 0; i < N; i++) {
                char[] chars = br.readLine().toCharArray();
                for (int j = 0; j < M; j++) {
                    board[i][j] = chars[j];
                    if (board[i][j] == '@') UserQ.add(new Unit(i, j, 0));
                    if (board[i][j] == '*') fireQ.add(new Unit(i, j, 0));
                }
            }

            boolean check = false;
            while (!(UserQ.isEmpty() && fireQ.isEmpty())) {
                if (UserQ.isEmpty()) break;
                int size = UserQ.size();
                for (int i = 0; i < size; i++) {
                    Unit now = UserQ.removeFirst();
                    for (int j = 0; j < 4; j++) {
                        int nr = now.r + dr[j];
                        int nc = now.c + dc[j];

                        if (nr >= N || nr < 0 || nc >= M || nc < 0) {
                            sb.append(now.time + 1).append("\n");
                            check = true;
                            break;
                        }
                        if (board[nr][nc] != '.') continue;

                        boolean flag = false;
                        for (int k = 0; k < 4; k++) {
                            int nnr = nr + dr[k];
                            int nnc = nc + dc[k];

                            if (nnr >= N || nnr < 0 || nnc >= M || nnc < 0) continue;
                            if (board[nnr][nnc] != '*') continue;

                            flag = true;
                        }
                        if (flag) continue;

                        board[nr][nc] = '@';
                        UserQ.addLast(new Unit(nr, nc, now.time + 1));
                    }
                    if (check) break;
                }
                if (check) break;


                if (fireQ.isEmpty()) continue;
                size = fireQ.size();
                for (int i = 0; i < size; i++) {
                    Unit now = fireQ.removeFirst();

                    for (int j = 0; j < 4; j++) {
                        int nr = now.r + dr[j];
                        int nc = now.c + dc[j];

                        if (nr >= N || nr < 0 || nc >= M || nc < 0) continue;
                        if (board[nr][nc] == '#' || board[nr][nc] == '*') continue;

                        board[nr][nc] = '*';
                        fireQ.add(new Unit(nr, nc, 0));
                    }
                }


            }
            if (!check) sb.append("IMPOSSIBLE\n");;
        }
        System.out.println(sb);

//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < M; j++) {
//                System.out.print(board[i][j] + " ");
//            }
//            System.out.println();
//        }
    }
    static class Unit {

        int r, c;
        int time;

        public Unit(int r, int c, int time) {
            this.r = r;
            this.c = c;
            this.time = time;
        }
    }
}
