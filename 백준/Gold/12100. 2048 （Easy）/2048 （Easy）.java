import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int[][][] board;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        if (N == 1) {
            System.out.println(br.readLine());
            return;
        }

        board = new int[6][N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) board[0][i][j] = Integer.parseInt(st.nextToken());
        }

        dfs(0);

        System.out.println(max);
    }

    private static void dfs(int cnt) {
        if (cnt == 5) {
            max = Math.max(max, findMax());
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (i == 0) moveL(cnt);
            if (i == 1) moveR(cnt);
            if (i == 2) moveT(cnt);
            if (i == 3) moveD(cnt);
            dfs(cnt+1);
        }
    }

    private static int findMax() {
        int max = 0;
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                max = Math.max(max, board[5][i][j]);

//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < N; j++) {
//                System.out.print(board[5][i][j] + " ");
//            }
//            System.out.println();
//        }
//        System.out.println("max = " + max);
//        System.out.println();

        return max;
    }

    private static void moveL(int cnt) {
        for (int i = 0; i < N; i++) {
            int[] temp = new int[N];
            int tempIdx = 0;

            for (int j = 0; j < N; j++) {
                boolean flag = false;
                for (int k = j+1; k < N; k++) {

                    if (board[cnt][i][j] == 0) break;
                    if (board[cnt][i][k] != 0 && board[cnt][i][j] != board[cnt][i][k]) break;

                    if (board[cnt][i][j] == board[cnt][i][k] && board[cnt][i][j] != 0) {
                        temp[tempIdx++] = board[cnt][i][j] * 2;
                        j = k;
                        flag = true;
                        break;
                    }
                }

                if (!flag && board[cnt][i][j] != 0) {
                    temp[tempIdx++] = board[cnt][i][j];
                }
            }

            for (int j = 0; j < N; j++) {
                board[cnt + 1][i][j] = temp[j];
            }
        }
    }

    private static void moveR(int cnt) {
        for (int i = 0; i < N; i++) {
            int[] temp = new int[N];
            int tempIdx = N-1;

            for (int j = N-1; j >= 0; j--) {
                boolean flag = false;
                for (int k = j-1; k >= 0; k--) {

                    if (board[cnt][i][j] == 0) break;
                    if (board[cnt][i][k] != 0 && board[cnt][i][j] != board[cnt][i][k]) break;

                    if (board[cnt][i][j] == board[cnt][i][k] && board[cnt][i][j] != 0) {
                        temp[tempIdx--] = board[cnt][i][j] * 2;
                        j = k;
                        flag = true;
                        break;
                    }
                }

                if (!flag && board[cnt][i][j] != 0) {
                    temp[tempIdx--] = board[cnt][i][j];
                }
            }

            for (int j = 0; j < N; j++) {
                board[cnt + 1][i][j] = temp[j];
            }
        }
    }

    private static void moveT(int cnt) {
        for (int j = 0; j < N; j++) {
            int[] temp = new int[N];
            int tempIdx = 0;

            for (int i = 0; i < N; i++) {
                boolean flag = false;
                for (int k = i+1; k < N; k++) {

                    if (board[cnt][i][j] == 0) break;
                    if (board[cnt][k][j] != 0 && board[cnt][i][j] != board[cnt][k][j]) break;

                    if (board[cnt][i][j] == board[cnt][k][j] && board[cnt][i][j] != 0) {
                        temp[tempIdx++] = board[cnt][i][j] * 2;
                        i = k;
                        flag = true;
                        break;
                    }
                }

                if (!flag && board[cnt][i][j] != 0) {
                    temp[tempIdx++] = board[cnt][i][j];
                }
            }

            for (int i = 0; i < N; i++) {
                board[cnt + 1][i][j] = temp[i];
            }
        }
    }

    private static void moveD(int cnt) {
        for (int j = 0; j < N; j++) {
            int[] temp = new int[N];
            int tempIdx = N-1;

            for (int i = N-1; i >= 0; i--) {
                boolean flag = false;
                for (int k = i-1; k >= 0; k--) {

                    if (board[cnt][i][j] == 0) break;
                    if (board[cnt][k][j] != 0 && board[cnt][i][j] != board[cnt][k][j]) break;

                    if (board[cnt][i][j] == board[cnt][k][j] && board[cnt][i][j] != 0) {
                        temp[tempIdx--] = board[cnt][i][j] * 2;
                        i = k;
                        flag = true;
                        break;
                    }
                }

                if (!flag && board[cnt][i][j] != 0) {
                    temp[tempIdx--] = board[cnt][i][j];
                }
            }

            for (int i = 0; i < N; i++) {
                board[cnt + 1][i][j] = temp[i];
            }
        }
    }
}

// 보드는 시행 횟수 별로 존재. -> 5판만 있으면 된다.
// 복구 로직 필요 X
// 4방향 합치고 위치잡는 로직 구현 -> move()
// 이거 가지고 백트래킹
// 시행횟수 5회일때 최대 값 갱신 시도