import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, K;
    static PriorityQueue<int[]> Q = new PriorityQueue<>(new Comparator<int[]>() {
        @Override
        public int compare(int[] o1, int[] o2) {
            return o1[1] - o2[1];
        }
    });
    static int[] arr = new int[100001];
    static int[] visited = new int[100001];

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        Arrays.fill(arr, 1000000000);

        Q.add(new int[]{N, 0});
        while (!Q.isEmpty()) {
            int[] now = Q.poll();

            if (arr[now[0]] < now[1]) continue;


            if (arr[now[0]] == now[1]) visited[now[0]]++;
            else visited[now[0]] = 1;
            
            arr[now[0]] = now[1];

            if (now[0] - 1 >= 0 && arr[now[0] - 1] >= now[1]+1)
                Q.add(new int[]{now[0] - 1, now[1] + 1});

            if (now[0] + 1 < 100001 && arr[now[0] + 1] >= now[1]+1)
                Q.add(new int[]{now[0] + 1, now[1] + 1});

            if (now[0] * 2 < 100001 && arr[now[0] * 2] >= now[1]+1)
                Q.add(new int[]{now[0] * 2, now[1] + 1});
        }

        System.out.println(arr[K]);
        System.out.println(visited[K]);
    }
}