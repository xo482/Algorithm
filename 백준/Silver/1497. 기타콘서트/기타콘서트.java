import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M;
    static long[] guitars;
    static long ans_possible = 0, ans_guitar = 0;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        guitars = new long[N];

        for (int i = 0; i < N; i++) {
            String s = br.readLine().split(" ")[1];
            long num = 0;
            for (int j = 0; j < M; j++) {
                if (s.charAt(j) == 'N') continue;
                num += (1L << (M - j - 1));
            }
            guitars[i] = num;
        }

        int len = 1 << N;
        for (int i = 0; i < len; i++) {

            long possible_cnt = 0;
            for (int j = 0; j < N; j++) {
                if ((i & (1 << j)) <= 0) continue;

                possible_cnt = possible_cnt | guitars[j];
            }

            if (possible_cnt == ans_possible && Integer.bitCount(i) < ans_guitar) {
                ans_guitar = Integer.bitCount(i);
                continue;
            }

            if (possible_cnt > ans_possible) {
                ans_possible = possible_cnt;
                ans_guitar = Integer.bitCount(i);
            }
        }

        if (ans_guitar == 0) System.out.println(-1);
        else System.out.println(ans_guitar);
    }
}