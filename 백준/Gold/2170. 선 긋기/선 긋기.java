import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int total = 0;
    static PriorityQueue<Integer> sQ = new PriorityQueue<>();
    static PriorityQueue<Integer> eQ = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            sQ.add(Integer.parseInt(st.nextToken()));
            eQ.add(Integer.parseInt(st.nextToken()));
        }

        int start = sQ.poll();
        int end = eQ.poll();
        while (!sQ.isEmpty() && !eQ.isEmpty()) {

            int nxtStart = sQ.poll();
            int nxtEnd = eQ.poll();

            if (nxtStart > end) {
                total += end-start;
                start = nxtStart;
            }

            end = nxtEnd;
        }

        total += end-start;
        System.out.println(total);
    }

}