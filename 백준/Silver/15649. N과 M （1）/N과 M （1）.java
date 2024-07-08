import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int M;
    static int[] arr;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);

        visited = new boolean[N];
        arr = new int[M];

        tracking(0);
        System.out.println(sb);
    }

    private static void tracking(int cnt) {
        if (cnt == M) {
            for (int i : arr) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[cnt] = i + 1;
                tracking(cnt+1);
                visited[i] = false;
            }
        }
    }
}