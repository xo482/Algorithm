import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M;
    static List<Integer>[] list;
    static boolean[] visited;


    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        list = new List[N+1];
        visited = new boolean[N+1];
        for (int i = 1; i < N + 1; i++) list[i] = new ArrayList<>();

        for (int i = 1; i < N+1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < N+1; j++) {
               int x = Integer.parseInt(st.nextToken());
               if(x == 1) {
                   list[i].add(j);
                   list[j].add(i);
               }
            }
        }

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[M];
        for (int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        ArrayDeque<Integer> Q = new ArrayDeque<>();
        Q.addLast(arr[0]);
        while (!Q.isEmpty()) {
            int now = Q.removeFirst();

            if (visited[now]) continue;
            visited[now] = true;
            for (int x : list[now]) {
                if (!visited[x]) Q.addLast(x);
            }
        }

        boolean flag = false;
        for (int i = 0; i < M; i++) {
            if (!visited[arr[i]]) {
                flag = true;
                break;
            }
        }
        if (flag) System.out.println("NO");
        else System.out.println("YES");
    }
}