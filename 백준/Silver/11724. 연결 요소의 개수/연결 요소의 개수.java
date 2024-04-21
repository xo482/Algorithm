import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N + 1][N + 1];
        boolean[] visited = new boolean[N + 1];
        int cnt = 0;

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            arr[start][end] = 1;
            arr[end][start] = 1;
        }

        for (int i = 1; i <= N; i++) {
            if (visited[i]) continue;

            ArrayDeque<Integer> Q = new ArrayDeque<>();
            cnt++;
            visited[i] = true;
            Q.addLast(i);
            while (!Q.isEmpty()) {
                int start = Q.removeFirst();
                for (int end = 1; end <= N; end++) {
                    if (!visited[end] && arr[start][end] == 1) {
                        visited[end] = true;
                        Q.addLast(end);
                    }
                }
            }
        }

        System.out.println(cnt);
    }
}
