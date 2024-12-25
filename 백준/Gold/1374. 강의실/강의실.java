import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static List<Integer> list = new ArrayList<>();
    static PriorityQueue<int[]> Q = new PriorityQueue<>(new Comparator<int[]>() {
        @Override
        public int compare(int[] o1, int[] o2) {
            if (o1[0] == o2[0]) return o1[1] - o2[1];
            return o1[0] - o2[0];
        }
    });

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        while(N-- > 0) {
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            Q.add(new int[]{start, end});
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(Q.poll()[1]);
        int max = 1;

        while(!Q.isEmpty()) {
            int[] poll = Q.poll();
            int start = poll[0];
            int end = poll[1];

            if (pq.peek() <= start) pq.poll();
            pq.add(end);
        }

        System.out.println(pq.size());
    }
}
