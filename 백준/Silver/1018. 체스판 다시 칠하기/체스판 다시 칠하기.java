import java.io.*;
import java.util.*;

public class Main {

    static String[][] white = new String[8][8];
    static String[][] black = new String[8][8];
    static String[][] board;

    public static void init() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (((i + j) % 2) == 0) {
                    white[i][j] = "W";
                    black[i][j] = "B";
                } else {
                    white[i][j] = "B";
                    black[i][j] = "W";
                }
            }
        }
    }

    public static int requiredBlock(int y, int x) {
        int cntWhite = 0;
        int cntBlack = 0;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i + y][j + x].equals(white[i][j])) cntWhite++;
                if (board[i + y][j + x].equals(black[i][j])) cntBlack++;
            }
        }

        return Math.min(cntWhite, cntBlack);
    }

    public static void main(String[] args) throws IOException {
        init();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] size = br.readLine().split(" ");
        int N = Integer.parseInt(size[0]);
        int M = Integer.parseInt(size[1]);
        int min = 64;
        board = new String[N][M];

        for (int i = 0; i < N; i++) {
            String[] colors = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                board[i][j] = colors[j];
            }
        }

        for (int i = 0; i+7 < N; i++) {
            for (int j = 0; j+7 < M; j++) {
                int temp = requiredBlock(i,j);
                if (min > temp) min = temp;
            }
        }

        System.out.println(min);
    } // main end
}