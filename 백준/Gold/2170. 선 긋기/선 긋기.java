import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int total = 0;
    static PriorityQueue<int[]> Q = new PriorityQueue<>(new Comparator<int[]>() {
        @Override
        public int compare(int[] o1, int[] o2) {
            return o1[0] - o2[0];
        }
    });

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            Q.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }

        int[] now = Q.poll();
        while (!Q.isEmpty()) {

            int[] nxt = Q.poll();
            if (nxt[0] > now[1]) {
                total += now[1]-now[0];
                now[0] = nxt[0];
            }

            now[1] = Math.max(now[1], nxt[1]);
        }

        total += now[1]-now[0];
        System.out.println(total);
    }
}