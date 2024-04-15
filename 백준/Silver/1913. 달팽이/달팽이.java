import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int I = 0;
    static int J = 0;
    static int[][] arr;
    static int[] dr = new int[] {-1, 0, 1, 0};
    static int[] dc = new int[] {0, 1, 0, -1};
    static int index = 0;
    static int number;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        number = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        int i = N/2; // r
        int j = N/2; // c
        arr[i][j] = 1;
        if (1 == number) {
            I = i+1;
            J = j+1;
        }

        int cnt = 1;
        int ele = 2;
        while (true) {
            for (int k = 0; k < 2; k++) {
                for (int l = 0; l < cnt; l++) {
                    i += dr[index];
                    j += dc[index];
                    if (i== -1) break;
                    if (ele == number) {
                        I = i+1;
                        J = j+1;
                    }
                    arr[i][j] = ele++;
                }
                if (i== -1) break;
                turn();
            }
            if (i== -1) break;
            cnt++;
        }


        for (int[] ints : arr) {
            for (int anInt : ints) {
                sb.append(anInt).append(" ");
            }
            sb.append("\n");
        }
        sb.append(I).append(" ").append(J);
        System.out.print(sb);
    }

    private static void turn() {
        index++;
        index %= 4;
    }
}
