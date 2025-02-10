import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static String s1, s2;
    static int N, M;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        s1 = br.readLine();
        s2 = br.readLine();

        N = s1.length();
        M = s2.length();
        arr = new int[N+1][M+1];

        for (int i = 1; i <= N; i++) {
            char c1 = s1.charAt(i-1);
            for (int j = 1; j <= M; j++) {
                char c2 = s2.charAt(j-1);

                if (c1 == c2) arr[i][j] = arr[i-1][j-1] + 1;
                else arr[i][j] = Math.max(arr[i-1][j], arr[i][j-1]);
            }
        }

        System.out.println(arr[N][M]);
    }
}