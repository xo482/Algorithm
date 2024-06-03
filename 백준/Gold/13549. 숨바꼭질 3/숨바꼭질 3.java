import java.io.*;
import java.util.*;

// 40분 시작

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int N = Integer.parseInt(split[0]);
        int K = Integer.parseInt(split[1]);
        int[] arr = new int[100_001];
        boolean[] visited = new boolean[100_001];

        // init
        for (int i = 0; i < 100_001; i++)
            arr[i] = 100_001;

        ArrayDeque<Integer> Q = new ArrayDeque<>();
        arr[N] = 0;
        Q.add(N);

        while(!Q.isEmpty()) {
            int now = Q.removeFirst();
            if (now < 100_001 && now >= 0 && !visited[now]) {
                visited[now] = true;
                if (now+1 < 100_001) {
                    arr[now + 1] = Math.min(arr[now + 1], arr[now] + 1);
                    Q.addLast(now + 1);
                }
                if (now-1 >= 0){
                    arr[now-1] = Math.min(arr[now-1], arr[now] + 1);
                    Q.addLast(now - 1);
                }
                if (now*2 < 100_001){
                    arr[now*2] = Math.min(arr[now*2], arr[now]);
                    Q.addLast(now * 2);
                }
            }
        }

        System.out.println(arr[K]);
    }
}