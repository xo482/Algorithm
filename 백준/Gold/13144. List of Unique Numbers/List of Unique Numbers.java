import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static long ans = 0;
    static int[] arr;
    static int[] visited;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        visited = new int[100001];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) arr[i] = Integer.parseInt(st.nextToken());

        int p1 = 1;
        int p2 = 0;

        while (p1 < N) {
            while (p2 + 1 <= N && visited[arr[p2+1]] == 0) {
                p2++;
                visited[arr[p2]]++;
            }

            ans += p2 - p1;
            visited[arr[p1]]--;
            p1++;
        }

        System.out.println(ans+N);
    }
}