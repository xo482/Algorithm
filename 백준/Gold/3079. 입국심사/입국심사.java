import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M;
    static int[] table;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        table = new int[N];

        for (int i = 0; i < N; i++) {
            table[i] = Integer.parseInt(br.readLine());
            min = Math.min(min, table[i]);
        }

        long start = 0;
        long end = (long) M * min;
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