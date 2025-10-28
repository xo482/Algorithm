import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int T, N;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            PriorityQueue<Long> pq = new PriorityQueue<>();
            N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) pq.add(Long.parseLong(st.nextToken()));

            long answer = 1;
            while (pq.size() > 1) {
                long a = pq.poll();
                long b = pq.poll();
                long now = a*b % 1000000007;
                answer = (answer * now) % 1000000007;
                pq.add(a * b);
            }
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }
}