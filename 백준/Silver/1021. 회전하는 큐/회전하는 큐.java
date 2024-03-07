import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int len = Integer.parseInt(st.nextToken());
        int cnt = Integer.parseInt(st.nextToken());
        int move = 0, now = 0;

        // 큐 초기화
        List<Integer> queue = new ArrayList<>();
        for (int i = 0; i < len; i++) queue.add(i + 1);

        // logic
        String[] findNumbers = br.readLine().split(" ");
        for (String s : findNumbers) {
            Integer number = Integer.parseInt(s);
            int length = findNumbers.length;

            int next = queue.indexOf(number);

            // 정배 거리
            int a = Math.abs(now - next);

            // 역배 거리
            int b = 0;
            if (now < next) {
                b = now + queue.size() - next;
            } else if (now > next) {
                b = next + queue.size() - now;
            }

            int add = Math.min(a, b);
            move += add;
            now = next;
            queue.remove(now);
        }
        System.out.println(move);
    } // main end
} // Main end
