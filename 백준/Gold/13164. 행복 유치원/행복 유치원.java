import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, K, ans = 0;
    static PriorityQueue<Integer> pq = new PriorityQueue<>();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N - 1; i++) {
            int e = Integer.parseInt(st.nextToken());
            pq.add(e - s);
            s = e;
        }

        for (int i = 0; i < N - K; i++) ans += pq.poll();
        System.out.println(ans);
    }
}