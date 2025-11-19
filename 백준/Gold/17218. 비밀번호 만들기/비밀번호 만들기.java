import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int[][] board;

    public static void main(String[] args) throws Exception {
        String str = " " + br.readLine();
        String str2 = " " + br.readLine();
        board = new int[str.length()][str2.length()];

        for (int i = 1; i < str.length(); i++) {
            for (int j = 1; j < str2.length(); j++) {
                if (str.charAt(i) == str2.charAt(j)) {
                    board[i][j] = board[i - 1][j - 1] + 1;
                    continue;
                }

                board[i][j] = Math.max(board[i - 1][j], board[i][j - 1]);
            }
        }

        int i = str.length() - 1;
        int j = str2.length() - 1;
        while (true) {

            if (board[i][j] == 0) break;

            if (board[i][j] == board[i - 1][j]) {
                i -= 1;
                continue;
            }

            if (board[i][j] == board[i][j-1]) {
                j -= 1;
                continue;
            }

            sb.append(str.charAt(i));
            i -= 1;
            j -= 1;
        }

        System.out.println(sb.reverse());
    }
}