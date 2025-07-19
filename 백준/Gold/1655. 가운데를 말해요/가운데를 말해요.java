import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static PriorityQueue<Integer> rQ = new PriorityQueue<>();
    static PriorityQueue<Integer> lQ = new PriorityQueue<>((o1, o2) -> o2 - o1);
    static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        for (int i = 1; i <= N; i++){
            int number = Integer.parseInt(br.readLine());
            if (i == 1) {
                lQ.add(number);
                sb.append(lQ.peek()).append("\n");
                continue;
            }

            if (lQ.peek() < number) {
                rQ.add(number);
                if (i % 2 == 1) lQ.add(rQ.poll());
            }
            else {
                lQ.add(number);
                if (i % 2 == 0) rQ.add(lQ.poll());
            }

            sb.append(lQ.peek()).append("\n");
        }
        System.out.print(sb);
    }
}