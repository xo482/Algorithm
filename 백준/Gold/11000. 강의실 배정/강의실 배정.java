import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static PriorityQueue<int[]> Q = new PriorityQueue<>(new Comparator<int[]>() {
        @Override
        public int compare(int[] o1, int[] o2) {
            if (o1[0] == o2[0]) return o1[1] - o2[1];
            return o1[0] - o2[0];
        }
    });
    static PriorityQueue<Integer> list = new PriorityQueue<>(Integer::compareTo);

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            Q.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }

        int max = 1;
        int[] remove = Q.remove();
        list.add(remove[1]);

        while (!Q.isEmpty()) {
            int[] now = Q.remove();
            int start = now[0];

            while(true) {
                Integer peek = list.peek();
                if (start >= peek) list.remove();
                else break;
            }

            list.add(now[1]);
            max = Math.max(max, list.size());
        }

        System.out.print(max);
    }
}