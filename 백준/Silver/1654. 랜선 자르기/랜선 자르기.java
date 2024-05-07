import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int K;
    static int[] list;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        list = new int[N];

        int max = 0;
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, list[i]);
        }

        long start = 1;
        long end = max;
        long mid = 0;
        while (true) {
            mid = (start + end) / 2;
            if (start > end) break;

            int sum = 0;
            for (int i = 0; i < N; i++) {
                sum += (list[i] / mid);
            }

            if (sum < K) end = mid - 1;
            if (sum >= K) start = mid + 1;
        }

        System.out.print(mid);
    }
}
