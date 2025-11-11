import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static long[] arr;
    static int[] visited;
    static long answer = 0;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new long[N];
        visited = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
            if (arr[i] != 0) {
                answer += arr[i];
                visited[i] = 1;
            }
        }

        int test = 0;
        for (int i = 0; i < N; i++) {
            if (visited[i] != 0) continue;
            if (visited[(i+1) % N] == 2) continue;
            if (visited[(i - 1 +N) % N] == 2) continue;
            test++;
            visited[i] = 2;
        }

        for (int i = 0; i < N; i++) if (visited[i] == 2) visited[i] = 0;

        int test2 = 0;
        for (int i = 1; i < N; i++) {
            if (visited[i] != 0) continue;
            if (visited[(i+1) % N] == 2) continue;
            if (visited[(i - 1 +N) % N] == 2) continue;
            test2++;
            visited[i] = 2;
        }

        answer += Math.max(test, test2);
        System.out.println(answer);
    }
}
