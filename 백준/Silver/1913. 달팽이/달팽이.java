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
    static int[] dr = new int[] {1, 0, -1, 0};
    static int[] dc = new int[] {0, 1, 0, -1};
    static int index = 0;
    static int target;
    static int number;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        target = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        number = N*N;

        int i = 0;
        int j = 0;
        while(number != 0){
            if (number == target) {
                I = i+1;
                J = j+1;
            }
            arr[i][j] = number--;

            if (check(i + dr[index], j + dc[index])) {
                i += dr[index];
                j += dc[index];
            } else {
                turn();
                i += dr[index];
                j += dc[index];
            }
        }

        for (int[] ints : arr) {
            for (int anInt : ints) sb.append(anInt).append(" ");
            sb.append("\n");
        }
        sb.append(I).append(" ").append(J);
        System.out.print(sb);
    }

    private static void turn() {
        index++;
        index %= 4;
    }
    private static boolean check(int i, int j) {
        if (i >= 0 && j >= 0 && i < N && j < N && arr[i][j] == 0) return true;
        return false;
    }
}
