import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int N;
    static PriorityQueue<Integer> Q = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            if (Math.abs(o1) == Math.abs(o2)) return o1 - o2;
            return Math.abs(o1) - Math.abs(o2);
        }
    });

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            int cal = Integer.parseInt(br.readLine());
            if (cal == 0){
                if (Q.isEmpty()) sb.append("0\n");
                if (!Q.isEmpty()) sb.append(Q.poll()).append("\n");
                continue;
            }
            Q.add(cal);
        }
        System.out.println(sb.toString());
    }
}