import java.io.*;
import java.util.*;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] board = new int[9][9];
    static List<int[]> emptyList = new ArrayList<>();
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 9; i++) {
            String[] st = br.readLine().split("");
            for (int j = 0; j < 9; j++) {
                board[i][j] = Integer.parseInt(st[j]);
                if (board[i][j] == 0){
                    emptyList.add(new int[]{i, j});
                    cnt++;
                }
            }
        }

        dfs(0);
    }

    static boolean dfs(int idx) {
        if (cnt == 0) {
            printBoard();
            return true;
        }
        int[] ints = emptyList.get(idx);
        int r = ints[0];
        int c = ints[1];

        boolean[] list = getNumber(r, c);
        for (int k = 1; k < 10; k++) {
            if (list[k]) {
                cnt--;
                board[r][c] = k;

                // 다음 위치로 이동
                if (dfs(idx+1)) {
                    return true;
                }
                board[r][c] = 0;
                cnt++;
            }
        }

        return false;
    }


    // 특정 자리의 들어올 수 있는 수를 검사
    // 가능한 애들만 true로 만든 배열 반환
    static boolean[] getNumber(int r, int c) {
        boolean[] checkR = new boolean[10];
        boolean[] checkC = new boolean[10];
        boolean[] checkPad = new boolean[10];
        boolean[] answer = new boolean[10];

        for (int j = 0; j < 9; j++) {
            checkR[board[r][j]] = true;
        }
        for (int i = 0; i < 9; i++) {
            checkC[board[i][c]] = true;
        }
        for (int i = r - r % 3; i < r - r % 3 + 3; i++) {
            for (int j = c - c % 3; j < c - c % 3 + 3; j++) {
                checkPad[board[i][j]] = true;
            }
        }

        for (int i = 0; i < 10; i++) {
            if (!checkR[i] && !checkC[i] && !checkPad[i]) {
                answer[i] = true;
            }
        }
        return answer;
    }

    static void printBoard() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append(board[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
