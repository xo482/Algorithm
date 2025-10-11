import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, K, D;
    static List<Kwochix> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        while (K-- > 0) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int jump = Integer.parseInt(st.nextToken());

            list.add(new Kwochix(start, end, jump));
        }

        int start = 0;
        int end = N;
        while (start + 1 < end) {
            int mid = (start + end) / 2;

            long sum = 0;
            for (Kwochix kwochix : list) {
                if (kwochix.start > mid) continue;
                if (kwochix.end < mid) {
                    sum += (kwochix.end - kwochix.start) / kwochix.jump + 1;
                    continue;
                }

                int part = (mid - kwochix.start) / kwochix.jump + 1;
                sum += part;
            }

            if (sum >= D) end = mid;
            else start = mid;
        }

        System.out.println(end);
    }

    static class Kwochix {
        int start, end, jump;

        public Kwochix(int start, int end, int jump) {
            this.start = start;
            this.end = end;
            this.jump = jump;
        }
    }
}