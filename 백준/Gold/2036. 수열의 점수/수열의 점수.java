import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, zero_cnt;
    static long answer = 0;
    static PriorityQueue<Long> positive = new PriorityQueue<>((o1, o2) -> o2 - o1 >= 0 ? 1 : -1);
    static PriorityQueue<Long> negative = new PriorityQueue<>();

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            long num = Long.parseLong(br.readLine());
            if (num == 1) {
                answer += 1;
                continue;
            }
            if (num > 0) {
                positive.add(num);
                continue;
            }
            if (num < 0) {
                negative.add(num);
                continue;
            }

            zero_cnt++;
        }

        while (positive.size() >= 2) {
            long a = positive.poll();
            long b = positive.poll();
            answer += a * b;
        }
        if (!positive.isEmpty()) answer += positive.poll();

        while (negative.size() >= 2) {
            long a = negative.poll();
            long b = negative.poll();
            answer += a * b;
        }
        if (!negative.isEmpty() && zero_cnt == 0) answer += negative.poll();

        System.out.println(answer);
    }
}