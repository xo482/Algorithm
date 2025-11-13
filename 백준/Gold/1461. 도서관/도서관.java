import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M;
    static PriorityQueue<Integer> positive = new PriorityQueue<>((o1, o2) -> o1 > o2 ? -1 : 1);
    static PriorityQueue<Integer> negative = new PriorityQueue<>((o1, o2) -> o1 > o2 ? -1 : 1);
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (num > 0) positive.add(num);
            if (num < 0) negative.add(-num);
        }

        while (!positive.isEmpty()) {
            int num = positive.poll();
            for (int i = 0; i < M - 1; i++) {
                if (positive.isEmpty()) break;
                positive.poll();
            }
            list.add(num);
        }

        while (!negative.isEmpty()) {
            int num = negative.poll();
            for (int i = 0; i < M - 1; i++) {
                if (negative.isEmpty()) break;
                negative.poll();
            }
            list.add(num);
        }
        
        int sum = 0;
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            sum += 2 * list.get(i);
        }
        System.out.println(sum - list.get(list.size() - 1));
    }
}
