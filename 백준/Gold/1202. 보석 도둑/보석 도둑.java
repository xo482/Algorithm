import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, K;
    static PriorityQueue<Jewel> jewelQ = new PriorityQueue<>(new Comparator<Jewel>() {
        @Override
        public int compare(Jewel o1, Jewel o2) {
            if (o1.w == o2.w) return o2.v - o1.v;
            return o1.w - o2.w;
        }
    });
    static PriorityQueue<Integer> bagQ = new PriorityQueue<>();
    static PriorityQueue<Jewel> Q = new PriorityQueue<>(new Comparator<Jewel>() {
        @Override
        public int compare(Jewel o1, Jewel o2) {
            return o2.v - o1.v;
        }
    });

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            jewelQ.add(new Jewel(w, v));
        }

        while (K-- > 0) {
            int bag = Integer.parseInt(br.readLine());
            bagQ.add(bag);
        }

        long answer = 0;
        while (!bagQ.isEmpty()) {
            int bag = bagQ.poll();
            while (jewelQ.peek() != null && jewelQ.peek().w <= bag) {
                Jewel jewel = jewelQ.poll();
                Q.add(jewel);
            }

            if (!Q.isEmpty()) {
                answer += Q.poll().v;
            }
        }

        System.out.println(answer);
    }

    static class Jewel {
        int w;
        int v;

        Jewel(int w, int v) {
            this.w = w;
            this.v = v;
        }
    }
}