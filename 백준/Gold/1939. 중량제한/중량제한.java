import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M;
    static int[] maxWightArr;
    static List<int[]>[] list;
    static PriorityQueue<int[]> Q = new PriorityQueue<>(new Comparator<int[]>() {
        @Override
        public int compare(int[] o1, int[] o2) {
            return o2[1] - o1[1];
        }
    });

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        maxWightArr = new int[N + 1];
        list = new List[N + 1];
        for (int i = 0; i < N + 1; i++) list[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list[a].add(new int[]{b, w});
            list[b].add(new int[]{a, w});
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        Q.add(new int[]{start, Integer.MAX_VALUE});
        while (!Q.isEmpty()) {
            int[] now = Q.poll();

            if (maxWightArr[now[0]] > now[1]) continue;

            for (int[] next : list[now[0]]) {
                if (maxWightArr[next[0]] >= Math.min(now[1], next[1])) continue;

                int w = Math.min(now[1], next[1]);
                maxWightArr[next[0]] = w;
                Q.add(new int[]{next[0], w});
            }
        }

//        for (int i : maxWightArr) {
//            System.out.print(i+ " ");
//        }
//        System.out.println();
        System.out.println(maxWightArr[end]);
    }
}

