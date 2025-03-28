import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M;
    static PriorityQueue<Long> Q = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        while (N-- > 0) Q.add(Long.parseLong(st.nextToken()));

        while (M-- > 0) {
            long a = Q.poll();
            long b = Q.poll();
            long num = a+b;
            Q.add(num);
            Q.add(num);
        }

        long answer = 0;
        for (long i : Q) answer += i;
        System.out.println(answer);
    }
}