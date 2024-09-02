import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] arr = new int[5][5];
    static int cnt = 0;

    public static void main(String[] args) throws IOException {

        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                int num = Integer.parseInt(st.nextToken());

                for (int k = 0; k < 5; k++) {
                    for (int l = 0; l < 5; l++) {
                        if (num == arr[k][l]) {
                            arr[k][l] = 0;
                            if (check()) {

                                System.out.println(i*5+j+1);

                                return;
                            }
                        }
                    }
                }

            }
        }
    }

    private static boolean check() {
        cnt = 0;
        for (int k = 0; k < 5; k++) {

            boolean flagR = true;
            for (int i = 0; i < 5; i++) {
                if (arr[i][k] != 0)
                    flagR = false;
            }
            if (flagR) cnt++;
        }

        for (int i = 0; i < 5; i++) {
            boolean falgC = true;
            for (int j = 0; j < 5; j++)
                if (arr[i][j] != 0)
                    falgC = false;

            if (falgC) cnt++;
        }
        if (arr[0][0] == 0 && arr[1][1] == 0 && arr[2][2] == 0 && arr[3][3] == 0 && arr[4][4] == 0) cnt++;
        if (arr[4][0] == 0 && arr[3][1] == 0 && arr[2][2] == 0 && arr[1][3] == 0 && arr[0][4] == 0) cnt++;

        if (cnt >= 3) {
            return true;
        }
        return false;
    }
}