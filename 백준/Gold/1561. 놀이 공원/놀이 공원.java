import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M;
    static int[] nori;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        nori = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) nori[i] = Integer.parseInt(st.nextToken());

        long start = -1;
        long end = (N / M + 1) * 30L;
        long cnt;

        while (start + 1 < end) {
            long mid = (start + end) / 2;

            cnt = M;
            for (int i = 0; i < M; i++) {
                cnt += mid / nori[i];
            }

            if (cnt >= N) end = mid;
            else start = mid;
        }

        cnt = M;
        for (int i = 0; i < M; i++) {
            cnt += end / nori[i];
        }


        for (int i = M-1; i >= 0; i--) {
            if (end % nori[i] == 0) {
                if (cnt == N) { System.out.println(i + 1); break; }
                cnt--;
            }
        }
    }
}
