import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int N;
    static Queue<Integer> queue = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) {
                if (!queue.isEmpty()) sb.append(-1*queue.remove()).append("\n");
                else sb.append("0\n");
            } else {
                queue.add(-1*num);
            }
        }

        System.out.println(sb);
    }
}

