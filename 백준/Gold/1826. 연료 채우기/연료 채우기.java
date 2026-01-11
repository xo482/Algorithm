import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, cnt = 0;
    static PriorityQueue<Integer> position = new PriorityQueue<>();
    static PriorityQueue<Integer> best = new PriorityQueue<>((o1, o2) -> o2 - o1);
    static Map<Integer, Integer> station = new HashMap<>();

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            station.put(p, c);
            position.add(p);
        }

        st = new StringTokenizer(br.readLine());
        int home = Integer.parseInt(st.nextToken());
        int pos = Integer.parseInt(st.nextToken());

        while (true) {
            if (pos >= home) break;
            while (!position.isEmpty() && position.peek() <= pos) {
                int p = position.poll();
                int c = station.get(p);
                best.add(c);
            }

            if (best.isEmpty()) break;
            pos += best.poll();
            cnt++;
        }

        if (pos >= home) System.out.println(cnt);
        else System.out.println(-1);
    }
}