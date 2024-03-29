import java.io.*;
import java.util.*;

public class Main {

    static int[][] arr;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (Math.abs(o1) == Math.abs(o2))
                    return o1 - o2;
                return Math.abs(o1) - Math.abs(o2);
            }
        });

        while (N-- > 0) {
            int num = Integer.parseInt(br.readLine());

            if (num == 0) {
                if (queue.isEmpty()) {
                    sb.append("0\n");
                    continue;
                }

                sb.append(queue.remove()).append("\n");

            } else {
                queue.add(num);
            }
        }

        System.out.println(sb);
    }
}
