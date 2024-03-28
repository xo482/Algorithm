import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int[][] arr;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        // init
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) arr[i][j] = Integer.parseInt(st.nextToken());
        }

        for (int k = 0; k < N; k++)
            for (int i = 0; i < N; i++)
                for (int j = 0; j < N; j++)
                    if (arr[i][k] + arr[k][j] == 2)
                        arr[i][j] = 1;

        // print
        for (int[] ints : arr) {
            for (int anInt : ints) sb.append(anInt).append(" ");
            sb.append("\n");
        }
        System.out.print(sb);
    }


}
