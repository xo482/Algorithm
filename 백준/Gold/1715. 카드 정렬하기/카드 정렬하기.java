import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static long answer = 0;
    static PriorityQueue<Integer> pq = new PriorityQueue<>();

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++)
            pq.add(Integer.parseInt(br.readLine()));

        while (pq.size() > 1) {
            int num = pq.poll() + pq.poll();
            answer += num;
            pq.add(num);
        }
        System.out.println(answer);
    }
}