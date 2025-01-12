import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] dr = new int[]{1, 0, -1, 0};
    static int[] dc = new int[]{0, -1, 0, 1};
    static int N, M;
    static int[][] board;
    static int[][] copyBoard;
    static List<int[]> cctv = new ArrayList<>();
    static int[] select;
    static int min = 64;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        copyBoard = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (1 <= board[i][j] && board[i][j] <= 5)
                    cctv.add(new int[]{i, j});
            }
        }

        select = new int[cctv.size()];
        tracking(0);
        System.out.println(min);
    }

    private static void tracking(int idx) {
        if (idx == cctv.size()) {
            for (int i = 0; i < N; i++) 
                copyBoard[i] = Arrays.copyOf(board[i], board[0].length);
            
            search();
            min = Math.min(min, count());
            return;
        }

        for (int d = 0; d < 4; d++) {
            select[idx] = d;
            tracking(idx + 1);
        }
    }

    private static void search() {
        for (int i = 0; i < cctv.size(); i++) {
            int r = cctv.get(i)[0];
            int c = cctv.get(i)[1];
            int d = select[i];
            int category = board[r][c];

            if (category == 1) {
                go(r, c, d);
            }
            if (category == 2) {
                go(r, c, d);
                go(r, c, (d+2)%4);
            }
            if (category == 3) {
                go(r, c, d);
                go(r, c, (d+1)%4);
            }
            if (category == 4) {
                go(r, c, d);
                go(r, c, (d+1)%4);
                go(r, c, (d+2)%4);
            }
            if (category == 5) {
                for (int j = 0; j < 4; j++)
                    go(r, c, j);
            }
        }
    }

//    private static void tracking(int idx) {
//        if (idx == cctv.size()) {
//            min = Math.min(min, count());
//            return;
//        }
//
//        for (int i = idx; i < cctv.size(); i++) {
//            int r = cctv.get(i)[0];
//            int c = cctv.get(i)[1];
//            int category = board[r][c];
//
//            if (category == 1) {
//                for (int d = 0; d < 4; d++) {
//                    go(r, c, d);
//                    tracking(idx + 1);
//                }
//            }
//            if (category == 2) {
//                for (int d = 0; d < 2; d++) {
//                    go(r, c, d); go(r, c, d+2);
//                    tracking(idx + 1);
//                }
//            }
//            if (category == 3) {
//                for (int d = 0; d < 4; d++) {
//                    go(r, c, d); go(r, c, (d+1)%4);
//                    tracking(idx + 1);
//                }
//            }
//            if (category == 4) {
//                for (int d = 0; d < 4; d++) {
//                    go(r, c, d); go(r, c, (d+1)%4); go(r, c, (d+2)%4);
//                    tracking(idx + 1);
//                }
//            }
//            if (category == 5) {
//                for (int d = 0; d < 4; d++) go(r, c, d);
//                tracking(idx + 1);
//            }
//        }
//    }

    static void go(int r, int c, int direction) {
        while (true) {
            r+=dr[direction];
            c+=dc[direction];

            if (r < 0 || c < 0 || r >= N || c >= M) break;
            if (copyBoard[r][c] == 6) break;
            if (1 <= copyBoard[r][c] && copyBoard[r][c] <= 5) continue;

            copyBoard[r][c] += 10;
        }
    }

    static int count() {
        int cnt = 0;
        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++)
                if (copyBoard[i][j] == 0)
                    cnt++;

        return cnt;
    }
}