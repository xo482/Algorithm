import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static long N, M;
    static long[] table;
    static long min = Long.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Long.parseLong(st.nextToken());
        M = Long.parseLong(st.nextToken());
        table = new long[(int)N];

        for (int i = 0; i < N; i++) {
            table[i] = Long.parseLong(br.readLine());
            min = Math.min(min, table[i]);
        }

        long start = 0;
        long end = M*min;
        while (start + 1 < end) {
            long mid = (start + end) / 2;

            long able = 0;
            for (int i = 0; i < N; i++)
                able += mid / table[i];

            if (able >= M) end = mid;
            else start = mid;
        }
        System.out.println(end);
    }
}